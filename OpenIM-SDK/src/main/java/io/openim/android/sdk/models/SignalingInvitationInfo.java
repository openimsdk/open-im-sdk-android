package io.openim.android.sdk.models;

import java.util.List;

public class SignalingInvitationInfo {
    /**
     * 邀请者UserID
     */
    private String inviterUserID;
    /**
     * 被邀请者UserID列表，如果是单聊只有一个元素
     */
    private List<String> inviteeUserIDList;
    /**
     * 如果是单聊，为""
     */
    private String groupID;
    /**
     * 房间ID，必须唯一，可以不设置。
     */
    private String roomID;
    /**
     * 邀请超时时间（秒）
     */
    private long timeout;
    /**
     * 发起时间（秒）
     */
    private long initiateTime;
    /**
     * video 或者audio
     */
    private String mediaType;
    /**
     * 1为单聊，2为群聊
     */
    private int sessionType;
    /**
     * 和之前定义一致
     */
    private int platformID;

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

    public long getInitiateTime() {
        return initiateTime;
    }

    public void setInitiateTime(long initiateTime) {
        this.initiateTime = initiateTime;
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
