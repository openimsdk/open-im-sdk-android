package io.openim.android.sdk.listener;

import io.openim.android.sdk.models.UserInfo;


/**
 * 好友关系监听
 */
public interface OnFriendshipListener {
    /**
     * 好友被加入黑名时单回调
     */
    void onBlackListAdd(UserInfo u);

    /**
     * 好友从黑名单移除时回调
     */
    void onBlackListDeleted(UserInfo u);

    /**
     * 发起的好友请求被接受时回调
     */
    void onFriendApplicationListAccept(UserInfo u);

    /**
     * 我接受被人的发起的好友请求时回调
     */
    void onFriendApplicationListAdded(UserInfo u);

    /**
     * 删除好友请求时回调
     */
    void onFriendApplicationListDeleted(UserInfo u);

    /**
     * 请求被拒绝回调
     */
    void onFriendApplicationListReject(UserInfo u);

    /**
     * 好友资料发生变化时回调
     */
    void onFriendInfoChanged(UserInfo u);

    /**
     * 已添加好友回调
     */
    void onFriendListAdded(UserInfo u);

    /**
     * 好友被删除时回调
     */

    void onFriendListDeleted(UserInfo u);
}
