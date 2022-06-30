package io.openim.android.sdk.models;


public class NotDisturbInfo {
    /**
     * 会话id
     * */
    private String conversationId;
    /**
     * 免打扰状态
     * 1:屏蔽消息; 2:接收消息但不提示; 0:正常
     * */
    private int result;

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
