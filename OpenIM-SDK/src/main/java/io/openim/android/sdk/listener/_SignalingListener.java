package io.openim.android.sdk.listener;


import io.openim.android.sdk.models.SignalingInfo;
import io.openim.android.sdk.utils.JsonUtil;

final public class _SignalingListener implements open_im_sdk_callback.OnSignalingListener {
    private final OnSignalingListener listener;

    public _SignalingListener(OnSignalingListener listener) {
        this.listener = listener;
    }

    @Override
    public void onHangUp(String s) {
        if (listener != null) {
            SignalingInfo info = JsonUtil.toObj(s, SignalingInfo.class);
            listener.onHangup(info);
        }
    }

    @Override
    public void onInvitationCancelled(String s) {
        if (listener != null) {
            SignalingInfo info = JsonUtil.toObj(s, SignalingInfo.class);
            listener.onInvitationCancelled(info);
        }
    }

    @Override
    public void onInvitationTimeout(String s) {
        if (listener != null) {
            SignalingInfo info = JsonUtil.toObj(s, SignalingInfo.class);
            listener.onInvitationTimeout(info);
        }
    }

    @Override
    public void onInviteeAccepted(String s) {
        if (listener != null) {
            SignalingInfo info = JsonUtil.toObj(s, SignalingInfo.class);
            listener.onInviteeAccepted(info);
        }
    }

    @Override
    public void onInviteeAcceptedByOtherDevice(String s) {
        if (listener != null) {
            SignalingInfo info = JsonUtil.toObj(s, SignalingInfo.class);
            listener.onInviteeAcceptedByOtherDevice(info);
        }
    }

    @Override
    public void onInviteeRejected(String s) {
        if (listener != null) {
            SignalingInfo info = JsonUtil.toObj(s, SignalingInfo.class);
            listener.onInviteeRejected(info);
        }
    }

    @Override
    public void onInviteeRejectedByOtherDevice(String s) {
        if (listener != null) {
            SignalingInfo info = JsonUtil.toObj(s, SignalingInfo.class);
            listener.onInviteeRejectedByOtherDevice(info);
        }
    }

    @Override
    public void onReceiveNewInvitation(String s) {
        if (listener != null) {
            SignalingInfo info = JsonUtil.toObj(s, SignalingInfo.class);
            listener.onReceiveNewInvitation(info);
        }
    }
}
