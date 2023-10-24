package io.openim.android.sdk.models;

import java.io.Serializable;
import java.util.List;

public class GroupHasReadInfo implements Serializable {

    /**
     * 已读数
     */
    private int hasReadCount;
    /**
     * 未读数
     */
    private int unreadCount;


    public int getHasReadCount() {
        return hasReadCount;
    }

    public void setHasReadCount(int hasReadCount) {
        this.hasReadCount = hasReadCount;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }
}
