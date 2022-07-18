package io.openim.android.sdk.models;

public class RevokedInfo {

    /**
     * 撤回者ID
     */
    private String revokerID;

    /**
     * 撤回者群角色 {@link io.openim.android.sdk.enums.GroupRole}
     */
    private int revokerRole;

    /**
     * 撤回者昵称
     */
    private String revokerNickname;
    /**
     * 消息id
     */
    private String clientMsgID;
    /**
     * 撤回时间
     */
    private long revokeTime;
    /**
     * 消息发送时间
     */
    private long sourceMessageSendTime;
    /**
     * 消息发送者
     */
    private String sourceMessageSendID;
    /**
     * 消息发送者昵称
     */
    private String sourceMessageSenderNickname;
    /**
     * 会话类型 {@link io.openim.android.sdk.enums.ConversationType}
     */
    private int sessionType;

    public String getRevokerID() {
        return revokerID;
    }

    public void setRevokerID(String revokerID) {
        this.revokerID = revokerID;
    }

    public int getRevokerRole() {
        return revokerRole;
    }

    public void setRevokerRole(int revokerRole) {
        this.revokerRole = revokerRole;
    }

    public String getRevokerNickname() {
        return revokerNickname;
    }

    public void setRevokerNickname(String revokerNickname) {
        this.revokerNickname = revokerNickname;
    }

    public String getClientMsgID() {
        return clientMsgID;
    }

    public void setClientMsgID(String clientMsgID) {
        this.clientMsgID = clientMsgID;
    }

    public long getRevokeTime() {
        return revokeTime;
    }

    public void setRevokeTime(long revokeTime) {
        this.revokeTime = revokeTime;
    }

    public long getSourceMessageSendTime() {
        return sourceMessageSendTime;
    }

    public void setSourceMessageSendTime(long sourceMessageSendTime) {
        this.sourceMessageSendTime = sourceMessageSendTime;
    }

    public String getSourceMessageSendID() {
        return sourceMessageSendID;
    }

    public void setSourceMessageSendID(String sourceMessageSendID) {
        this.sourceMessageSendID = sourceMessageSendID;
    }

    public String getSourceMessageSenderNickname() {
        return sourceMessageSenderNickname;
    }

    public void setSourceMessageSenderNickname(String sourceMessageSenderNickname) {
        this.sourceMessageSenderNickname = sourceMessageSenderNickname;
    }

    public int getSessionType() {
        return sessionType;
    }

    public void setSessionType(int sessionType) {
        this.sessionType = sessionType;
    }
}
