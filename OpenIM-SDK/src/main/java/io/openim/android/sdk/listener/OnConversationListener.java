package io.openim.android.sdk.listener;

import java.util.List;

import io.openim.android.sdk.models.ConversationInfo;

public interface OnConversationListener {
    void onConversationChanged(List<ConversationInfo> list);

    void onNewConversation(List<ConversationInfo> list);

    void onSyncServerFailed();

    void onSyncServerFinish();

    void onSyncServerStart();

    void onTotalUnreadMessageCountChanged(int i);
}
