package io.openim.android.sdk.models;

public class SignalingCertificate {
    private String token;
    private String roomID;
    private String liveURL;

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
}
