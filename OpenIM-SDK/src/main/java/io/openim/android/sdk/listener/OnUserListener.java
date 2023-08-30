package io.openim.android.sdk.listener;

import io.openim.android.sdk.models.UserInfo;
import io.openim.android.sdk.models.UsersOnlineStatus;

public interface OnUserListener {
    /**
     * 当前用户的资料发生了更新
     * 可以在 UI 上更新自己的头像和昵称。
     */
    void onSelfInfoUpdated(UserInfo info);

    /**
     *  When the user's online status changes, call
     * @param onlineStatus
     */
    void onUserStatusChanged(UsersOnlineStatus onlineStatus);
}
