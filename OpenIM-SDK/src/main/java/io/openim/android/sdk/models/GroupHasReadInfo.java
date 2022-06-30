package io.openim.android.sdk.models;

import java.util.List;

public class GroupHasReadInfo {
    /**
     * 已读的用户id列表
     */
    private List<String> hasReadUserIDList;
    /**
     * 已读总数
     */
    private int hasReadCount;
    /**
     * 发送此条消息时的群人数
     */
    private int groupMemberCount;

    public List<String> getHasReadUserIDList() {
        return hasReadUserIDList;
    }

    public void setHasReadUserIDList(List<String> hasReadUserIDList) {
        this.hasReadUserIDList = hasReadUserIDList;
    }

    public int getHasReadCount() {
        return hasReadCount;
    }

    public void setHasReadCount(int hasReadCount) {
        this.hasReadCount = hasReadCount;
    }

    public int getGroupMemberCount() {
        return groupMemberCount;
    }

    public void setGroupMemberCount(int groupMemberCount) {
        this.groupMemberCount = groupMemberCount;
    }
}
