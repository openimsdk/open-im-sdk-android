package io.openim.android.sdk.listener;

import io.openim.android.sdk.models.BlacklistInfo;
import io.openim.android.sdk.models.FriendApplicationInfo;
import io.openim.android.sdk.models.FriendInfo;
import io.openim.android.sdk.models.UserInfo;


/**
 * 好友关系监听
 */
public interface OnFriendshipListener {

    default void onBlacklistAdded(BlacklistInfo u){}


    default void onBlacklistDeleted(BlacklistInfo u){}


    default void onFriendApplicationAccepted(FriendApplicationInfo u){}


    default void onFriendApplicationAdded(FriendApplicationInfo u){}


    default void onFriendApplicationDeleted(FriendApplicationInfo u){}


    default void onFriendApplicationRejected(FriendApplicationInfo u){}


    default void onFriendInfoChanged(FriendInfo u){}


    default void onFriendAdded(FriendInfo u){}


    default void onFriendDeleted(FriendInfo u){}
}
