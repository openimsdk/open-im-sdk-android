package io.openim.android.sdk.models;

import java.util.List;

public class GroupMessageReadInfo {
    private String clientMsgID;
    private int hasReadCount;
    private int unreadCount;
    private List<GroupMembersInfo> readMembers;


    public String getClientMsgID() {
        return clientMsgID;
    }

    public void setClientMsgID(String clientMsgID) {
        this.clientMsgID = clientMsgID;
    }

    public int getHasReadCount() {
        return hasReadCount;
    }

    public void setHasReadCount(int hasReadCount) {
        this.hasReadCount = hasReadCount;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public List<GroupMembersInfo> getReadMembers() {
        return readMembers;
    }

    public void setReadMembers(List<GroupMembersInfo> readMembers) {
        this.readMembers = readMembers;
    }
}
