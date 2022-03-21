package io.openim.android.sdk.models;

public class SignalingInfo {
    private String opUserID;
    private SignalingInvitationInfo invitation;
    private OfflinePushInfo offlinePushInfo;

    public String getOpUserID() {
        return opUserID;
    }

    public void setOpUserID(String opUserID) {
        this.opUserID = opUserID;
    }

    public SignalingInvitationInfo getInvitation() {
        return invitation;
    }

    public void setInvitation(SignalingInvitationInfo invitation) {
        this.invitation = invitation;
    }

    public OfflinePushInfo getOfflinePushInfo() {
        return offlinePushInfo;
    }

    public void setOfflinePushInfo(OfflinePushInfo offlinePushInfo) {
        this.offlinePushInfo = offlinePushInfo;
    }
}
