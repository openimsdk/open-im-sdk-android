package io.openim.android.sdk.models;

public class GroupInfo {
    /**
     * 组ID
     */
    private String groupID;
    /**
     * 群名
     */
    private String groupName;
    /**
     * 群公告
     */
    private String notification;
    /**
     * 群简介
     */
    private String introduction;
    /**
     * 群头像
     */
    private String faceURL;
    /**
     * 群主id
     */
    private String ownerUserID;
    /**
     * 创建时间
     */
    private long createTime;
    /**
     * 群成员数量
     */
    private int memberCount;
    /**
     * 群状态： ok = 0 blocked = 1 Dismissed = 2 Muted  = 3
     */
    private int status;
    /**
     * 创建者id
     */
    private String creatorUserID;
    /**
     * 群类型
     */
    private int groupType;
    /**
     * 扩展字段
     */
    private String ex;
    /**
     * 进群验证方式 {@link io.openim.android.sdk.enums.GroupVerification}
     */
    private int needVerification;

    /**
     * 不允许通过群获取成员资料 0：关闭，1：打开
     */
    private int lookMemberInfo;
    /**
     * 不允许通过群添加好友 0：关闭，1：打开
     */
    private int applyMemberFriend;
    /**
     * 通知更新时间
     */
    private long notificationUpdateTime;
    /**
     * 通知更新人
     */
    private String notificationUserID;

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getFaceURL() {
        return faceURL;
    }

    public void setFaceURL(String faceURL) {
        this.faceURL = faceURL;
    }

    public String getOwnerUserID() {
        return ownerUserID;
    }

    public void setOwnerUserID(String ownerUserID) {
        this.ownerUserID = ownerUserID;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreatorUserID() {
        return creatorUserID;
    }

    public void setCreatorUserID(String creatorUserID) {
        this.creatorUserID = creatorUserID;
    }

    public int getGroupType() {
        return groupType;
    }

    public void setGroupType(int groupType) {
        this.groupType = groupType;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public int getNeedVerification() {
        return needVerification;
    }

    public void setNeedVerification(int needVerification) {
        this.needVerification = needVerification;
    }

    public int getLookMemberInfo() {
        return lookMemberInfo;
    }

    public void setLookMemberInfo(int lookMemberInfo) {
        this.lookMemberInfo = lookMemberInfo;
    }

    public int getApplyMemberFriend() {
        return applyMemberFriend;
    }

    public void setApplyMemberFriend(int applyMemberFriend) {
        this.applyMemberFriend = applyMemberFriend;
    }

    public long getNotificationUpdateTime() {
        return notificationUpdateTime;
    }

    public void setNotificationUpdateTime(long notificationUpdateTime) {
        this.notificationUpdateTime = notificationUpdateTime;
    }

    public String getNotificationUserID() {
        return notificationUserID;
    }

    public void setNotificationUserID(String notificationUserID) {
        this.notificationUserID = notificationUserID;
    }
}
