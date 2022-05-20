package io.openim.android.sdk.listener;

import io.openim.android.sdk.utils.CommonUtil;

public class _OrganizationListener implements open_im_sdk_callback.OnOrganizationListener {
    private final OnOrganizationListener listener;

    public _OrganizationListener(OnOrganizationListener listener) {
        this.listener = listener;
    }


    @Override
    public void onOrganizationUpdated() {
        if (null != listener) {
            CommonUtil.runMainThread(listener::onOrganizationUpdated);
        }
    }
}
