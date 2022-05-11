package io.openim.android.sdk.manager;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnSignalingListener;
import io.openim.android.sdk.listener._SignalingListener;
import io.openim.android.sdk.models.SignalingCertificate;
import io.openim.android.sdk.models.SignalingInfo;
import io.openim.android.sdk.utils.JsonUtil;
import io.openim.android.sdk.utils.ParamsUtil;
import open_im_sdk.Open_im_sdk;

public class SignalingManager {

    /**
     * 设置信令监听
     */
    public void setSignalingListener(OnSignalingListener listener) {
        Open_im_sdk.setSignalingListener(new _SignalingListener(listener));
    }

    /**
     * 邀请个人加入音视频
     */
    public void signalingInvite(OnBase<SignalingCertificate> base, SignalingInfo info) {
        Open_im_sdk.signalingInvite(BaseImpl.objectBase(base, SignalingCertificate.class), ParamsUtil.buildOperationID(), JsonUtil.toString(info));
    }

    /**
     * 邀请群里某些人加入音视频
     */
    public void signalingInviteInGroup(OnBase<SignalingCertificate> base, SignalingInfo info) {
        Open_im_sdk.signalingInviteInGroup(BaseImpl.objectBase(base, SignalingCertificate.class), ParamsUtil.buildOperationID(), JsonUtil.toString(info));
    }

    /**
     * 同意某人音视频邀请
     */
    public void signalingAccept(OnBase<SignalingCertificate> base, SignalingInfo info) {
        Open_im_sdk.signalingAccept(BaseImpl.objectBase(base, SignalingCertificate.class), ParamsUtil.buildOperationID(), JsonUtil.toString(info));
    }

    /**
     * 拒绝某人音视频邀请
     */
    public void signalingReject(OnBase<SignalingCertificate> base, SignalingInfo info) {
        Open_im_sdk.signalingReject(BaseImpl.objectBase(base, SignalingCertificate.class), ParamsUtil.buildOperationID(), JsonUtil.toString(info));
    }

    /**
     * 邀请者取消音视频通话
     */
    public void signalingCancel(OnBase<SignalingCertificate> base, SignalingInfo info) {
        Open_im_sdk.signalingCancel(BaseImpl.objectBase(base, SignalingCertificate.class), ParamsUtil.buildOperationID(), JsonUtil.toString(info));
    }

    /**
     * 挂断
     */
    public void signalingHungUp(OnBase<SignalingCertificate> base, SignalingInfo info) {
        Open_im_sdk.signalingHungUp(BaseImpl.objectBase(base, SignalingCertificate.class), ParamsUtil.buildOperationID(), JsonUtil.toString(info));
    }
}
