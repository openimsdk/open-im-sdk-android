package io.openim.android.sdk.models;

public class KeyValue {
    private String typeKey;
    private String value;
    private long latestUpdateTime;

    public String getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(String typeKey) {
        this.typeKey = typeKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getLatestUpdateTime() {
        return latestUpdateTime;
    }

    public void setLatestUpdateTime(long latestUpdateTime) {
        this.latestUpdateTime = latestUpdateTime;
    }
}
