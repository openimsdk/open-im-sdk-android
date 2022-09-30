package io.openim.android.sdk.models;

import java.util.List;

public class SignalingCertificate {
    private String token;
    private String roomID;
    private String liveURL;
    private List<String> busyLineUserIDList;

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

    public List<String> getBusyLineUserIDList() {
        return busyLineUserIDList;
    }

    public void setBusyLineUserIDList(List<String> busyLineUserIDList) {
        this.busyLineUserIDList = busyLineUserIDList;
    }
}
