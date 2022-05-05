package io.openim.android.sdk.listener;

import io.openim.android.sdk.utils.CommonUtil;

public class _WorkMomentsListener implements open_im_sdk_callback.OnWorkMomentsListener {
    private final OnWorkMomentsListener listener;

    public _WorkMomentsListener(OnWorkMomentsListener listener) {
        this.listener = listener;
    }


    @Override
    public void onRecvNewNotification() {
        if (null != listener) {
            CommonUtil.runMainThread(listener::onRecvNewNotification);
        }
    }
}
