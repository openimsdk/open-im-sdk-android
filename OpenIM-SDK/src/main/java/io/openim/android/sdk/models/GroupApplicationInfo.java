package io.openim.android.sdk.models;

public class GroupApplicationInfo {
    private String id;
    private String groupID;
    private String fromUserID;
    private String toUserID;
    private int flag; //INIT = 0, REFUSE = -1, AGREE = 1
    private String reqMsg;
    private String handledMsg;
    private int createTime;
    private String fromUserNickName;
    private String toUserNickName;
    private String fromUserFaceURL;
    private String toUserFaceURL;
    private String handledUser;
    private int type; //APPLICATION = 0, INVITE = 1
    private int handleStatus; //UNHANDLED = 0, BY_OTHER = 1, BY_SELF = 2
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
