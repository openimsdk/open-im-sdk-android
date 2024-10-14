package io.openim.android.sdk.models;

public class PublicUserInfo {
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
     * 扩展字段
     */
    private String ex;
    /**
     * 创建时间
     */
    private Long createTime;

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

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
