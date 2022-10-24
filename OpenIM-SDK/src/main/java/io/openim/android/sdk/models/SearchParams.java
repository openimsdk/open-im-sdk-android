package io.openim.android.sdk.models;

import java.util.List;

public class SearchParams {
    private String conversationID;
    private List<String> clientMsgIDList;

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }

    public List<String> getClientMsgIDList() {
        return clientMsgIDList;
    }

    public void setClientMsgIDList(List<String> clientMsgIDList) {
        this.clientMsgIDList = clientMsgIDList;
    }
}
