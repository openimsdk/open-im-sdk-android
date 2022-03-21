package io.openim.android.sdk.models;

import java.util.List;

public class SignalingInvitationInfo {
    private String inviterUserID; //邀请者UserID
    private List<String> inviteeUserIDList; //被邀请者UserID列表，如果是单聊只有一个元素
    private String groupID; //如果是单聊，为""
    private String roomID; //房间ID，必须唯一，可以不设置。
    private long timeout; //邀请超时时间（秒）
    private String mediaType; //video 或者audio
    private int sessionType; //1为单聊，2为群聊
    private int platformID; //和之前定义一致

    public String getInviterUserID() {
        return inviterUserID;
    }

    public void setInviterUserID(String inviterUserID) {
        this.inviterUserID = inviterUserID;
    }

    public List<String> getInviteeUserIDList() {
        return inviteeUserIDList;
    }

    public void setInviteeUserIDList(List<String> inviteeUserIDList) {
        this.inviteeUserIDList = inviteeUserIDList;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public int getSessionType() {
        return sessionType;
    }

    public void setSessionType(int sessionType) {
        this.sessionType = sessionType;
    }

    public int getPlatformID() {
        return platformID;
    }

    public void setPlatformID(int platformID) {
        this.platformID = platformID;
    }
}
