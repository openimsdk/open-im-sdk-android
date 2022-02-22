package io.openim.android.sdk.listener;

import io.openim.android.sdk.models.BlacklistInfo;
import io.openim.android.sdk.models.FriendApplicationInfo;
import io.openim.android.sdk.models.FriendInfo;
import io.openim.android.sdk.utils.CommonUtil;
import io.openim.android.sdk.utils.JsonUtil;

final public class _FriendshipListener implements open_im_sdk_callback.OnFriendshipListener {
    private final OnFriendshipListener listener;

    public _FriendshipListener(OnFriendshipListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBlackAdded(String s) {
        if (null != listener) {
            BlacklistInfo u = JsonUtil.toObj(s, BlacklistInfo.class);
            CommonUtil.runMainThread(() -> listener.onBlacklistAdded(u));
        }
    }

    @Override
    public void onBlackDeleted(String s) {
        if (null != listener) {
            BlacklistInfo u = JsonUtil.toObj(s, BlacklistInfo.class);
            CommonUtil.runMainThread(() -> listener.onBlacklistDeleted(u));
        }
    }

    @Override
    public void onFriendAdded(String s) {
        if (null != listener) {
            FriendInfo u = JsonUtil.toObj(s, FriendInfo.class);
            CommonUtil.runMainThread(() -> listener.onFriendAdded(u));
        }
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
    public void onFriendApplicationDeleted(String s) {
        if (null != listener) {
            FriendApplicationInfo u = JsonUtil.toObj(s, FriendApplicationInfo.class);
            CommonUtil.runMainThread(() -> listener.onFriendApplicationDeleted(u));
        }
    }

    @Override
    public void onFriendApplicationRejected(String s) {
        if (null != listener) {
            FriendApplicationInfo u = JsonUtil.toObj(s, FriendApplicationInfo.class);
            CommonUtil.runMainThread(() -> listener.onFriendApplicationRejected(u));
        }
    }

    @Override
    public void onFriendDeleted(String s) {
        if (null != listener) {
            FriendInfo u = JsonUtil.toObj(s, FriendInfo.class);
            CommonUtil.runMainThread(() -> listener.onFriendDeleted(u));
        }
    }

    @Override
    public void onFriendInfoChanged(String s) {
        if (null != listener) {
            FriendInfo u = JsonUtil.toObj(s, FriendInfo.class);
            CommonUtil.runMainThread(() -> listener.onFriendInfoChanged(u));
        }
    }
}
