package io.openim.android.sdk.models;
import java.util.List;

public class InputStatesChangedData {
    private String conversationID;
    private List<Long> platformIDs;
    private String userID;

    public String getConversationID() { return conversationID; }
    public void setConversationID(String value) { this.conversationID = value; }

    public List<Long> getPlatformIDs() { return platformIDs; }
    public void setPlatformIDs(List<Long> value) { this.platformIDs = value; }

    public String getUserID() { return userID; }
    public void setUserID(String value) { this.userID = value; }
}
