package io.openim.android.sdk.models;

public class UserInfo {
    /**
     * 用户id
     */
    private String userID;
    /**
     * 用户名
     */
    private String nickname;
    /**
     * 用户头像
     */
    private String faceURL;
    /**
     * 性别：1男，2女
     */
    private int gender;
    /**
     * 手机号
     */
    private String phoneNumber;
    /**
     * 生日
     */
    private long birth;
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
    private String remark;
    /**
     * 公开的信息
     */
    private PublicUserInfo publicInfo;
    /**
     * 仅好友可见的信息
     */
    private FriendInfo friendInfo;
    /**
     * 黑名单信息
     */
    private BlacklistInfo blackInfo;

    /**
     * 全局免打扰
     */
    private int globalRecvMsgOpt;

    public String getUserID() {
        if (null == userID) {
            if ((isFriendship())) {
                return friendInfo.getUserID();
            } else if (isBlacklist()) {
                return blackInfo.getUserID();
            } else if (null != publicInfo) {
                return publicInfo.getUserID();
            }
        }
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getNickname() {
        if (null == nickname) {
            if ((isFriendship())) {
                return friendInfo.getNickname();
            } else if (isBlacklist()) {
                return blackInfo.getNickname();
            } else if (null != publicInfo) {
                return publicInfo.getNickname();
            }
        }
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFaceURL() {
        if (null == faceURL) {
            if ((isFriendship())) {
                return friendInfo.getFaceURL();
            } else if (isBlacklist()) {
                return blackInfo.getFaceURL();
            } else if (null != publicInfo) {
                return publicInfo.getFaceURL();
            }
        }
        return faceURL;
    }

    public void setFaceURL(String faceURL) {
        this.faceURL = faceURL;
    }

    public int getGender() {
        if ((isFriendship())) {
            return friendInfo.getGender();
        } else if (isBlacklist()) {
            return blackInfo.getGender();
        } else if (null != publicInfo) {
            return publicInfo.getGender();
        }
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        if (null == phoneNumber) {
            if ((isFriendship())) {
                return friendInfo.getPhoneNumber();
            }
        }
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getBirth() {
        if ((isFriendship())) {
            return friendInfo.getBirth();
        }
        return birth;
    }

    public void setBirth(long birth) {
        this.birth = birth;
    }

    public String getEmail() {
        if (null == email) {
            if ((isFriendship())) {
                return friendInfo.getEmail();
            }
        }
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEx() {
        if (null == ex) {
            if ((isFriendship())) {
                return friendInfo.getEx();
            } else if (isBlacklist()) {
                return blackInfo.getEx();
            }
        }
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getRemark() {
        if (null == remark) {
            if ((isFriendship())) {
                return friendInfo.getRemark();
            }
        }
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public PublicUserInfo getPublicInfo() {
        return publicInfo;
    }

    public void setPublicInfo(PublicUserInfo publicInfo) {
        this.publicInfo = publicInfo;
    }

    public FriendInfo getFriendInfo() {
        return friendInfo;
    }

    public void setFriendInfo(FriendInfo friendInfo) {
        this.friendInfo = friendInfo;
    }

    public BlacklistInfo getBlackInfo() {
        return blackInfo;
    }

    public void setBlackInfo(BlacklistInfo blackInfo) {
        this.blackInfo = blackInfo;
    }

    /**
     * true：黑名单
     */
    public boolean isBlacklist() {
        return null != blackInfo;
    }

    /**
     * true：是好友
     */
    public boolean isFriendship() {
        return null != friendInfo;
    }

    public int getGlobalRecvMsgOpt() {
        return globalRecvMsgOpt;
    }

    public void setGlobalRecvMsgOpt(int globalRecvMsgOpt) {
        this.globalRecvMsgOpt = globalRecvMsgOpt;
    }
}
