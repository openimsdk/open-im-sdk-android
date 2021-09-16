package io.openim.android.sdk.models;

public class GroupMembersInfo {
    /**
     * 群id
     */
    private String groupID;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 群角色
     */
    private int role;
    /**
     * 入群时间
     */
    private int joinTime;
    /**
     * 群内昵称
     */
    private String nickName;
    /**
     * 头像
     */
    private String faceUrl;
    private Object ext;

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(int joinTime) {
        this.joinTime = joinTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public Object getExt() {
        return ext;
    }

    public void setExt(Object ext) {
        this.ext = ext;
    }
}
