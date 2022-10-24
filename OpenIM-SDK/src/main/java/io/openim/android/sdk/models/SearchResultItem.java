package io.openim.android.sdk.models;

import java.util.List;

public class SearchResultItem {

    /**
     * 会话ID
     */
    private String conversationID;

    /**
     * 这个会话下的消息数量
     */
    private int messageCount;

    /**
     * 显示名
     */
    public String showName;

    /**
     * 头像
     */
    public String faceURL;


    /**
     * Message的列表
     */
    private List<Message> messageList;

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }

    public int getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
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
}
