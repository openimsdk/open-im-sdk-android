package io.openim.android.sdk.manager;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import io.openim.android.sdk.internal.schedule.Schedulers;
import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnAdvanceMsgListener;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnMsgSendCallback;
import io.openim.android.sdk.models.HaveReadInfo;
import io.openim.android.sdk.models.Message;
import io.openim.android.sdk.service.MessageService;
import io.openim.android.sdk.util.CommonUtil;
import io.openim.android.sdk.util.JsonUtil;
import io.openim.android.sdk.util.Predicates;
import open_im_sdk.Open_im_sdk;
import open_im_sdk.SendMsgCallBack;

/**
 * 消息管理器
 */
public class MessageManager implements MessageService {

    private static final List<WeakReference<OnAdvanceMsgListener>> listeners = new CopyOnWriteArrayList<>();
    private static boolean initialized = false;
    private static final open_im_sdk.OnAdvancedMsgListener sdkListener = new open_im_sdk.OnAdvancedMsgListener() {
        @Override
        public void onRecvC2CReadReceipt(String s) {
            for (WeakReference<OnAdvanceMsgListener> r : listeners) {
                if (r.get() != null) {
                    List<HaveReadInfo> list = JsonUtil.toArray(s, HaveReadInfo.class);
                    r.get().onRecvC2CReadReceipt(list);
                }
            }

        }

        @Override
        public void onRecvMessageRevoked(String s) {
            for (WeakReference<OnAdvanceMsgListener> r : listeners) {
                if (r.get() != null) {
                    r.get().onRecvMessageRevoked(s);
                }
            }

        }

        @Override
        public void onRecvNewMessage(String s) {
            for (WeakReference<OnAdvanceMsgListener> r : listeners) {
                if (r.get() != null) {
                    Message msg = JsonUtil.toObj(s, Message.class);
                    r.get().onRecvNewMessage(msg);
                }
            }

        }
    };

    /**
     * 添加消息监听
     * <p>
     * 当对方撤回条消息：onRecvMessageRevoked，通过回调将界面已显示的消息替换为"xx撤回了一套消息"
     * 当对方阅读了消息：onRecvC2CReadReceipt，通过回调将已读的消息更改状态。
     * 新增消息：onRecvNewMessage，向界面添加消息
     */
    @Override
    public void addAdvancedMsgListener(@NonNull OnAdvanceMsgListener listener) {
        Predicates.requireNonNull(listener);

        listeners.add(new WeakReference<>(listener));
        if (!initialized) {
            initialized = true;
            Open_im_sdk.addAdvancedMsgListener(sdkListener);
        }
    }

    /**
     * 移除消息监听
     */
    @Override
    public void removeAdvancedMsgListener(OnAdvanceMsgListener listener) {
        final Iterator<WeakReference<OnAdvanceMsgListener>> it = listeners.iterator();
        while (it.hasNext()) {
            if (it.next().get() == listener) {
                it.remove();
                break;
            }
        }
        if (listeners.isEmpty()) {
            initialized = false;
            Open_im_sdk.removeAdvancedMsgListener(sdkListener);
        }
    }

    /**
     * 发送消息
     *
     * @param message        消息体{@link Message}
     * @param recvUid        接受者用户id
     * @param recvGid        群id
     * @param onlineUserOnly 仅在线用户接受
     * @param base           callback
     *                       onProgress:消息发送进度，如图片，文件，视频等消息
     */
    @Override
    public void sendMessage(Message message, String recvUid, String recvGid, boolean onlineUserOnly, OnMsgSendCallback base) {
        Open_im_sdk.sendMessage(new SendMsgCallBack() {
            @Override
            public void onError(long l, String s) {
                if (null != base) {
                    CommonUtil.returnError(base, l, s);
                }
            }

            @Override
            public void onProgress(long l) {
                if (null != base) {
                    Schedulers.runOnMainThread(() -> base.onProgress(l));
                }
            }

            @Override
            public void onSuccess(String s) {
                if (null != base) {
                    CommonUtil.returnSuccess(base, s);
                }
            }
        }, JsonUtil.toString(message), recvUid, recvGid, onlineUserOnly);
    }

    @Override
    public void recallMessage(@NonNull Message message, OnBase<String> callback) {
        revokeMessage(callback, Predicates.requireNonNull(message));
    }

    /**
     * 获取历史消息
     *
     * @param userID   用户id
     * @param groupID  组ID
     * @param startMsg 从startMsg {@link Message}开始拉取消息
     *                 startMsg：如第一次拉取20条记录 startMsg=null && count=20 得到 list；
     *                 下一次拉取消息记录参数：startMsg=list.get(0) && count =20；以此内推，startMsg始终为list的第一条。
     * @param count    一次拉取count条
     * @param base     callback List<{@link Message}>
     */
    @Override
    public void getHistoryMessageList(String userID, String groupID, Message startMsg, int count, OnBase<List<Message>> base) {
        Map<String, Object> map = new ArrayMap<>();
        map.put("userID", userID);
        map.put("groupID", groupID);
        map.put("startMsg", startMsg);
        map.put("count", count);
        Open_im_sdk.getHistoryMessageList(BaseImpl.arrayBase(base, Message.class), JsonUtil.toString(map));
    }

    /**
     * 撤回消息
     *
     * @param message {@link Message}
     * @param base    callback String
     *                撤回成功需要将已显示到界面的消息类型替换为revoke类型并刷新界面
     */
    public void revokeMessage(OnBase<String> base, Message message) {
        Open_im_sdk.revokeMessage(BaseImpl.stringBase(base), JsonUtil.toString(message));
    }

    /**
     * 删除消息
     *
     * @param message {@link Message}
     * @param base    callback String
     *                删除成功需要将已显示到界面的消息移除
     */
    public void deleteMessageFromLocalStorage(OnBase<String> base, Message message) {
        Open_im_sdk.deleteMessageFromLocalStorage(BaseImpl.stringBase(base), JsonUtil.toString(message));
    }

    public void deleteMessages(OnBase<String> base, List<Message> message) {
//        Open_im_sdk.deleteMessages(BaseImpl.stringBase(base), JSON.toJSONString(message));
    }

    /**
     * 插入单挑消息到本地
     *
     * @param message  {@link Message}
     * @param receiver 接收者
     * @param sender   发送者
     * @param base     callback String
     */
    public void insertSingleMessageToLocalStorage(OnBase<String> base, Message message, String receiver, String sender) {
        Open_im_sdk.insertSingleMessageToLocalStorage(BaseImpl.stringBase(base), JsonUtil.toString(message), receiver, sender);
    }

    /**
     * 根据消息id批量查询消息记录
     *
     * @param messageIDList 消息id(clientMsgID)集合
     * @param base          callback List<{@link Message}>
     */
    public void findMessages(OnBase<List<Message>> base, List<String> messageIDList) {
        Open_im_sdk.findMessages(BaseImpl.arrayBase(base, Message.class), JsonUtil.toString(messageIDList));
    }

    /**
     * 标记消息已读
     * 会触发userid的onRecvC2CReadReceipt方法
     *
     * @param userID        聊天对象id
     * @param messageIDList 消息clientMsgID列表
     * @param base          callback String
     */
    public void markC2CMessageAsRead(OnBase<String> base, String userID, List<String> messageIDList) {
        Open_im_sdk.markC2CMessageAsRead(BaseImpl.stringBase(base), userID, JsonUtil.toString(messageIDList));
    }

    /**
     * 提示对方我正在输入
     *
     * @param userID 用户ID
     * @param typing true：输入中 false：输入停止
     */
    public void typingStatusUpdate(String userID, boolean typing) {
        Open_im_sdk.typingStatusUpdate(userID, typing ? "YES" : "NO");
    }

    /**
     * 创建文本消息
     *
     * @param text 内容
     * @return {@link Message}
     */
    public Message createTextMessage(String text) {
        return parse(Open_im_sdk.createTextMessage(text));
    }

    /**
     * 创建@文本消息
     *
     * @param text      内容
     * @param atUidList 用户id列表
     * @return {@link Message}
     */
    public Message createTextAtMessage(String text, List<String> atUidList) {
        return parse(Open_im_sdk.createTextAtMessage(text, JsonUtil.toString(atUidList)));
    }

    /**
     * 创建图片消息（
     * initSDK时传入了数据缓存路径，如路径：A，这时需要你将图片复制到A路径下后，如 A/pic/a.png路径，imagePath的值：“/pic/.png”
     *
     * @param imagePath 相对路径
     * @return {@link Message}
     */
    public Message createImageMessage(String imagePath) {
        return parse(Open_im_sdk.createImageMessage(imagePath));
    }

    /**
     * 创建图片消息
     *
     * @param imagePath 绝对路径
     * @return {@link Message}
     */
    public Message createImageMessageFromFullPath(String imagePath) {
        return parse(Open_im_sdk.createImageMessageFromFullPath(imagePath));
    }

    /**
     * 创建声音消息
     * initSDK时传入了数据缓存路径，如路径：A，这时需要你将声音文件复制到A路径下后，如 A/voice/a.m4c路径，soundPath的值：“/voice/.m4c”
     *
     * @param soundPath 相对路径
     * @param duration  时长
     * @return {@link Message}
     */
    public Message createSoundMessage(String soundPath, long duration) {
        return parse(Open_im_sdk.createSoundMessage(soundPath, duration));
    }

    /**
     * 创建声音消息
     *
     * @param soundPath 绝对路径
     * @param duration  时长
     * @return {@link Message}
     */
    public Message createSoundMessageFromFullPath(String soundPath, long duration) {
        return parse(Open_im_sdk.createSoundMessageFromFullPath(soundPath, duration));
    }

    /**
     * 创建视频消息
     * initSDK时传入了数据缓存路径，如路径：A，这时需要你将声音文件复制到A路径下后，如 A/video/a.mp4路径，soundPath的值：“/video/.mp4”
     *
     * @param videoPath    视频相对路径
     * @param videoType    mine type
     * @param duration     时长
     * @param snapshotPath 缩略图相对路径
     * @return {@link Message}
     */
    public Message createVideoMessage(String videoPath, String videoType, long duration, String snapshotPath) {
        return parse(Open_im_sdk.createVideoMessage(videoPath, videoType, duration, snapshotPath));
    }

    /**
     * 创建视频消息
     *
     * @param videoPath    绝对路径
     * @param videoType    mine type
     * @param duration     时长
     * @param snapshotPath 缩略图绝对路径
     * @return {@link Message}
     */
    public Message createVideoMessageFromFullPath(String videoPath, String videoType, long duration, String snapshotPath) {
        return parse(Open_im_sdk.createVideoMessageFromFullPath(videoPath, videoType, duration, snapshotPath));
    }

    /**
     * 创建文件消息
     * initSDK时传入了数据缓存路径，如路径：A，这时需要你将声音文件复制到A路径下后，如 A/file/a.txt路径，soundPath的值：“/file/.txt”
     *
     * @param filePath 相对路径
     * @param fileName 文件名
     * @return {@link Message}
     */
    public Message createFileMessage(String filePath, String fileName) {
        return parse(Open_im_sdk.createFileMessage(filePath, fileName));
    }

    /**
     * 创建合并消息
     *
     * @param title       标题
     * @param summaryList 摘要
     * @param messageList 消息列表
     * @return {@link Message}
     */
    public Message createMergerMessage(List<Message> messageList, String title, List<String> summaryList) {
        return parse(Open_im_sdk.createMergerMessage(JsonUtil.toString(messageList), title, JsonUtil.toString(summaryList)));
    }

    /**
     * 创建转发消息
     *
     * @param messageList 消息列表
     * @return {@link Message}
     */
    public Message createForwardMessage(List<Message> messageList) {
        return parse(Open_im_sdk.createForwardMessage(JsonUtil.toString(messageList)));
    }

    /**
     * 创建位置消息
     *
     * @param latitude    经度
     * @param longitude   纬度
     * @param description 描述消息
     * @return {@link Message}
     */
    public Message createLocationMessage(double latitude, double longitude, String description) {
        return parse(Open_im_sdk.createLocationMessage(description, longitude, latitude));
    }

    /**
     * 创建自定义消息
     *
     * @param data        json String
     * @param extension   json String
     * @param description 描述
     * @return {@link Message}
     */
    public Message createCustomMessage(String data, String extension, String description) {
        return parse(Open_im_sdk.createCustomMessage(data, extension, description));
    }

    /**
     * 创建引用消息
     *
     * @param text    内容
     * @param message 被引用的消息体
     * @return {@link Message}
     */
    public Message createQuoteMessage(String text, Message message) {
        return parse(Open_im_sdk.createQuoteMessage(text, JsonUtil.toString(message)));
    }

    /**
     * 创建名片消息
     *
     * @param content json String
     * @return {@link Message}
     */
    public Message createCardMessage(String content) {
        return parse(Open_im_sdk.createCardMessage(content));
    }

    public void forceSyncMsg() {
        Open_im_sdk.forceSyncMsg();
    }

    static Message parse(String msg) {
        return JsonUtil.toObj(msg, Message.class);
    }
}
