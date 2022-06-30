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
    private String faceURL;
    /**
     * 接收消息选项：<br/>
     * 0:在线正常接收消息，离线时进行推送 <br/>
     * 1:不会接收到消息<br/>
     * 2:在线正常接收消息，离线不会有推送
     */
    private int recvMsgOpt;
    /**
     * 未读消息数量
     */
    private int unreadCount;
    /**
     * 强提示 如at消息，公告 {@link io.openim.android.sdk.enums.GroupAtType}
     */
    private int groupAtType;
    /**
     * 最后一条消息 消息对象json字符串
     */
    private String latestMsg;
    /**
     * 最后一条消息发送时间(ms)
     */
    private long latestMsgSendTime;
    /**
     * 会话草稿
     */
    private String draftText;
    /**
     * 会话草稿设置时间
     */
    private long draftTextTime;
    /**
     * 是否置顶，1置顶
     */
    private boolean isPinned;
    /**
     * 是否开启私聊
     */
    private boolean isPrivateChat;
    /**
     * 扩展预留字段
     */
    private String ext;

    /**
     * 是否还在群里
     * */
    private boolean isNotInGroup;


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

    public String getFaceURL() {
        return faceURL;
    }

    public void setFaceURL(String faceURL) {
        this.faceURL = faceURL;
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

    public int getGroupAtType() {
        return groupAtType;
    }

    public void setGroupAtType(int groupAtType) {
        this.groupAtType = groupAtType;
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

    public long getDraftTextTime() {
        return draftTextTime;
    }

    public void setDraftTextTime(long draftTextTime) {
        this.draftTextTime = draftTextTime;
    }

    public boolean isPinned() {
        return isPinned;
    }

    public void setPinned(boolean pinned) {
        isPinned = pinned;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public boolean isPrivateChat() {
        return isPrivateChat;
    }

    public void setPrivateChat(boolean privateChat) {
        isPrivateChat = privateChat;
    }

    public boolean isNotInGroup() {
        return isNotInGroup;
    }

    public void setNotInGroup(boolean notInGroup) {
        isNotInGroup = notInGroup;
    }
}
