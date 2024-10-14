package io.openim.android.sdk.models;

public class SetGroupMemberInfo {
    /**
     * 群ID
     */
    private String groupID;
    /**
     * 群成员 ID
     */
    private String userID;
    /**
     * 群成员昵称
     */
    private String nickname;
    /**
     * 群成员头像
     */
    private String faceURL;
    /**
     * 群成员角色，1 普通成员；2 群主；3 管理员
     */
    private Integer roleLevel;
    /**
     * 扩展参数
     */
    private String ex;

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getFaceURL() {
        return faceURL;
    }

    public void setFaceURL(String faceURL) {
        this.faceURL = faceURL;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
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

    public Integer getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(Integer roleLevel) {
        this.roleLevel = roleLevel;
    }
}
