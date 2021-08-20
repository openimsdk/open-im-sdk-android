package io.openim.android.sdk.manager;

import java.util.List;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnConversationListener;
import io.openim.android.sdk.models.ConversationInfo;
import io.openim.android.sdk.utils.CommonUtil;
import io.openim.android.sdk.utils.JsonUtil;
import open_im_sdk.Open_im_sdk;

public class ConversationManager {


    public void pinConversation(OnBase<String> base, String conversationID, boolean isPinned) {
        Open_im_sdk.pinConversation(conversationID, isPinned, BaseImpl.stringBase(base));
    }

    public void setConversationDraft(OnBase<String> base, String conversationID, String draft) {
        Open_im_sdk.setConversationDraft(conversationID, draft, BaseImpl.stringBase(base));
    }

    public void deleteConversation(OnBase<String> base, String conversationID) {
        Open_im_sdk.deleteConversation(conversationID, BaseImpl.stringBase(base));
    }

    public void getMultipleConversation(OnBase<List<ConversationInfo>> base, String conversationID) {
        Open_im_sdk.getMultipleConversation(conversationID, BaseImpl.arrayBase(base, ConversationInfo.class));
    }

    /**
     * @param sourceId:    if it is a single chat, Its value is userID. if it is a group chat, Its value is groupID
     * @param sessionType: if it is a single chat, it value is 1. if it is a group chat, it value is 2
     */
    public void getOneConversation(OnBase<ConversationInfo> base, String sourceId, long sessionType) {
        Open_im_sdk.getOneConversation(sourceId, sessionType, BaseImpl.objectBase(base, ConversationInfo.class));
    }

    public void getAllConversationList(OnBase<List<ConversationInfo>> base) {
        Open_im_sdk.getAllConversationList(BaseImpl.arrayBase(base, ConversationInfo.class));
    }

    public void setOnConversationListener(OnConversationListener listener) {
        Open_im_sdk.setConversationListener(new open_im_sdk.OnConversationListener() {
            @Override
            public void onConversationChanged(String s) {
                if (null != listener) {
                    List<ConversationInfo> list = JsonUtil.toArray(s, ConversationInfo.class);
                    CommonUtil.runMainThread(() -> listener.onConversationChanged(list));
                }
            }

            @Override
            public void onNewConversation(String s) {
                if (null != listener) {
                    List<ConversationInfo> list = JsonUtil.toArray(s, ConversationInfo.class);
                    CommonUtil.runMainThread(() -> listener.onNewConversation(list));

                }
            }

            @Override
            public void onSyncServerFailed() {
                if (null != listener) {
                    CommonUtil.runMainThread(listener::onSyncServerFailed);
                }
            }

            @Override
            public void onSyncServerFinish() {
                if (null != listener) {
                    CommonUtil.runMainThread(listener::onSyncServerFinish);
                }
            }

            @Override
            public void onSyncServerStart() {
                if (null != listener) {
                    CommonUtil.runMainThread(listener::onSyncServerStart);
                }
            }

            @Override
            public void onTotalUnreadMessageCountChanged(int i) {
                if (null != listener) {
                    CommonUtil.runMainThread(() -> listener.onTotalUnreadMessageCountChanged(i));
                }
            }
        });
    }
}
