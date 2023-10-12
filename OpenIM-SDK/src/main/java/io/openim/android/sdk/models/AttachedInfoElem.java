package io.openim.android.sdk.models;

import java.io.Serializable;

public class AttachedInfoElem implements Serializable {
    /**
     * 组信息已读详细
     */
    private GroupHasReadInfo groupHasReadInfo;
    /**
     * 是否是私聊消息（阅后即焚消息）
     */
    private boolean isPrivateChat;
    /**
     * 消息已读时间
     */
    private long hasReadTime;
    /**
     * 阅读时长 s
     * 即从hasReadTime时间算起，超过了burnDuration秒触发销毁
     */
    private int burnDuration;

    private boolean notSenderNotificationPush;
    private boolean isEncryption;
    private boolean inEncryptStatus;

    public boolean isNotSenderNotificationPush() {
        return notSenderNotificationPush;
    }

    public void setNotSenderNotificationPush(boolean notSenderNotificationPush) {
        this.notSenderNotificationPush = notSenderNotificationPush;
    }

    public boolean isEncryption() {
        return isEncryption;
    }

    public void setEncryption(boolean encryption) {
        isEncryption = encryption;
    }

    public boolean isInEncryptStatus() {
        return inEncryptStatus;
    }

    public void setInEncryptStatus(boolean inEncryptStatus) {
        this.inEncryptStatus = inEncryptStatus;
    }

    public GroupHasReadInfo getGroupHasReadInfo() {
        return groupHasReadInfo;
    }

    public void setGroupHasReadInfo(GroupHasReadInfo groupHasReadInfo) {
        this.groupHasReadInfo = groupHasReadInfo;
    }

    public boolean isPrivateChat() {
        return isPrivateChat;
    }

    public void setPrivateChat(boolean privateChat) {
        isPrivateChat = privateChat;
    }

    public long getHasReadTime() {
        return hasReadTime;
    }

    public void setHasReadTime(long hasReadTime) {
        this.hasReadTime = hasReadTime;
    }

    public int getBurnDuration() {
        return burnDuration;
    }

    public void setBurnDuration(int burnDuration) {
        this.burnDuration = burnDuration;
    }
}
