package io.openim.android.sdk.models;

public class BlacklistInfo {
    String userID;
    String nickname;
    String faceURL;
    int gender;
    long createTime;
    int addSource;
    String operatorUserID;
    String ex;

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
