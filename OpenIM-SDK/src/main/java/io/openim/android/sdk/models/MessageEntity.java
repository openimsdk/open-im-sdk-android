package io.openim.android.sdk.models;

public class MessageEntity {
    private String type;
    private int offset;
    private int length;
    private String url;
    private String ex;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }
}
