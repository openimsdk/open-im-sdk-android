package io.openim.android.sdk.models;

public class UpdateFriendsReq {
    /**
     * 操作者Uid
     */
    private String ownerUserID;
    /**
     * 待更新的用户id
     */
    private String[] friendUserIDs;
    /**
     * 是否置顶
     */
    private Boolean isPinned;
    /**
     * 备注名
     */
    private String remark;
    /**
     * 扩展参数
     */
    private String ex;


    public String getOwnerUserID() {
        return ownerUserID;
    }

    protected void setOwnerUserID(String ownerUserID) {
        this.ownerUserID = ownerUserID;
    }

    public String[] getFriendUserIDs() {
        return friendUserIDs;
    }

    public void setFriendUserIDs(String[] friendUserIDs) {
        this.friendUserIDs = friendUserIDs;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public Boolean getPinned() {
        return isPinned;
    }

    public void setPinned(boolean pinned) {
        isPinned = pinned;
    }
}
