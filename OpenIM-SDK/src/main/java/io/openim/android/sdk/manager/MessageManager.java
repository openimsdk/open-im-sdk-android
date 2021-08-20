package io.openim.android.sdk.manager;


import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnAdvanceMsgListener;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnMsgSendCallback;
import io.openim.android.sdk.models.HaveReadInfo;
import io.openim.android.sdk.models.Message;
import io.openim.android.sdk.utils.CommonUtil;
import io.openim.android.sdk.utils.JsonUtil;
import open_im_sdk.Open_im_sdk;
import open_im_sdk.SendMsgCallBack;

public class MessageManager {
    public List<WeakReference<OnAdvanceMsgListener>> listeners = new ArrayList<>();
    private static boolean initialized = false;

    private synchronized void initListener() {
        if (!initialized) {
            initialized = true;
            Open_im_sdk.addAdvancedMsgListener(new open_im_sdk.OnAdvancedMsgListener() {
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
            });
        }
    }

    public void addAdvancedMsgListener(OnAdvanceMsgListener listener) {
        initListener();
        listeners.add(new WeakReference<>(listener));
    }

    public void removeAdvancedMsgListener(OnAdvanceMsgListener listener) {
        final Iterator<WeakReference<OnAdvanceMsgListener>> each = listeners.iterator();
        while (each.hasNext()) {
            if (each.next().get() == listener) {
                each.remove();
            }
        }
//        Open_im_sdk.removeAdvancedMsgListener(listener);
    }

    public void sendMessage(OnMsgSendCallback base, Message message, String recvUid, String recvGid, boolean onlineUserOnly) {
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
                    CommonUtil.runMainThread(() -> base.onProgress(l));
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

    public void getHistoryMessageList(OnBase<List<Message>> base, String userID, String groupID, Message startMsg, int count) {
        Map<String, Object> map = new HashMap<>();
        map.put("userID", userID);
        map.put("groupID", groupID);
        map.put("startMsg", startMsg);
        map.put("count", count);
        Open_im_sdk.getHistoryMessageList(BaseImpl.arrayBase(base, Message.class), JsonUtil.toString(map));
    }

    public void revokeMessage(OnBase<String> base, Message message) {
        Open_im_sdk.revokeMessage(BaseImpl.stringBase(base), JsonUtil.toString(message));
    }

    public void deleteMessageFromLocalStorage(OnBase<String> base, Message message) {
        Open_im_sdk.deleteMessageFromLocalStorage(BaseImpl.stringBase(base), JsonUtil.toString(message));
    }

    public void deleteMessages(OnBase<String> base, List<Message> message) {
//        Open_im_sdk.deleteMessages(BaseImpl.stringBase(base), JSON.toJSONString(message));
    }

    public void insertSingleMessageToLocalStorage(OnBase<String> base, Message message, String userID, String sender) {
        Open_im_sdk.insertSingleMessageToLocalStorage(BaseImpl.stringBase(base), JsonUtil.toString(message), userID, sender);
    }

    public void findMessages(OnBase<List<Message>> base, List<String> messageIDList) {
        Open_im_sdk.findMessages(BaseImpl.arrayBase(base, Message.class), JsonUtil.toString(messageIDList));
    }

    public void markSingleMessageHasRead(OnBase<String> base, String userID) {
        Open_im_sdk.markSingleMessageHasRead(BaseImpl.stringBase(base), userID);
    }

    public void markGroupMessageHasRead(OnBase<String> base, String groupID) {
        Open_im_sdk.markGroupMessageHasRead(BaseImpl.stringBase(base), groupID);
    }

    public void markC2CMessageAsRead(OnBase<String> base, String userID, List<String> messageIDList) {
        Open_im_sdk.markC2CMessageAsRead(BaseImpl.stringBase(base), userID, JsonUtil.toString(messageIDList));
    }

    public void typingStatusUpdate(String userID, boolean typing) {
        Open_im_sdk.typingStatusUpdate(userID, typing ? "YES" : "NO");
    }

    public Message createTextMessage(String text) {
        return parse(Open_im_sdk.createTextMessage(text));
    }

    public Message createTextAtMessage(String text, List<String> atUidList) {
        return parse(Open_im_sdk.createTextAtMessage(text, JsonUtil.toString(atUidList)));
    }

    public Message createImageMessage(String imagePath) {
        return parse(Open_im_sdk.createImageMessage(imagePath));
    }

    public Message createSoundMessage(String soundPath, long duration) {
        return parse(Open_im_sdk.createSoundMessage(soundPath, duration));
    }

    public Message createVideoMessage(String videoPath, String videoType, long duration, String snapshotPath) {
        return parse(Open_im_sdk.createVideoMessage(videoPath, videoType, duration, snapshotPath));
    }

    public Message createFileMessage(String filePath, String fileName) {
        return parse(Open_im_sdk.createFileMessage(filePath, fileName));
    }

    public Message createMergerMessage(List<Message> messageList, String title, List<String> summaryList) {
        return parse(Open_im_sdk.createMergerMessage(JsonUtil.toString(messageList), title, JsonUtil.toString(summaryList)));
    }

    public Message createForwardMessage(List<Message> messageList) {
        return parse(Open_im_sdk.createForwardMessage(JsonUtil.toString(messageList)));
    }

    public Message createLocationMessage(double latitude, double longitude, String description) {
        return parse(Open_im_sdk.createLocationMessage(description, longitude, latitude));
    }

    public Message createCustomMessage(byte[] data, byte[] extension, String description) {
        return parse(Open_im_sdk.createCustomMessage(data, extension, description));
    }

    public void getTotalUnreadMsgCount(OnBase<String> base) {
        Open_im_sdk.getTotalUnreadMsgCount(BaseImpl.stringBase(base));
    }

    public void forceSyncMsg() {
        Open_im_sdk.forceSyncMsg();
    }

    static Message parse(String msg) {
        return JsonUtil.toObj(msg, Message.class);
    }
}
