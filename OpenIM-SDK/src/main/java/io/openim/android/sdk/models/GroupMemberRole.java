package io.openim.android.sdk.models;

public class GroupMemberRole {
    /**
     * 成员id
     */
    private String userID;
    /**
     * 1普通成员, 2群主，3管理员 {@link io.openim.android.sdk.enums.GroupRole}
     */
    private int roleLevel;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(int roleLevel) {
        this.roleLevel = roleLevel;
    }
}
