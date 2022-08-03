package io.openim.android.sdk.manager;


import androidx.collection.ArrayMap;

import java.util.List;
import java.util.Map;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnAdvanceMsgListener;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnMsgSendCallback;
import io.openim.android.sdk.listener._AdvanceMsgListener;
import io.openim.android.sdk.listener._MsgSendProgressListener;
import io.openim.android.sdk.models.AtUserInfo;
import io.openim.android.sdk.models.Message;
import io.openim.android.sdk.models.OfflinePushInfo;
import io.openim.android.sdk.models.SearchResult;
import io.openim.android.sdk.utils.JsonUtil;
import io.openim.android.sdk.utils.ParamsUtil;
import open_im_sdk.Open_im_sdk;

/**
 * 消息管理器
 */
public class MessageManager {
    /**
     * 添加消息监听
     * <p>
     * 当对方撤回条消息：onRecvMessageRevoked，通过回调将界面已显示的消息替换为"xx撤回了一套消息"
     * 当对方阅读了消息：onRecvC2CReadReceipt，通过回调将已读的消息更改状态。
     * 新增消息：onRecvNewMessage，向界面添加消息
     */
    public void setAdvancedMsgListener(OnAdvanceMsgListener listener) {
        Open_im_sdk.setAdvancedMsgListener(new _AdvanceMsgListener(listener));
    }

    /**
     * 发送消息
     *
     * @param message         消息体{@link Message}
     * @param recvUid         接受者用户id
     * @param recvGid         群id
     * @param offlinePushInfo 离线推送内容
     * @param base            callback
     *                        onProgress:消息发送进度，如图片，文件，视频等消息
     */
    public void sendMessage(OnMsgSendCallback base, Message message, String recvUid, String recvGid, OfflinePushInfo offlinePushInfo) {
        Open_im_sdk.sendMessage(new _MsgSendProgressListener(base), ParamsUtil.buildOperationID(), JsonUtil.toString(message), recvUid, recvGid, JsonUtil.toString(offlinePushInfo));
    }

    /**
     * 获取历史消息
     *
     * @param userID         用户id
     * @param groupID        组ID
     * @param conversationID 会话id，如果不传userID跟groupID，则按会话id查询历史记录
     * @param startMsg       从startMsg {@link Message}开始拉取消息
     *                       startMsg：如第一次拉取20条记录 startMsg=null && count=20 得到 list；
     *                       下一次拉取消息记录参数：startMsg=list.get(0) && count =20；以此内推，startMsg始终为list的第一条。
     * @param count          一次拉取count条
     * @param base           callback List<{@link Message}>
     */
    public void getHistoryMessageList(OnBase<List<Message>> base, String userID, String groupID, String conversationID, Message startMsg, int count) {
        Map<String, Object> map = new ArrayMap<>();
        map.put("userID", userID);
        map.put("groupID", groupID);
        map.put("conversationID", conversationID);
        if (null != startMsg) {
            map.put("startClientMsgID", startMsg.getClientMsgID());
        }
        map.put("count", count);
        Open_im_sdk.getHistoryMessageList(BaseImpl.arrayBase(base, Message.class), ParamsUtil.buildOperationID(), JsonUtil.toString(map));
    }

    /**
     * 撤回消息
     * 调用此方法会触发：onRecvMessageRevoked和onRecvNewMessage回调
     *
     * @param message {@link Message}
     * @param base    callback String
     *                撤回成功需要将已显示到界面的消息类型替换为revoke类型并刷新界面
     */
    @Deprecated
    public void revokeMessage(OnBase<String> base, Message message) {
        Open_im_sdk.revokeMessage(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), JsonUtil.toString(message));
    }

    /**
     * 删除消息
     *
     * @param message {@link Message}
     * @param base    callback String
     *                删除成功需要将已显示到界面的消息移除
     */
    public void deleteMessageFromLocalStorage(OnBase<String> base, Message message) {
        Open_im_sdk.deleteMessageFromLocalStorage(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), JsonUtil.toString(message));
    }

//    public void deleteMessages(OnBase<String> base, List<Message> message) {
//        Open_im_sdk.deleteMessages(BaseImpl.stringBase(base), JSON.toJSONString(message));
//    }

    /**
     * 插入单挑消息到本地
     *
     * @param message  {@link Message}
     * @param receiver 接收者
     * @param sender   发送者
     * @param base     callback String
     */
    public void insertSingleMessageToLocalStorage(OnBase<String> base, Message message, String receiver, String sender) {
        Open_im_sdk.insertSingleMessageToLocalStorage(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), JsonUtil.toString(message), receiver, sender);
    }

    /**
     * 根据消息id批量查询消息记录
     *
     * @param messageIDList 消息id(clientMsgID)集合
     * @param base          callback List<{@link Message}>
     */
//    public void findMessages(OnBase<List<Message>> base, List<String> messageIDList) {
//        Open_im_sdk.findMessages(BaseImpl.arrayBase(base, Message.class), JsonUtil.toString(messageIDList));
//    }

    /**
     * 标记消息已读
     * 会触发userid的onRecvC2CReadReceipt方法
     *
     * @param userID        聊天对象id
     * @param messageIDList 消息clientMsgID列表
     * @param base          callback String
     */
    public void markC2CMessageAsRead(OnBase<String> base, String userID, List<String> messageIDList) {
        Open_im_sdk.markC2CMessageAsRead(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), userID, JsonUtil.toString(messageIDList));
    }

    /**
     * 标记消息已读
     * 会触发userid的onRecvGroupReadReceipt方法
     *
     * @param groupID       聊天组id
     * @param messageIDList 消息clientMsgID列表
     * @param base          callback String
     */
    public void markGroupMessageAsRead(OnBase<String> base, String groupID, List<String> messageIDList) {
        Open_im_sdk.markGroupMessageAsRead(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), groupID, JsonUtil.toString(messageIDList));
    }

    /**
     * 提示对方我正在输入
     *
     * @param userID 用户ID
     * @param msgTip 提示信息
     */
    public void typingStatusUpdate(OnBase<String> base, String userID, String msgTip) {
        Open_im_sdk.typingStatusUpdate(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), userID, msgTip);
    }

    /**
     * 创建文本消息
     *
     * @param text 内容
     * @return {@link Message}
     */
    public Message createTextMessage(String text) {
        return parse(Open_im_sdk.createTextMessage(ParamsUtil.buildOperationID(), text));
    }

    /**
     * 创建@文本消息
     *
     * @param text           内容
     * @param atUserIDList   用户id列表
     * @param atUserInfoList 被@的用户id跟昵称映射
     * @param quoteMessage   @消息带引用消息
     * @return {@link Message}
     */
    public Message createTextAtMessage(String text, List<String> atUserIDList, List<AtUserInfo> atUserInfoList, Message quoteMessage) {
        return parse(Open_im_sdk.createTextAtMessage(ParamsUtil.buildOperationID(), text, JsonUtil.toString(atUserIDList), JsonUtil.toString(atUserInfoList), JsonUtil.toString(quoteMessage)));
    }

    /**
     * 创建图片消息（
     * initSDK时传入了数据缓存路径，如路径：A，这时需要你将图片复制到A路径下后，如 A/pic/a.png路径，imagePath的值：“/pic/.png”
     *
     * @param imagePath 相对路径
     * @return {@link Message}
     */
    public Message createImageMessage(String imagePath) {
        return parse(Open_im_sdk.createImageMessage(ParamsUtil.buildOperationID(), imagePath));
    }

    /**
     * 创建图片消息
     *
     * @param imagePath 绝对路径
     * @return {@link Message}
     */
    public Message createImageMessageFromFullPath(String imagePath) {
        return parse(Open_im_sdk.createImageMessageFromFullPath(ParamsUtil.buildOperationID(), imagePath));
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
        return parse(Open_im_sdk.createSoundMessage(ParamsUtil.buildOperationID(), soundPath, duration));
    }

    /**
     * 创建声音消息
     *
     * @param soundPath 绝对路径
     * @param duration  时长
     * @return {@link Message}
     */
    public Message createSoundMessageFromFullPath(String soundPath, long duration) {
        return parse(Open_im_sdk.createSoundMessageFromFullPath(ParamsUtil.buildOperationID(), soundPath, duration));
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
        return parse(Open_im_sdk.createVideoMessage(ParamsUtil.buildOperationID(), videoPath, videoType, duration, snapshotPath));
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
        return parse(Open_im_sdk.createVideoMessageFromFullPath(ParamsUtil.buildOperationID(), videoPath, videoType, duration, snapshotPath));
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
        return parse(Open_im_sdk.createFileMessage(ParamsUtil.buildOperationID(), filePath, fileName));
    }

    /**
     * 创建文件消息
     * initSDK时传入了数据缓存路径，如路径：A，这时需要你将声音文件复制到A路径下后，如 A/file/a.txt路径，soundPath的值：“/file/.txt”
     *
     * @param filePath 绝对路径
     * @param fileName 文件名
     * @return {@link Message}
     */
    public Message createFileMessageFromFullPath(String filePath, String fileName) {
        return parse(Open_im_sdk.createFileMessageFromFullPath(ParamsUtil.buildOperationID(), filePath, fileName));
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
        return parse(Open_im_sdk.createMergerMessage(ParamsUtil.buildOperationID(), JsonUtil.toString(messageList), title, JsonUtil.toString(summaryList)));
    }

    /**
     * 创建转发消息
     *
     * @param message 消息体
     * @return {@link Message}
     */
    public Message createForwardMessage(Message message) {
        return parse(Open_im_sdk.createForwardMessage(ParamsUtil.buildOperationID(), JsonUtil.toString(message)));
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
        return parse(Open_im_sdk.createLocationMessage(ParamsUtil.buildOperationID(), description, longitude, latitude));
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
        return parse(Open_im_sdk.createCustomMessage(ParamsUtil.buildOperationID(), data, extension, description));
    }

    /**
     * 创建引用消息
     *
     * @param text    内容
     * @param message 被引用的消息体
     * @return {@link Message}
     */
    public Message createQuoteMessage(String text, Message message) {
        return parse(Open_im_sdk.createQuoteMessage(ParamsUtil.buildOperationID(), text, JsonUtil.toString(message)));
    }

    /**
     * 创建名片消息
     *
     * @param content json String
     * @return {@link Message}
     */
    public Message createCardMessage(String content) {
        return parse(Open_im_sdk.createCardMessage(ParamsUtil.buildOperationID(), content));
    }

    /**
     * 创建自定义表情
     *
     * @param index 位置表情，表情的位置
     * @param data  url表情，json String : {"url":"","width":0,"height":0}
     * @return {@link Message}
     */
    public Message createFaceMessage(long index, String data) {
        return parse(Open_im_sdk.createFaceMessage(ParamsUtil.buildOperationID(), index, data));
    }

    /**
     * 聊天设置里清除聊天记录
     *
     * @param uid 用户id
     */
    public void clearC2CHistoryMessage(OnBase<String> base, String uid) {
        Open_im_sdk.clearC2CHistoryMessage(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), uid);
    }

    /**
     * 聊天设置里清除聊天记录
     *
     * @param gid 群id
     */
    public void clearGroupHistoryMessage(OnBase<String> base, String gid) {
        Open_im_sdk.clearGroupHistoryMessage(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), gid);
    }

    /**
     * 搜索消息
     *
     * @param conversationID       根据会话查询，如果是全局搜索传null
     * @param keywordList          搜索关键词列表，目前仅支持一个关键词搜索
     * @param keywordListMatchType 关键词匹配模式，1代表与，2代表或，暂时未用
     * @param senderUserIDList     指定消息发送的uid列表 暂时未用
     * @param messageTypeList      消息类型列表
     * @param searchTimePosition   搜索的起始时间点。默认为0即代表从现在开始搜索。UTC 时间戳，单位：秒
     * @param searchTimePeriod     从起始时间点开始的过去时间范围，单位秒。默认为0即代表不限制时间范围，传24x60x60代表过去一天
     * @param pageIndex            当前页数
     * @param count                每页数量
     */
    public void searchLocalMessages(OnBase<SearchResult> base,
                                    String conversationID,
                                    List<String> keywordList,
                                    int keywordListMatchType,
                                    List<String> senderUserIDList,
                                    List<Integer> messageTypeList,
                                    int searchTimePosition,
                                    int searchTimePeriod,
                                    int pageIndex,
                                    int count) {

        Map<String, Object> map = new ArrayMap<>();
        map.put("conversationID", conversationID);
        map.put("keywordList", keywordList);
        map.put("keywordListMatchType", keywordListMatchType);
        map.put("senderUserIDList", senderUserIDList);
        map.put("messageTypeList", messageTypeList);
        map.put("searchTimePosition", searchTimePosition);
        map.put("searchTimePeriod", searchTimePeriod);
        map.put("pageIndex", pageIndex);
        map.put("count", count);
        Open_im_sdk.searchLocalMessages(BaseImpl.objectBase(base, SearchResult.class), ParamsUtil.buildOperationID(), JsonUtil.toString(map));
    }

    /**
     * 删除本地跟服务器消息
     *
     * @param message 消息体
     */
    public void deleteMessageFromLocalAndSvr(OnBase<String> base, Message message) {
        Open_im_sdk.deleteMessageFromLocalAndSvr(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), JsonUtil.toString(message));
    }

    /**
     * 删除本地所有消息
     */
    public void deleteAllMsgFromLocal(OnBase<String> base) {
        Open_im_sdk.deleteAllMsgFromLocal(BaseImpl.stringBase(base), ParamsUtil.buildOperationID());
    }

    /**
     * 删除本地跟服务器所有消息
     */
    public void deleteAllMsgFromLocalAndSvr(OnBase<String> base) {
        Open_im_sdk.deleteAllMsgFromLocalAndSvr(BaseImpl.stringBase(base), ParamsUtil.buildOperationID());
    }

    /**
     * 标记会话全部已读，用于OA通知类消息
     *
     * @param conversationID 会话id
     * @param messageIDList  消息clientID列表
     */
    public void markMessageAsReadByConID(OnBase<String> base, String conversationID, List<String> messageIDList) {
        Open_im_sdk.markMessageAsReadByConID(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), conversationID, JsonUtil.toString(messageIDList));
    }

    /**
     * 聊天设置里清除聊天记录
     *
     * @param uid 用户id
     */
    public void clearC2CHistoryMessageFromLocalAndSvr(OnBase<String> base, String uid) {
        Open_im_sdk.clearC2CHistoryMessageFromLocalAndSvr(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), uid);
    }

    /**
     * 聊天设置里清除聊天记录
     *
     * @param gid 群id
     */
    public void clearGroupHistoryMessageFromLocalAndSvr(OnBase<String> base, String gid) {
        Open_im_sdk.clearGroupHistoryMessageFromLocalAndSvr(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), gid);
    }

    /**
     * 获取历史消息
     * 在搜索消息时定位到消息位置，获取新消息列表
     * getHistoryMessageList是获取该条消息之前的记录（旧消息），getHistoryMessageListReverse是获取该条消息之后的记录（新消息）
     *
     * @param userID         用户id
     * @param groupID        组ID
     * @param conversationID 会话id，如果不传userID跟groupID，则按会话id查询历史记录
     * @param startMsg       从startMsg {@link Message}开始拉取消息
     *                       startMsg：如第一次拉取20条记录 startMsg=null && count=20 得到 list；
     *                       下一次拉取消息记录参数：startMsg=list.last && count =20；以此内推，startMsg始终为list的最后一条。
     * @param count          一次拉取count条
     * @param base           callback List<{@link Message}>
     */
    public void getHistoryMessageListReverse(OnBase<List<Message>> base, String userID, String groupID, String conversationID, Message startMsg, int count) {
        Map<String, Object> map = new ArrayMap<>();
        map.put("userID", userID);
        map.put("groupID", groupID);
        map.put("conversationID", conversationID);
        if (null != startMsg) {
            map.put("startClientMsgID", startMsg.getClientMsgID());
        }
        map.put("count", count);
        Open_im_sdk.getHistoryMessageListReverse(BaseImpl.arrayBase(base, Message.class), ParamsUtil.buildOperationID(), JsonUtil.toString(map));
    }

    /**
     * 撤回消息（新版本）
     * 调用此方法会触发：onRecvMessageRevokedV2回调
     *
     * @param message {@link Message}
     * @param base    callback String
     */
    public void revokeMessageV2(OnBase<String> base, Message message) {
        Open_im_sdk.newRevokeMessage(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), JsonUtil.toString(message));
    }

    /**
     * 获取历史消息（超级群使用）
     * 在搜索消息时定位到消息位置，获取新消息列表
     * getHistoryMessageList是获取该条消息之前的记录（旧消息），getHistoryMessageListReverse是获取该条消息之后的记录（新消息）
     *
     * @param userID         用户id
     * @param groupID        组ID
     * @param conversationID 会话id，如果不传userID跟groupID，则按会话id查询历史记录
     * @param startMsg       从startMsg {@link Message}开始拉取消息
     *                       startMsg：如第一次拉取20条记录 startMsg=null && count=20 得到 list；
     *                       下一次拉取消息记录参数：startMsg=list.last && count =20；以此内推，startMsg始终为list的最后一条。
     * @param count          一次拉取count条
     * @param base           callback List<{@link Message}>
     */
    public void getAdvancedHistoryMessageList(OnBase<List<Message>> base, String userID, String groupID, String conversationID, Message startMsg, int count) {
        Map<String, Object> map = new ArrayMap<>();
        map.put("userID", userID);
        map.put("groupID", groupID);
        map.put("conversationID", conversationID);
        if (null != startMsg) {
            map.put("startClientMsgID", startMsg.getClientMsgID());
        }
        map.put("count", count);
        Open_im_sdk.getAdvancedHistoryMessageList(BaseImpl.arrayBase(base, Message.class), ParamsUtil.buildOperationID(), JsonUtil.toString(map));
    }

    static Message parse(String msg) {
        return JsonUtil.toObj(msg, Message.class);
    }
}
