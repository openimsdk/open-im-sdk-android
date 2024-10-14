package io.openim.android.sdk.models;

public class GroupMemberInfoReq {
    /**
     * 群Id
     */
    private String groupID;
    /**
     * 用户Id
     */
    private String userID;
    /**
     * 用户名
     */
    private String nickname;
    /**
     * 头像
     */
    private String faceURL;
    /**
     * 群角色{@link io.openim.android.sdk.enums.GroupRole}
     */
    private Integer roleLevel;
    /**
     * 扩展字段
     */
    private String ex;

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFaceURL() {
        return faceURL;
    }

    public void setFaceURL(String faceURL) {
        this.faceURL = faceURL;
    }

    public Integer getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(Integer roleLevel) {
        this.roleLevel = roleLevel;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }
}
