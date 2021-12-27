package io.openim.android.sdk.models;

public class ConversationInfo {
    /**
     * 会话id
     */
    private String conversationID;
    /**
     * 会话类型 1:单聊 2:群聊
     */
    private int conversationType;
    /**
     * 会话对象用户ID
     */
    private String userID;
    /**
     * 会话群聊ID
     */
    private String groupID;
    /**
     * 会话对象(用户或群聊)名称
     */
    private String showName;
    /**
     * 用户头像或群聊头像
     */
    private String faceUrl;
    /**
     * 接收消息选项：<br/>
     * 0:在线正常接收消息，离线时进行推送<br/>
     * 1:不会接收到消息<br/>
     * 2:在线正常接收消息，离线不会有推送
     */
    private int recvMsgOpt;
    /**
     * 未读消息数量
     */
    private int unreadCount;
    /**
     * 最后一条消息 消息对象json字符串
     */
    private String latestMsg;
    /**
     * 最后一条消息发送时间(ns)
     */
    private long latestMsgSendTime;
    /**
     * 会话草稿
     */
    private String draftText;
    /**
     * 会话草稿设置时间
     */
    private long draftTimestamp;
    /**
     * 是否置顶，1置顶
     */
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

    public String getLatestMsg() {
        return latestMsg;
    }

    public void setLatestMsg(String latestMsg) {
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
