package io.openim.android.sdk.listener;

import io.openim.android.sdk.models.UserInfo;

public interface OnFriendshipListener {
    void onBlackListAdd(UserInfo u);

    void onBlackListDeleted(UserInfo u);

    void onFriendApplicationListAccept(UserInfo u);

    void onFriendApplicationListAdded(UserInfo u);

    void onFriendApplicationListDeleted(UserInfo u);

    void onFriendApplicationListReject(UserInfo u);

    void onFriendInfoChanged(UserInfo u);

    void onFriendListAdded(UserInfo u);

    void onFriendListDeleted(UserInfo u);
}
