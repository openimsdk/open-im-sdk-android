package io.openim.android.sdk.models;

public class GroupApplicationInfo {
    /**
     * 群id
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
    private String groupFaceURL;
    /**
     * 创建时间
     */
    private long createTime;
    /**
     * 状态
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
     * 拥有者id
     */
    private String ownerUserID;
    /**
     * 成员数量
     */
    private int memberCount;
    /**
     * 申请者的id
     */
    private String userID;
    /**
     * 申请者的昵称
     */
    private String nickname;
    /**
     * 申请者的头像
     */
    private String userFaceURL;
    /**
     * 申请者的性别
     */
    private int gender;
    /**
     * REFUSE = -1, AGREE = 1
     * -1：拒绝，1：同意
     */
    private int handleResult;
    /**
     * 申请原因
     */
    private String reqMsg;
    /**
     * 处理结果描述
     */
    private String handledMsg;
    /**
     * 申请时间
     */
    private long reqTime;
    /**
     * 处理者的id
     */
    private String handleUserID;
    /**
     * 处理时间
     */
    private long handledTime;
    /**
     * 扩展字段
     */
    private String ex;

    /**
     * 2：通过邀请  3：通过搜索  4：通过二维码
     */
    private int joinSource;

    /**
     * 邀请进群用户ID
     */
    private String inviterUserID;


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

    public String getGroupFaceURL() {
        return groupFaceURL;
    }

    public void setGroupFaceURL(String groupFaceURL) {
        this.groupFaceURL = groupFaceURL;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
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

    public String getOwnerUserID() {
        return ownerUserID;
    }

    public void setOwnerUserID(String ownerUserID) {
        this.ownerUserID = ownerUserID;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserFaceURL() {
        return userFaceURL;
    }

    public void setUserFaceURL(String userFaceURL) {
        this.userFaceURL = userFaceURL;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(int handleResult) {
        this.handleResult = handleResult;
    }

    public String getReqMsg() {
        return reqMsg;
    }

    public void setReqMsg(String reqMsg) {
        this.reqMsg = reqMsg;
    }

    public String getHandledMsg() {
        return handledMsg;
    }

    public void setHandledMsg(String handledMsg) {
        this.handledMsg = handledMsg;
    }

    public long getReqTime() {
        return reqTime;
    }

    public void setReqTime(long reqTime) {
        this.reqTime = reqTime;
    }

    public String getHandleUserID() {
        return handleUserID;
    }

    public void setHandleUserID(String handleUserID) {
        this.handleUserID = handleUserID;
    }

    public long getHandledTime() {
        return handledTime;
    }

    public void setHandledTime(long handledTime) {
        this.handledTime = handledTime;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public int getJoinSource() {
        return joinSource;
    }

    public void setJoinSource(int joinSource) {
        this.joinSource = joinSource;
    }

    public String getInviterUserID() {
        return inviterUserID;
    }

    public void setInviterUserID(String inviterUserID) {
        this.inviterUserID = inviterUserID;
    }
}
