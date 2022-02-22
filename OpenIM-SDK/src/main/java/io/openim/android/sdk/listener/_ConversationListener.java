package io.openim.android.sdk.listener;

import java.util.List;

import io.openim.android.sdk.models.ConversationInfo;
import io.openim.android.sdk.utils.CommonUtil;
import io.openim.android.sdk.utils.JsonUtil;

final public class _ConversationListener implements open_im_sdk_callback.OnConversationListener {
    private final OnConversationListener listener;

    public _ConversationListener(OnConversationListener listener) {
        this.listener = listener;
    }

    /**
     * 返回当前发生改变的会话列表
     **/
    @Override
    public void onConversationChanged(String s) {
        if (null != listener) {
            List<ConversationInfo> list = JsonUtil.toArray(s, ConversationInfo.class);
            CommonUtil.runMainThread(() -> listener.onConversationChanged(list));
        }
    }

    /**
     * 返回当前新增的会话列表
     **/
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
}
