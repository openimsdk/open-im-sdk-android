package io.openim.android.sdk.listener;

import io.openim.android.sdk.utils.CommonUtil;
import open_im_sdk.SendMsgCallBack;

final public class _MsgSendProgressListener implements SendMsgCallBack {
    private final OnMsgSendCallback base;

    public _MsgSendProgressListener(OnMsgSendCallback base) {
        this.base = base;
    }

    @Override
    public void onError(long l, String s) {
        if (null != base) {
            CommonUtil.returnError(base, l, s);
        }
    }

    @Override
    public void onProgress(long l) {
        if (null != base) {
            CommonUtil.runMainThread(() -> base.onProgress(l));
        }
    }

    @Override
    public void onSuccess(String s) {
        if (null != base) {
            CommonUtil.returnSuccess(base, s);
        }
    }
}
