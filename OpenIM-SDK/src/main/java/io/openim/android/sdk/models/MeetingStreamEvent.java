package io.openim.android.sdk.models;

public class MeetingStreamEvent {
    private String roomID;
    private String streamType;
    private boolean mute;

    public String getMeetingID() {
        return roomID;
    }

    public void setMeetingID(String roomID) {
        this.roomID = roomID;
    }

    public String getStreamType() {
        return streamType;
    }

    public void setStreamType(String streamType) {
        this.streamType = streamType;
    }

    public boolean isMute() {
        return mute;
    }

    public void setMute(boolean mute) {
        this.mute = mute;
    }
}
