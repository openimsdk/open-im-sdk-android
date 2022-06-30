package io.openim.android.sdk.models;

/**
 * 部门成员
 */
public class DeptMemberInfo {
    /**
     * 成员id
     */
    private String userID;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 英文名
     */
    private String englishName;
    /**
     * 头像
     */
    private String faceURL;
    /**
     * 性别
     */
    private int gender;
    /**
     * 移动电话
     */
    private String mobile;
    /**
     * 座机
     */
    private String telephone;
    /**
     * 出生日期
     */
    private long birth;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 部门id
     */
    private String departmentID;
    /**
     * 排序
     */
    private int order;
    /**
     * 职位
     */
    private String position;
    /**
     * 领导
     */
    private int leader;
    /**
     * 状态
     */
    private int status;
    /**
     * 创建时间
     */
    private long createTime;
    /**
     * 附加字段
     */
    private String ex;
    /**
     * 附加信息
     */
    private String attachedInfo;

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

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getFaceURL() {
        return faceURL;
    }

    public void setFaceURL(String faceURL) {
        this.faceURL = faceURL;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public long getBirth() {
        return birth;
    }

    public void setBirth(long birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getLeader() {
        return leader;
    }

    public void setLeader(int leader) {
        this.leader = leader;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getAttachedInfo() {
        return attachedInfo;
    }

    public void setAttachedInfo(String attachedInfo) {
        this.attachedInfo = attachedInfo;
    }
}
