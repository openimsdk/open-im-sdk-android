package io.openim.android.sdk.models;

import java.util.List;

public class GroupMembersList {
    private int nextSeq;
    private List<GroupMembersInfo> data;

    public int getNextSeq() {
        return nextSeq;
    }

    public void setNextSeq(int nextSeq) {
        this.nextSeq = nextSeq;
    }

    public List<GroupMembersInfo> getData() {
        return data;
    }

    public void setData(List<GroupMembersInfo> data) {
        this.data = data;
    }
}
