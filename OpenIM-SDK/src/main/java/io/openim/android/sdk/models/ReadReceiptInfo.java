package io.openim.android.sdk.models;

import java.util.List;

public class ReadReceiptInfo {
    /**
     * 用户id
     */
    private String userID;
    /**
     * 组id
     */
    private String groupID;
    /**
     * 已读消息id
     */
    private List<String> msgIDList;
    /**
     * 阅读时间
     */
    private long readTime;
    /**
     * 标识消息是用户级别还是系统级别 100:用户 200:系统
     */
    private int msgFrom;
    /**
     * {@link io.openim.android.sdk.enums.MessageType}
     * 消息类型：
     * 101:文本消息
     * 102:图片消息
     * 103:语音消息
     * 104:视频消息
     * 105:文件消息
     * 106:@消息
     * 107:合并消息
     * 108:转发消息
     * 109:位置消息
     * 110:自定义消息
     * 111:撤回消息回执
     * 112:C2C已读回执
     * 113:正在输入状态
     */
    private int contentType;
    /**
     * {@link io.openim.android.sdk.enums.ConversationType}
     * 会话类型 1:单聊 2:群聊
     */
    private int sessionType;

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

    public List<String> getMsgIDList() {
        return msgIDList;
    }

    public void setMsgIDList(List<String> msgIDList) {
        this.msgIDList = msgIDList;
    }

    public long getReadTime() {
        return readTime;
    }

    public void setReadTime(long readTime) {
        this.readTime = readTime;
    }

    public int getMsgFrom() {
        return msgFrom;
    }

    public void setMsgFrom(int msgFrom) {
        this.msgFrom = msgFrom;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public int getSessionType() {
        return sessionType;
    }

    public void setSessionType(int sessionType) {
        this.sessionType = sessionType;
    }
}
