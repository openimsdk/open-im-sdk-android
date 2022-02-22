package io.openim.android.sdk.listener;

import io.openim.android.sdk.models.UserInfo;
import io.openim.android.sdk.utils.CommonUtil;
import io.openim.android.sdk.utils.JsonUtil;

public class _UserListener implements open_im_sdk_callback.OnUserListener {
    private final OnUserListener listener;

    public _UserListener(OnUserListener listener) {
        this.listener = listener;
    }

    @Override
    public void onSelfInfoUpdated(String s) {
        if (null != listener) {
            CommonUtil.runMainThread(() -> listener.onSelfInfoUpdated(JsonUtil.toObj(s, UserInfo.class)));
        }
    }
}
