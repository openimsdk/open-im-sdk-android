package io.openim.android.sdk.models;

public class ConversationInfo {
    private String conversationID;
    private int conversationType;
    private String userID;
    private String groupID;
    private String showName;
    private String faceUrl;
    private int recvMsgOpt;
    private int unreadCount;
    private Message latestMsg;
    private long latestMsgSendTime;
    private String draftText;
    private long draftTimestamp;
    private int isPinned;

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }

    public int getConversationType() {
        return conversationType;
    }

    public void setConversationType(int conversationType) {
        this.conversationType = conversationType;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public int getRecvMsgOpt() {
        return recvMsgOpt;
    }

    public void setRecvMsgOpt(int recvMsgOpt) {
        this.recvMsgOpt = recvMsgOpt;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public Message getLatestMsg() {
        return latestMsg;
    }

    public void setLatestMsg(Message latestMsg) {
        this.latestMsg = latestMsg;
    }

    public long getLatestMsgSendTime() {
        return latestMsgSendTime;
    }

    public void setLatestMsgSendTime(long latestMsgSendTime) {
        this.latestMsgSendTime = latestMsgSendTime;
    }

    public String getDraftText() {
        return draftText;
    }

    public void setDraftText(String draftText) {
        this.draftText = draftText;
    }

    public long getDraftTimestamp() {
        return draftTimestamp;
    }

    public void setDraftTimestamp(long draftTimestamp) {
        this.draftTimestamp = draftTimestamp;
    }

    public int getIsPinned() {
        return isPinned;
    }

    public void setIsPinned(int isPinned) {
        this.isPinned = isPinned;
    }
}
