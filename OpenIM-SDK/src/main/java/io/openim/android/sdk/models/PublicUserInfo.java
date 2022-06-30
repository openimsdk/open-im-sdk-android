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
     * 性别
     */
    private int gender;
    /**
     *
     */
    private int appMangerLevel;
    /**
     * 扩展字段
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

    public int getAppMangerLevel() {
        return appMangerLevel;
    }

    public void setAppMangerLevel(int appMangerLevel) {
        this.appMangerLevel = appMangerLevel;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }
}
