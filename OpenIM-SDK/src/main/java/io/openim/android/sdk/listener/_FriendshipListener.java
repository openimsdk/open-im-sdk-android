package io.openim.android.sdk.listener;

import io.openim.android.sdk.models.UserInfo;
import io.openim.android.sdk.utils.CommonUtil;
import io.openim.android.sdk.utils.JsonUtil;

final public class _FriendshipListener implements open_im_sdk.OnFriendshipListener {
    private final OnFriendshipListener listener;

    public _FriendshipListener(OnFriendshipListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBlackListAdd(String s) {
        if (null != listener) {
            UserInfo u = JsonUtil.toObj(s, UserInfo.class);
            CommonUtil.runMainThread(() -> listener.onBlackListAdd(u));
        }
    }

    @Override
    public void onBlackListDeleted(String s) {
        if (null != listener) {
            UserInfo u = JsonUtil.toObj(s, UserInfo.class);
            CommonUtil.runMainThread(() -> listener.onBlackListDeleted(u));
        }
    }

    @Override
    public void onFriendApplicationListAccept(String s) {
        if (null != listener) {
            UserInfo u = JsonUtil.toObj(s, UserInfo.class);
            CommonUtil.runMainThread(() -> listener.onFriendApplicationListAccept(u));
        }
    }

    @Override
    public void onFriendApplicationListAdded(String s) {
        if (null != listener) {
            UserInfo u = JsonUtil.toObj(s, UserInfo.class);
            CommonUtil.runMainThread(() -> listener.onFriendApplicationListAdded(u));
        }
    }

    @Override
    public void onFriendApplicationListDeleted(String s) {
        if (null != listener) {
            UserInfo u = JsonUtil.toObj(s, UserInfo.class);
            CommonUtil.runMainThread(() -> listener.onFriendApplicationListDeleted(u));
        }
    }

    @Override
    public void onFriendApplicationListReject(String s) {
        if (null != listener) {
            UserInfo u = JsonUtil.toObj(s, UserInfo.class);
            CommonUtil.runMainThread(() -> listener.onFriendApplicationListReject(u));
        }
    }

    @Override
    public void onFriendInfoChanged(String s) {
        if (null != listener) {
            UserInfo u = JsonUtil.toObj(s, UserInfo.class);
            CommonUtil.runMainThread(() -> listener.onFriendInfoChanged(u));
        }
    }

    @Override
    public void onFriendListAdded(String s) {
        if (null != listener) {
            UserInfo u = JsonUtil.toObj(s, UserInfo.class);
            CommonUtil.runMainThread(() -> listener.onFriendListAdded(u));
        }
    }

    @Override
    public void onFriendListDeleted(String s) {
        if (null != listener) {
            UserInfo u = JsonUtil.toObj(s, UserInfo.class);
            CommonUtil.runMainThread(() -> listener.onFriendListDeleted(u));
        }
    }
}
