package io.openim.android.sdk.models;

import java.util.List;

public class GroupApplicationList {
    private int count;
    private List<GroupApplicationInfo> user;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<GroupApplicationInfo> getUser() {
        return user;
    }

    public void setUser(List<GroupApplicationInfo> user) {
        this.user = user;
    }
}
