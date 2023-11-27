package io.openim.android.sdk.listener;


import io.openim.android.sdk.models.CustomSignalingInfo;
import io.openim.android.sdk.models.MeetingStreamEvent;
import io.openim.android.sdk.models.RoomCallingInfo;
import io.openim.android.sdk.models.SignalingInfo;
import io.openim.android.sdk.utils.CommonUtil;
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
            CommonUtil.runMainThread(() -> listener.onHangup(info));
        }
    }

    @Override
    public void onInvitationCancelled(String s) {
        if (listener != null) {
            SignalingInfo info = JsonUtil.toObj(s, SignalingInfo.class);
            CommonUtil.runMainThread(() -> listener.onInvitationCancelled(info));
        }
    }

    @Override
    public void onInvitationTimeout(String s) {
        if (listener != null) {
            SignalingInfo info = JsonUtil.toObj(s, SignalingInfo.class);
            CommonUtil.runMainThread(() -> listener.onInvitationTimeout(info));
        }
    }

    @Override
    public void onInviteeAccepted(String s) {
        if (listener != null) {
            SignalingInfo info = JsonUtil.toObj(s, SignalingInfo.class);
            CommonUtil.runMainThread(() -> listener.onInviteeAccepted(info));
        }
    }

    @Override
    public void onInviteeAcceptedByOtherDevice(String s) {
        if (listener != null) {
            SignalingInfo info = JsonUtil.toObj(s, SignalingInfo.class);
            CommonUtil.runMainThread(() -> listener.onInviteeAcceptedByOtherDevice(info));
        }
    }

    @Override
    public void onInviteeRejected(String s) {
        if (listener != null) {
            SignalingInfo info = JsonUtil.toObj(s, SignalingInfo.class);
            CommonUtil.runMainThread(() -> listener.onInviteeRejected(info));
        }
    }

    @Override
    public void onInviteeRejectedByOtherDevice(String s) {
        if (listener != null) {
            SignalingInfo info = JsonUtil.toObj(s, SignalingInfo.class);
            CommonUtil.runMainThread(() -> listener.onInviteeRejectedByOtherDevice(info));
        }
    }


    @Override
    public void onReceiveNewInvitation(String s) {
        if (listener != null) {
            SignalingInfo info = JsonUtil.toObj(s, SignalingInfo.class);
            CommonUtil.runMainThread(() -> listener.onReceiveNewInvitation(info));
        }
    }

    @Override
    public void onRoomParticipantConnected(String s) {
        if (listener != null) {
            RoomCallingInfo info = JsonUtil.toObj(s, RoomCallingInfo.class);
            CommonUtil.runMainThread(() -> listener.onRoomParticipantConnected(info));
        }
    }

    @Override
    public void onRoomParticipantDisconnected(String s) {
        if (listener != null) {
            RoomCallingInfo info = JsonUtil.toObj(s, RoomCallingInfo.class);
            CommonUtil.runMainThread(() -> listener.onRoomParticipantDisconnected(info));
        }
    }


}
