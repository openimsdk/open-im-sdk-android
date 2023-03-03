package io.openim.android.sdk.listener;

import io.openim.android.sdk.models.FriendApplicationInfo;
import io.openim.android.sdk.models.GroupApplicationInfo;
import io.openim.android.sdk.models.Message;

public interface OnListenerForService {
    void onFriendApplicationAccepted(FriendApplicationInfo u);

    void onFriendApplicationAdded(FriendApplicationInfo u);

    void onGroupApplicationAccepted(GroupApplicationInfo info);

    void onGroupApplicationAdded(GroupApplicationInfo info);

    void onRecvNewMessage(Message msg);
}
