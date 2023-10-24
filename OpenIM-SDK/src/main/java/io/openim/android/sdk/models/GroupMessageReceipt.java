package io.openim.android.sdk.models;

import java.util.List;

public class GroupMessageReceipt {
    private String conversationID;
    private List<GroupMessageReadInfo> groupMessageReadInfo;

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }

    public List<GroupMessageReadInfo> getGroupMessageReadInfo() {
        return groupMessageReadInfo;
    }

    public void setGroupMessageReadInfo(List<GroupMessageReadInfo> groupMessageReadInfo) {
        this.groupMessageReadInfo = groupMessageReadInfo;
    }
}
