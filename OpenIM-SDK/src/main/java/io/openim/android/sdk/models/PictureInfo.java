package io.openim.android.sdk.models;

public class PictureInfo {
    /**
     * 唯一ID
     */
    private String uuid;
    /**
     * 图片类型
     */
    private String type;
    /**
     * 图片大小
     */
    private long size;
    /**
     * 图片宽度
     */
    private int width;
    /**
     * 图片高度
     */
    private int height;
    /**
     * 图片oss地址
     */
    private String url;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
