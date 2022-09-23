package io.openim.android.sdk.models;

import java.util.List;

public class AdvancedMessage {
    private int errCode;
    private String errMsg;
    private int lastMinSeq;
    private boolean isEnd;
    private List<Message> messageList;

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public int getLastMinSeq() {
        return lastMinSeq;
    }

    public void setLastMinSeq(int lastMinSeq) {
        this.lastMinSeq = lastMinSeq;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
