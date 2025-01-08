package io.openim.android.sdk.models;

public class ConversationReq {
    /**
     * 会话id
     */
    private String conversationID;
    /**
     * 会话类型 1:单聊 2:群聊
     */
    private Integer conversationType;
    /**
     * 会话对象用户ID
     */
    private String userID;
    /**
     * 会话群聊ID
     */
    private String groupID;
    /**
     * 接收消息选项：<br/>
     * 0:在线正常接收消息，离线时进行推送 <br/>
     * 1:不会接收到消息<br/>
     * 2:在线正常接收消息，离线不会有推送
     */
    private Integer recvMsgOpt;
    /**
     * 是否置顶，1置顶
     */
    private Boolean isPinned;
    /**
     * 是否开启私聊
     */
    private Boolean isPrivateChat;
    /**
     * 扩展预留字段
     */
    private String ex;
    /**
     * 阅读时长 s，即超过了burnDuration秒触发销毁
     */
    private Integer burnDuration;
    /**
     * 强提示 如at消息，公告 {@link io.openim.android.sdk.enums.GroupAtType}
     */
    private Integer groupAtType;

    public String getConversationID() {
        return conversationID;
    }

    protected void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }

    public String getUserID() {
        return userID;
    }

    protected void setUserID(String userID) {
        this.userID = userID;
    }

    public String getGroupID() {
        return groupID;
    }

    protected void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public Boolean getPrivateChat() {
        return isPrivateChat;
    }

    public void setPrivateChat(boolean privateChat) {
        isPrivateChat = privateChat;
    }

    public Boolean getPinned() {
        return isPinned;
    }

    public void setPinned(boolean pinned) {
        isPinned = pinned;
    }

    public Integer getConversationType() {
        return conversationType;
    }

    protected void setConversationType(int conversationType) {
        this.conversationType = conversationType;
    }

    public Integer getRecvMsgOpt() {
        return recvMsgOpt;
    }

    public void setRecvMsgOpt(int recvMsgOpt) {
        this.recvMsgOpt = recvMsgOpt;
    }

    public Integer getBurnDuration() {
        return burnDuration;
    }

    public void setBurnDuration(int burnDuration) {
        this.burnDuration = burnDuration;
    }

    public Integer getGroupAtType() {
        return groupAtType;
    }

    public void setGroupAtType(int groupAtType) {
        this.groupAtType = groupAtType;
    }
}
