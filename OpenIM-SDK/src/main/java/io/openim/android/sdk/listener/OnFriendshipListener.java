package io.openim.android.sdk.listener;

import io.openim.android.sdk.models.BlacklistInfo;
import io.openim.android.sdk.models.FriendApplicationInfo;
import io.openim.android.sdk.models.FriendInfo;
import io.openim.android.sdk.models.UserInfo;


/**
 * 好友关系监听
 */
public interface OnFriendshipListener {

    void onBlacklistAdded(BlacklistInfo u);


    void onBlacklistDeleted(BlacklistInfo u);


    void onFriendApplicationAccepted(FriendApplicationInfo u);


    void onFriendApplicationAdded(FriendApplicationInfo u);


    void onFriendApplicationDeleted(FriendApplicationInfo u);


    void onFriendApplicationRejected(FriendApplicationInfo u);


    void onFriendInfoChanged(FriendInfo u);


    void onFriendAdded(FriendInfo u);


    void onFriendDeleted(FriendInfo u);
}
