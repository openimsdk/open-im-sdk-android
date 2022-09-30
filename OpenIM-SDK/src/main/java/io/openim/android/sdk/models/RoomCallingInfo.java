package io.openim.android.sdk.models;

import java.util.List;

public class RoomCallingInfo {
    private SignalingInvitationInfo invitation;
    private List<Participant> participant;
    private String token;
    private String roomID;
    private String liveURL;
    private String groupID;

    public SignalingInvitationInfo getInvitation() {
        return invitation;
    }

    public void setInvitation(SignalingInvitationInfo invitation) {
        this.invitation = invitation;
    }

    public List<Participant> getParticipant() {
        return participant;
    }

    public void setParticipant(List<Participant> participant) {
        this.participant = participant;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getLiveURL() {
        return liveURL;
    }

    public void setLiveURL(String liveURL) {
        this.liveURL = liveURL;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }
}
