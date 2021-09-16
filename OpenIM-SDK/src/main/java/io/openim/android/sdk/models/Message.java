package io.openim.android.sdk.models;

import java.util.List;

public class Message {
    /**
     * 消息唯一ID
     */
    private String clientMsgID;
    /**
     * 消息服务器ID，暂时不使用
     */
    private String serverMsgID;
    /**
     * 消息创建时间，单位纳秒
     */
    private long createTime;
    /**
     * 消息发送时间，单位纳秒
     */
    private long sendTime;
    /**
     * 发送者ID
     */
    private String sendID;
    /**
     * 接收者ID
     */
    private String recvID;
    /**
     * 标识消息是用户级别还是系统级别 100:用户 200:系统
     */
    private int msgFrom;
    /**
     * 消息类型：<br/>
     * 101:文本消息<br/>
     * 102:图片消息<br/>
     * 103:语音消息<br/>
     * 104:视频消息<br/>
     * 105:文件消息<br/>
     * 106:@消息<br/>
     * 107:合并消息<br/>
     * 108:转发消息<br/>
     * 109:位置消息<br/>
     * 110:自定义消息<br/>
     * 111:撤回消息回执<br/>
     * 112:C2C已读回执<br/>
     * 113:正在输入状态
     */
    private int contentType;
    /**
     * 平台类型 1:ios 2:android 3:windows 4:osx 5:web 6:mini 7:linux
     */
    private int platformID;
    /**
     * 强制推送列表(被@的用户)
     */
    private List<String> forceList;
    /**
     * 发送者昵称
     */
    private String senderNickName;
    /**
     * 发送者头像
     */
    private String senderFaceUrl;
    /**
     * 群聊ID
     */
    private String groupID;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 消息唯一序列号
     */
    private int seq;
    /**
     * 是否已读
     */
    private boolean isRead;
    /**
     * 消息状态 1:发送中 2:发送成功 3:发送失败 4:已删除 5:已撤回
     */
    private int status;
    /**
     * 消息备注
     */
    private String remark;
    /**
     *
     */
    private Object ext;
    /**
     * 会话类型 1:单聊 2:群聊
     */
    private int sessionType;
    /**
     * 图片信息
     */
    private PictureElem pictureElem;
    /**
     * 语音信息
     */
    private SoundElem soundElem;
    /**
     * 视频信息
     */
    private VideoElem videoElem;
    /**
     * 文件信息
     */
    private FileElem fileElem;
    /**
     * _@信息
     */
    private AtElem atElem;
    /**
     * 位置信息
     */
    private LocationElem locationElem;
    /**
     * 引用消息
     */
    private QuoteElem quoteElem;
    /**
     * 自定义信息
     */
    private CustomElem customElem;
    /**
     * 合并信息
     */
    private MergeElem mergeElem;

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

    public LocationElem getLocationElem() {
        return locationElem;
    }

    public void setLocationElem(LocationElem locationElem) {
        this.locationElem = locationElem;
    }

    public QuoteElem getQuoteElem() {
        return quoteElem;
    }

    public void setQuoteElem(QuoteElem quoteElem) {
        this.quoteElem = quoteElem;
    }

    public CustomElem getCustomElem() {
        return customElem;
    }

    public void setCustomElem(CustomElem customElem) {
        this.customElem = customElem;
    }

    public MergeElem getMergeElem() {
        return mergeElem;
    }

    public void setMergeElem(MergeElem mergeElem) {
        this.mergeElem = mergeElem;
    }
}

