package io.openim.android.sdk.models;

public class UserInfoReq {
    /**
     * 用户id
     */
    private String userID;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 用户头像
     */
    private String faceURL;
    /**
     * 扩展参数
     */
    private String ex;
    /**
     * 全局免打扰，1:屏蔽消息; 2:接收消息但不提示; 0:正常
     */
    private Integer globalRecvMsgOpt;

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

    public Integer getGlobalRecvMsgOpt() {
        return globalRecvMsgOpt;
    }

    public void setGlobalRecvMsgOpt(Integer globalRecvMsgOpt) {
        this.globalRecvMsgOpt = globalRecvMsgOpt;
    }
}
