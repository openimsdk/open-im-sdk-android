package io.openim.android.sdk.models;

public class UserInfo {
    /**
     * 用户id
     */
    private String uid;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户头像
     */
    private String icon;
    /**
     * 性别：1男，2女
     */
    private int gender;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 生日
     */
    private String birth;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 扩展字段
     */
    private String ex;
    /**
     * 备注
     */
    private String comment;
    /**
     * 黑名单：1已拉入黑名单
     */
    private int isInBlackList;
    /**
     * 验证消息
     */
    private String reqMessage;
    /**
     * 申请时间
     */
    private String applyTime;
    /**
     * 好友申请列表：0等待处理；1已同意；2已拒绝<br />
     * 好友关系：1已经是好友
     */
    private int flag;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getIsInBlackList() {
        return isInBlackList;
    }

    public void setIsInBlackList(int isInBlackList) {
        this.isInBlackList = isInBlackList;
    }

    public String getReqMessage() {
        return reqMessage;
    }

    public void setReqMessage(String reqMessage) {
        this.reqMessage = reqMessage;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
