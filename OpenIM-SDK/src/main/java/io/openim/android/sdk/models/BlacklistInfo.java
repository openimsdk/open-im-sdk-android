package io.openim.android.sdk.models;

/**
 * 黑名单详细
 */
public class BlacklistInfo {
    /**
     * 用户id
     */
    private String userID;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String faceURL;
    /**
     * 性别
     */
    private int gender;
    /**
     * 创建时间
     */
    private long createTime;
    /**
     * 添加方式
     */
    private int addSource;
    /**
     * 操作者
     */
    private String operatorUserID;
    /**
     * 附加信息
     */
    private String ex;

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

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getAddSource() {
        return addSource;
    }

    public void setAddSource(int addSource) {
        this.addSource = addSource;
    }

    public String getOperatorUserID() {
        return operatorUserID;
    }

    public void setOperatorUserID(String operatorUserID) {
        this.operatorUserID = operatorUserID;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }
}
