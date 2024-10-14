package io.openim.android.sdk.models;

public class GroupInfoReq {
    /**
     * 群ID
     */
    private String groupID;
    /**
     * 群名称
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
     * 扩展参数
     */
    private String ex;
    /**
     * 进群验证方式 {@link io.openim.android.sdk.enums.GroupVerification}
     */
    private Integer needVerification;
    /**
     *  不允许通过群获取成员资料 0：关闭，1：打开
     */
    private Integer lookMemberInfo;
    /**
     * 不允许通过群添加好友 0：关闭，1：打开
     */
    private Integer applyMemberFriend;

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

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public Integer getNeedVerification() {
        return needVerification;
    }

    public void setNeedVerification(Integer needVerification) {
        this.needVerification = needVerification;
    }

    public Integer getLookMemberInfo() {
        return lookMemberInfo;
    }

    public void setLookMemberInfo(Integer lookMemberInfo) {
        this.lookMemberInfo = lookMemberInfo;
    }

    public Integer getApplyMemberFriend() {
        return applyMemberFriend;
    }

    public void setApplyMemberFriend(Integer applyMemberFriend) {
        this.applyMemberFriend = applyMemberFriend;
    }
}
