package io.openim.android.sdk.models;

import java.util.List;

public class MessageKv {
    private String clientMsgID;
    private List<SingleTypeKeyInfoSum> changedKvList;

    public String getClientMsgID() {
        return clientMsgID;
    }

    public void setClientMsgID(String clientMsgID) {
        this.clientMsgID = clientMsgID;
    }

    public List<SingleTypeKeyInfoSum> getChangedKvList() {
        return changedKvList;
    }

    public void setChangedKvList(List<SingleTypeKeyInfoSum> changedKvList) {
        this.changedKvList = changedKvList;
    }
}
