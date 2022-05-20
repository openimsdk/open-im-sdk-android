package io.openim.android.sdk.listener;

import io.openim.android.sdk.utils.CommonUtil;

final public class _FileUploadProgressListener implements open_im_sdk_callback.SendMsgCallBack {
    private final OnFileUploadProgressListener base;

    public _FileUploadProgressListener(OnFileUploadProgressListener base) {
        this.base = base;
    }

    @Override
    public void onError(int i, String s) {
        if (null != base) {
            CommonUtil.returnError(base, i, s);
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
            CommonUtil.runMainThread(() -> base.onSuccess(s));
        }
    }
}
