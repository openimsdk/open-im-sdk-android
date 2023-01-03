package io.openim.android.sdk.models;

import java.util.List;

public class SingleTypeKeyInfoSum {
    private String typeKey;
    private int counter;
    private List<UserExInfo> infoList;
    private boolean isContainSelf;

    public String getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(String typeKey) {
        this.typeKey = typeKey;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public List<UserExInfo> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<UserExInfo> infoList) {
        this.infoList = infoList;
    }

    public boolean isContainSelf() {
        return isContainSelf;
    }

    public void setContainSelf(boolean containSelf) {
        isContainSelf = containSelf;
    }
}
