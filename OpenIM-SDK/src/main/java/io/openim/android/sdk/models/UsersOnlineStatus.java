package io.openim.android.sdk.models;

import java.io.Serializable;
import java.util.List;

public class UsersOnlineStatus implements Serializable {

    public  String userID;
    public  int status;
    public List<Integer> platformIDs ;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Integer> getPlatformIDs() {
        return platformIDs;
    }

    public void setPlatformIDs(List<Integer> platformIDs) {
        this.platformIDs = platformIDs;
    }


}
