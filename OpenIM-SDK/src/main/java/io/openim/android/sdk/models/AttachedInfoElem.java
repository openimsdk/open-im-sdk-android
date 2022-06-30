package io.openim.android.sdk.models;

public class AttachedInfoElem {
    /**
     * 组信息已读详细
     */
    private GroupHasReadInfo groupHasReadInfo;
    /**
     * 是否是私聊消息（阅后即焚消息）
     */
    private boolean isPrivateChat;
    /**
     * 消息已读时间
     */
    private long hasReadTime;

    public GroupHasReadInfo getGroupHasReadInfo() {
        return groupHasReadInfo;
    }

    public void setGroupHasReadInfo(GroupHasReadInfo groupHasReadInfo) {
        this.groupHasReadInfo = groupHasReadInfo;
    }

    public boolean isPrivateChat() {
        return isPrivateChat;
    }

    public void setPrivateChat(boolean privateChat) {
        isPrivateChat = privateChat;
    }

    public long getHasReadTime() {
        return hasReadTime;
    }

    public void setHasReadTime(long hasReadTime) {
        this.hasReadTime = hasReadTime;
    }
}
