package io.openim.android.sdk.models;

public class AttachedInfoElem {
    private GroupHasReadInfo groupHasReadInfo;
    private boolean isPrivateChat;
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
