package io.openim.android.sdk.listener;

import io.openim.android.sdk.utils.CommonUtil;

final public class _ConnListener implements open_im_sdk_callback.OnConnListener {
    private final OnConnListener listener;

    public _ConnListener(OnConnListener listener) {
        this.listener = listener;
    }

    @Override
    public void onConnectFailed(int i, String s) {
        if (null != listener) {
            CommonUtil.runMainThread(() -> listener.onConnectFailed(i, s));
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
    public void onUserTokenExpired() {
        if (null != listener) {
            CommonUtil.runMainThread(listener::onUserTokenExpired);
        }
    }

}
