package io.openim.android.sdk.listener;


import io.openim.android.sdk.utils.CommonUtil;

public final class _CustomBusinessListener implements open_im_sdk_callback.OnCustomBusinessListener {
    private final OnCustomBusinessListener listener;

    public _CustomBusinessListener(OnCustomBusinessListener listener) {
        this.listener = listener;
    }

    @Override
    public void onRecvCustomBusinessMessage(String s) {
        if (null != listener) {
            CommonUtil.runMainThread(() -> listener.onRecvCustomBusinessMessage(s));
        }
    }
}
