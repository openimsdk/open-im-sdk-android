package io.openim.android.sdk.models;

import java.util.List;

public class HaveReadInfo {
    private String uid;
    private List<String> msgIDList;
    private int readTime;
    private int msgFrom;
    private int contentType;
    private int sessionType;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<String> getMsgIDList() {
        return msgIDList;
    }

    public void setMsgIDList(List<String> msgIDList) {
        this.msgIDList = msgIDList;
    }

    public int getReadTime() {
        return readTime;
    }

    public void setReadTime(int readTime) {
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
