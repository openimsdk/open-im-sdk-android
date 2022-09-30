package io.openim.android.sdk.models;

public class Participant {
    private GroupInfo groupInfo;
    private GroupMembersInfo groupMemberInfo;
    private UserInfo userInfo;

    public GroupInfo getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(GroupInfo groupInfo) {
        this.groupInfo = groupInfo;
    }

    public GroupMembersInfo getGroupMemberInfo() {
        return groupMemberInfo;
    }

    public void setGroupMemberInfo(GroupMembersInfo groupMemberInfo) {
        this.groupMemberInfo = groupMemberInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
