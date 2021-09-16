package io.openim.android.sdk.models;

public class GroupApplicationInfo {
    /**
     *
     */
    private String id;
    /**
     * 群组ID
     */
    private String groupID;
    /**
     * 申请用户的ID
     */
    private String fromUserID;
    /**
     * 接收用户的ID
     */
    private String toUserID;
    /**
     * 0：未处理，1：拒绝，2：同意
     */
    private int flag; //INIT = 0, REFUSE = -1, AGREE = 1
    /**
     * 原因
     */
    private String reqMsg;
    /**
     * 处理反馈
     */
    private String handledMsg;
    /**
     * 时间
     */
    private int createTime;
    /**
     * 申请用户的昵称
     */
    private String fromUserNickName;
    /**
     * 接收用户的昵称
     */
    private String toUserNickName;
    /**
     * 申请用户的头像
     */
    private String fromUserFaceURL;
    /**
     * 接收用户的昵称
     */
    private String toUserFaceURL;
    /**
     * 处理人
     */
    private String handledUser;
    /**
     * 0：申请进群, 1：邀请进群
     */
    private int type; //APPLICATION = 0, INVITE = 1
    /**
     * 0：未处理, 1：被其他人处理, 2：被自己处理
     */
    private int handleStatus; //UNHANDLED = 0, BY_OTHER = 1, BY_SELF = 2
    /**
     * 0：拒绝，1：同意
     */
    private int handleResult; //REFUSE = 0, AGREE = 1

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(String fromUserID) {
        this.fromUserID = fromUserID;
    }

    public String getToUserID() {
        return toUserID;
    }

    public void setToUserID(String toUserID) {
        this.toUserID = toUserID;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
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

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public String getFromUserNickName() {
        return fromUserNickName;
    }

    public void setFromUserNickName(String fromUserNickName) {
        this.fromUserNickName = fromUserNickName;
    }

    public String getToUserNickName() {
        return toUserNickName;
    }

    public void setToUserNickName(String toUserNickName) {
        this.toUserNickName = toUserNickName;
    }

    public String getFromUserFaceURL() {
        return fromUserFaceURL;
    }

    public void setFromUserFaceURL(String fromUserFaceURL) {
        this.fromUserFaceURL = fromUserFaceURL;
    }

    public String getToUserFaceURL() {
        return toUserFaceURL;
    }

    public void setToUserFaceURL(String toUserFaceURL) {
        this.toUserFaceURL = toUserFaceURL;
    }

    public String getHandledUser() {
        return handledUser;
    }

    public void setHandledUser(String handledUser) {
        this.handledUser = handledUser;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(int handleStatus) {
        this.handleStatus = handleStatus;
    }

    public int getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(int handleResult) {
        this.handleResult = handleResult;
    }
}
