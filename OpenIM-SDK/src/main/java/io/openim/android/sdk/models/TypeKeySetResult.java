package io.openim.android.sdk.models;

public class TypeKeySetResult {
    private long errCode;
    private String errMsg;
    private String typeKey;
    private long latestUpdateTime;
    private String value;

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

    public String getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(String typeKey) {
        this.typeKey = typeKey;
    }

    public long getLatestUpdateTime() {
        return latestUpdateTime;
    }

    public void setLatestUpdateTime(long latestUpdateTime) {
        this.latestUpdateTime = latestUpdateTime;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
