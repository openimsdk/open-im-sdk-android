package io.openim.android.sdk.listener;

import io.openim.android.sdk.models.CustomSignalingInfo;
import io.openim.android.sdk.models.MeetingStreamEvent;
import io.openim.android.sdk.models.RoomCallingInfo;
import io.openim.android.sdk.models.SignalingInfo;

public interface OnSignalingListener {

    void onInvitationCancelled(SignalingInfo s);

    void onInvitationTimeout(SignalingInfo s);

    void onInviteeAccepted(SignalingInfo s);

    void onInviteeAcceptedByOtherDevice(SignalingInfo s);

    void onInviteeRejected(SignalingInfo s);

    void onInviteeRejectedByOtherDevice(SignalingInfo s);

    void onReceiveNewInvitation(SignalingInfo s);

    void onHangup(SignalingInfo s);

    void onRoomParticipantConnected(RoomCallingInfo s);

    void onRoomParticipantDisconnected(RoomCallingInfo s);

    void onMeetingStreamChanged(MeetingStreamEvent e);

    void onReceiveCustomSignal(CustomSignalingInfo s);

    void onStreamChange(String s);
}
