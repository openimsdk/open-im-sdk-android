package io.openim.android.sdk.listener;

import io.openim.android.sdk.models.CustomSignalingInfo;
import io.openim.android.sdk.models.MeetingStreamEvent;
import io.openim.android.sdk.models.RoomCallingInfo;
import io.openim.android.sdk.models.SignalingInfo;

public interface OnSignalingListener {

    default void onInvitationCancelled(SignalingInfo s){}

    default void onInvitationTimeout(SignalingInfo s){}

    default void onInviteeAccepted(SignalingInfo s){}

    default void onInviteeAcceptedByOtherDevice(SignalingInfo s){}

    default void onInviteeRejected(SignalingInfo s){}

    default void onInviteeRejectedByOtherDevice(SignalingInfo s){}

    default void onReceiveNewInvitation(SignalingInfo s){}

    default void onHangup(SignalingInfo s){}

    default void onRoomParticipantConnected(RoomCallingInfo s){}

    default void onRoomParticipantDisconnected(RoomCallingInfo s){}

    default void onMeetingStreamChanged(MeetingStreamEvent e){}

    default void onReceiveCustomSignal(CustomSignalingInfo s){}

    default void onStreamChange(String s){}
}
