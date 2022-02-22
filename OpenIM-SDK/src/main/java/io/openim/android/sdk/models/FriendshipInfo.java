package io.openim.android.sdk.models;

public class FriendshipInfo {
    private String userID;

    /// 1 means friend (and not blacklist)
    /// 1表示好友（并且不是黑名单）
    private int result;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
