package io.openim.android.sdk.models;

public class WorkMomentsInfo {
    private int notificationMsgType;
    private String replyUserName;
    private String replyUserID;
    private String content;
    private String contentID;
    private String workMomentID;
    private String userID;
    private String userName;
    private String faceURL;
    private String workMomentContent;
    private long createTime;

    public int getNotificationMsgType() {
        return notificationMsgType;
    }

    public void setNotificationMsgType(int notificationMsgType) {
        this.notificationMsgType = notificationMsgType;
    }

    public String getReplyUserName() {
        return replyUserName;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName;
    }

    public String getReplyUserID() {
        return replyUserID;
    }

    public void setReplyUserID(String replyUserID) {
        this.replyUserID = replyUserID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentID() {
        return contentID;
    }

    public void setContentID(String contentID) {
        this.contentID = contentID;
    }

    public String getWorkMomentID() {
        return workMomentID;
    }

    public void setWorkMomentID(String workMomentID) {
        this.workMomentID = workMomentID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFaceURL() {
        return faceURL;
    }

    public void setFaceURL(String faceURL) {
        this.faceURL = faceURL;
    }

    public String getWorkMomentContent() {
        return workMomentContent;
    }

    public void setWorkMomentContent(String workMomentContent) {
        this.workMomentContent = workMomentContent;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
