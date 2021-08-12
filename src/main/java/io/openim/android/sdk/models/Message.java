package io.openim.android.sdk.models;

import java.util.List;

public class Message {
    private String clientMsgID;
    private String serverMsgID;
    private long createTime;
    private long sendTime;
    private String sendID;
    private String recvID;
    private int msgFrom;
    private int contentType;
    private int platformID;
    private List<String> forceList;
    private String senderNickName;
    private String senderFaceUrl;
    private String groupID;
    private String content;
    private int seq;
    private boolean isRead;
    private int status;
    private String remark;
    private Object ext;
    private int sessionType;
    private PictureElem pictureElem;
    private SoundElem soundElem;
    private VideoElem videoElem;
    private FileElem fileElem;
    private AtElem atElem;

    public String getClientMsgID() {
        return clientMsgID;
    }

    public void setClientMsgID(String clientMsgID) {
        this.clientMsgID = clientMsgID;
    }

    public String getServerMsgID() {
        return serverMsgID;
    }

    public void setServerMsgID(String serverMsgID) {
        this.serverMsgID = serverMsgID;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getSendTime() {
        return sendTime;
    }

    public void setSendTime(long sendTime) {
        this.sendTime = sendTime;
    }

    public String getSendID() {
        return sendID;
    }

    public void setSendID(String sendID) {
        this.sendID = sendID;
    }

    public String getRecvID() {
        return recvID;
    }

    public void setRecvID(String recvID) {
        this.recvID = recvID;
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

    public int getPlatformID() {
        return platformID;
    }

    public void setPlatformID(int platformID) {
        this.platformID = platformID;
    }

    public List<String> getForceList() {
        return forceList;
    }

    public void setForceList(List<String> forceList) {
        this.forceList = forceList;
    }

    public String getSenderNickName() {
        return senderNickName;
    }

    public void setSenderNickName(String senderNickName) {
        this.senderNickName = senderNickName;
    }

    public String getSenderFaceUrl() {
        return senderFaceUrl;
    }

    public void setSenderFaceUrl(String senderFaceUrl) {
        this.senderFaceUrl = senderFaceUrl;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Object getExt() {
        return ext;
    }

    public void setExt(Object ext) {
        this.ext = ext;
    }

    public int getSessionType() {
        return sessionType;
    }

    public void setSessionType(int sessionType) {
        this.sessionType = sessionType;
    }

    public PictureElem getPictureElem() {
        return pictureElem;
    }

    public void setPictureElem(PictureElem pictureElem) {
        this.pictureElem = pictureElem;
    }

    public SoundElem getSoundElem() {
        return soundElem;
    }

    public void setSoundElem(SoundElem soundElem) {
        this.soundElem = soundElem;
    }

    public VideoElem getVideoElem() {
        return videoElem;
    }

    public void setVideoElem(VideoElem videoElem) {
        this.videoElem = videoElem;
    }

    public FileElem getFileElem() {
        return fileElem;
    }

    public void setFileElem(FileElem fileElem) {
        this.fileElem = fileElem;
    }

    public AtElem getAtElem() {
        return atElem;
    }

    public void setAtElem(AtElem atElem) {
        this.atElem = atElem;
    }
}

