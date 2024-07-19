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
    default void onConversationChanged(List<ConversationInfo> list){}

    /**
     * 新增会话
     * 可刷新会话列表
     */
    default void onNewConversation(List<ConversationInfo> list){}

    /**
     *
     */
    default void onSyncServerFailed(boolean reinstalled){}

    /**
     *
     */
    default void onSyncServerFinish(boolean reinstalled){}

    /**
     *
     */
    default void onSyncServerStart(boolean reinstalled){}

    /**
     *
     */
    default void onSyncServerProgress(long progress){}

    /**
     * 未读消息总数改变
     */
    default void onTotalUnreadMessageCountChanged(int i){}

    default void onConversationUserInputStatusChanged(String s){};
}
