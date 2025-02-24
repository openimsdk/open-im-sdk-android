package io.openim.android.sdk.models;

import java.util.Map;
import java.util.Objects;

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
     * 消息发送时间，单位ms
     */
    private long sendTime;
    /**
     * 会话类型 1:单聊 2:群聊 {@link io.openim.android.sdk.enums.ConversationType}
     */
    private int sessionType;
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
     * {@link io.openim.android.sdk.enums.MessageType}
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
     * {@link io.openim.android.sdk.enums.Platform}
     * 平台类型 1:ios 2:android 3:windows 4:osx 5:web 6:mini 7:linux
     */
    private int platformID;
    /**
     * 发送者昵称
     */
    private String senderNickname;
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
//    private String content;
    /**
     * 消息唯一序列号
     */
    private int seq;
    /**
     * 是否已读
     */
    private boolean isRead;
    /**
     * {@link io.openim.android.sdk.enums.MessageStatus}
     * 消息状态 1:发送中 2:发送成功 3:发送失败 4:已删除 5:已撤回
     */
    private int status;

    private boolean isReact;

    private boolean isExternalExtensions;

    /**
     * 离线消息推送内容
     */
    private OfflinePushInfo offlinePush;
    /**
     * 附加信息
     */
    private String attachedInfo;
    /**
     * android 附加字段
     */
    private Object ext;
    /**
     * go 附加字段
     */
    private Object ex;
    /**
     * localEx属性，setMessageLocalEx
     */
    private String localEx;
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
    private AtTextElem atTextElem;
    /**
     * 位置信息
     */
    private LocationElem locationElem;
    /**
     * 自定义信息
     */
    private CustomElem customElem;
    /**
     * 引用消息
     */
    private QuoteElem quoteElem;
    /**
     * 合并信息
     */
    private MergeElem mergeElem;
    /**
     * 通知
     */
    private NotificationElem notificationElem;

    /**
     * 自定义表情
     */
    private FaceElem faceElem;

    /**
     * 附加信息 如：群消息已读
     */
    private AttachedInfoElem attachedInfoElem;

    private TextElem textElem;

    /// 个人名片
    private CardElem cardElem;

    ///
    private AdvancedTextElem advancedTextElem;

    ///
    private TypingElem typingElem;

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

    public int getSessionType() {
        return sessionType;
    }

    public void setSessionType(int sessionType) {
        this.sessionType = sessionType;
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

    public String getSenderNickname() {
        return senderNickname;
    }

    public void setSenderNickname(String senderNickname) {
        this.senderNickname = senderNickname;
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

    public boolean isReact() {
        return isReact;
    }

    public void setReact(boolean react) {
        isReact = react;
    }

    public boolean isExternalExtensions() {
        return isExternalExtensions;
    }

    public void setExternalExtensions(boolean externalExtensions) {
        isExternalExtensions = externalExtensions;
    }

    public OfflinePushInfo getOfflinePush() {
        return offlinePush;
    }

    public void setOfflinePush(OfflinePushInfo offlinePush) {
        this.offlinePush = offlinePush;
    }

    public String getAttachedInfo() {
        return attachedInfo;
    }

    public void setAttachedInfo(String attachedInfo) {
        this.attachedInfo = attachedInfo;
    }

    public Object getExt() {
        return ext;
    }

    public void setExt(Object ext) {
        this.ext = ext;
    }

    public Object getEx() {
        return ex;
    }

    public void setEx(Object ex) {
        this.ex = ex;
    }

    public String getLocalEx() {
        return localEx;
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

    public AtTextElem getAtTextElem() {
        return atTextElem;
    }

    public void setAtTextElem(AtTextElem atTextElem) {
        this.atTextElem = atTextElem;
    }

    public LocationElem getLocationElem() {
        return locationElem;
    }

    public void setLocationElem(LocationElem locationElem) {
        this.locationElem = locationElem;
    }

    public CustomElem getCustomElem() {
        return customElem;
    }

    public void setCustomElem(CustomElem customElem) {
        this.customElem = customElem;
    }

    public QuoteElem getQuoteElem() {
        return quoteElem;
    }

    public void setQuoteElem(QuoteElem quoteElem) {
        this.quoteElem = quoteElem;
    }

    public MergeElem getMergeElem() {
        return mergeElem;
    }

    public void setMergeElem(MergeElem mergeElem) {
        this.mergeElem = mergeElem;
    }

    public NotificationElem getNotificationElem() {
        return notificationElem;
    }

    public void setNotificationElem(NotificationElem notificationElem) {
        this.notificationElem = notificationElem;
    }

    public FaceElem getFaceElem() {
        return faceElem;
    }

    public void setFaceElem(FaceElem faceElem) {
        this.faceElem = faceElem;
    }

    public AttachedInfoElem getAttachedInfoElem() {
        return attachedInfoElem;
    }

    public void setAttachedInfoElem(AttachedInfoElem attachedInfoElem) {
        this.attachedInfoElem = attachedInfoElem;
    }

    public TextElem getTextElem() {
        return textElem;
    }

    public void setTextElem(TextElem textElem) {
        this.textElem = textElem;
    }

    public CardElem getCardElem() {
        return cardElem;
    }

    public void setCardElem(CardElem cardElem) {
        this.cardElem = cardElem;
    }

    public AdvancedTextElem getAdvancedTextElem() {
        return advancedTextElem;
    }

    public void setAdvancedTextElem(AdvancedTextElem advancedTextElem) {
        this.advancedTextElem = advancedTextElem;
    }

    public TypingElem getTypingElem() {
        return typingElem;
    }

    public void setTypingElem(TypingElem typingElem) {
        this.typingElem = typingElem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return Objects.equals(clientMsgID, message.clientMsgID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientMsgID);
    }
}

