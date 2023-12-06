package io.openim.android.sdk.listener;

import io.openim.android.sdk.models.FriendApplicationInfo;
import io.openim.android.sdk.models.GroupApplicationInfo;
import io.openim.android.sdk.models.Message;

public interface OnListenerForService {
    default void onFriendApplicationAccepted(FriendApplicationInfo u){}

    default void onFriendApplicationAdded(FriendApplicationInfo u){}

    default void onGroupApplicationAccepted(GroupApplicationInfo info){}

    default void onGroupApplicationAdded(GroupApplicationInfo info){}

    default void onRecvNewMessage(Message msg){}
}
