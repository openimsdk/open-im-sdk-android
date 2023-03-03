package io.openim.android.sdk.listener;

import io.openim.android.sdk.models.FriendApplicationInfo;
import io.openim.android.sdk.models.GroupApplicationInfo;
import io.openim.android.sdk.models.Message;
import io.openim.android.sdk.utils.CommonUtil;
import io.openim.android.sdk.utils.JsonUtil;

public class _ListenerForService implements open_im_sdk_callback.OnListenerForService {
    private final OnListenerForService listener;

    public _ListenerForService(OnListenerForService listener) {
        this.listener = listener;
    }

    @Override
    public void onFriendApplicationAccepted(String s) {
        if (null != listener) {
            FriendApplicationInfo u = JsonUtil.toObj(s, FriendApplicationInfo.class);
            CommonUtil.runMainThread(() -> listener.onFriendApplicationAccepted(u));
        }
    }

    @Override
    public void onFriendApplicationAdded(String s) {
        if (null != listener) {
            FriendApplicationInfo u = JsonUtil.toObj(s, FriendApplicationInfo.class);
            CommonUtil.runMainThread(() -> listener.onFriendApplicationAdded(u));
        }
    }

    @Override
    public void onGroupApplicationAccepted(String s) {
        if (null != listener) {
            GroupApplicationInfo u = JsonUtil.toObj(s, GroupApplicationInfo.class);
            CommonUtil.runMainThread(() -> listener.onGroupApplicationAccepted(u));
        }
    }

    @Override
    public void onGroupApplicationAdded(String s) {
        if (null != listener) {
            GroupApplicationInfo u = JsonUtil.toObj(s, GroupApplicationInfo.class);
            CommonUtil.runMainThread(() -> listener.onGroupApplicationAdded(u));
        }
    }

    @Override
    public void onRecvNewMessage(String s) {
        Message msg = JsonUtil.toObj(s, Message.class);
        CommonUtil.runMainThread(() -> listener.onRecvNewMessage(msg));
    }
}
