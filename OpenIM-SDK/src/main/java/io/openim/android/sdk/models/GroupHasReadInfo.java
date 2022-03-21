package io.openim.android.sdk.models;

import java.util.List;

public class GroupHasReadInfo {
    private List<String> hasReadUserIDList;
    private int hasReadCount;

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
}
