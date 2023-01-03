package io.openim.android.sdk.models;

import java.util.Map;

public class MessageTypeKeyMapping {
    private long errCode;
    private String errMsg;
    private Map<String, KeyValue> reactionExtensionList;
    private String clientMsgID;

    public long getErrCode() {
        return errCode;
    }

    public void setErrCode(long errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Map<String, KeyValue> getReactionExtensionList() {
        return reactionExtensionList;
    }

    public void setReactionExtensionList(Map<String, KeyValue> reactionExtensionList) {
        this.reactionExtensionList = reactionExtensionList;
    }

    public String getClientMsgID() {
        return clientMsgID;
    }

    public void setClientMsgID(String clientMsgID) {
        this.clientMsgID = clientMsgID;
    }
}
