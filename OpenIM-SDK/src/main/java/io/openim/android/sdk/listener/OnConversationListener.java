package io.openim.android.sdk.listener;

import java.util.List;

import io.openim.android.sdk.models.ConversationInfo;


/**
 * 会话监听
 */
public interface OnConversationListener {
    /**
     * 会话列表有数据更新
     * 可刷新会话列表
     */
    void onConversationChanged(List<ConversationInfo> list);

    /**
     * 新增会话
     * 可刷新会话列表
     */
    void onNewConversation(List<ConversationInfo> list);

    /**
     *
     */
    void onSyncServerFailed();

    /**
     *
     */
    void onSyncServerFinish();

    /**
     *
     */
    void onSyncServerStart();

    /**
     * 未读消息总数改变
     */
    void onTotalUnreadMessageCountChanged(int i);
}
