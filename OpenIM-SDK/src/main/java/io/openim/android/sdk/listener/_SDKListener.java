package io.openim.android.sdk.listener;

import io.openim.android.sdk.models.UserInfo;
import io.openim.android.sdk.utils.CommonUtil;
import io.openim.android.sdk.utils.JsonUtil;

final public class _SDKListener implements open_im_sdk.IMSDKListener {
    private final OnInitSDKListener listener;

    public _SDKListener(OnInitSDKListener listener) {
        this.listener = listener;
    }

    @Override
    public void onConnectFailed(long l, String s) {
        if (null != listener) {
            CommonUtil.runMainThread(() -> listener.onConnectFailed(l, s));
        }
    }

    @Override
    public void onConnectSuccess() {
        if (null != listener) {
            CommonUtil.runMainThread(listener::onConnectSuccess);
        }
    }

    @Override
    public void onConnecting() {
        if (null != listener) {
            CommonUtil.runMainThread(listener::onConnecting);
        }
    }

    @Override
    public void onKickedOffline() {
        if (null != listener) {
            CommonUtil.runMainThread(listener::onKickedOffline);
        }
    }

    @Override
    public void onSelfInfoUpdated(String s) {
        if (null != listener) {
            CommonUtil.runMainThread(() -> listener.onSelfInfoUpdated(JsonUtil.toObj(s, UserInfo.class)));
        }
    }

    @Override
    public void onUserTokenExpired() {
        if (null != listener) {
            CommonUtil.runMainThread(listener::onUserTokenExpired);
        }
    }

}
