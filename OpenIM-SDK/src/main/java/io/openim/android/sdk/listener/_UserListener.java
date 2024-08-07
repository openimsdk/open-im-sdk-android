package io.openim.android.sdk.listener;

import io.openim.android.sdk.models.UserInfo;
import io.openim.android.sdk.models.UsersOnlineStatus;
import io.openim.android.sdk.utils.CommonUtil;
import io.openim.android.sdk.utils.JsonUtil;

public class _UserListener implements open_im_sdk_callback.OnUserListener {
    private final OnUserListener listener;

    public _UserListener(OnUserListener listener) {
        this.listener = listener;
    }

    @Override
    public void onUserCommandAdd(String s) {
/*        if (null != listener) {
            CommonUtil.runMainThread(() -> listener.onUserCommandAdd(JsonUtil.toObj(s, UserInfo.class)));
        }*/
    }

    @Override
    public void onUserCommandDelete(String s) {
/*        if (null != listener) {
            CommonUtil.runMainThread(() -> listener.onUserCommandDelete(JsonUtil.toObj(s, UserInfo.class)));
        }*/
    }

    @Override
    public void onUserCommandUpdate(String s) {
        /*if (null != listener) {
            CommonUtil.runMainThread(() -> listener.onUserCommandUpdate(JsonUtil.toObj(s, UserInfo.class)));
        }*/
    }

    @Override
    public void onSelfInfoUpdated(String s) {
        if (null != listener) {
            CommonUtil.runMainThread(() -> listener.onSelfInfoUpdated(JsonUtil.toObj(s, UserInfo.class)));
        }
    }

    @Override
    public void onUserStatusChanged(String s) {
        CommonUtil.runMainThread(() -> listener.onUserStatusChanged(JsonUtil.toObj(s, UsersOnlineStatus.class)));
    }
}
