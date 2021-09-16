package io.openim.android.sdk.models;

public class SoundElem {
    /**
     * 唯一ID
     */
    private String uuID;
    /**
     * 本地资源地址
     */
    private String soundPath;
    /**
     * oss地址
     */
    private String sourceUrl;
    /**
     * 音频大小
     */
    private long dataSize;
    /**
     * 音频时长
     */
    private long duration;

    public String getUuID() {
        return uuID;
    }

    public void setUuID(String uuID) {
        this.uuID = uuID;
    }

    public String getSoundPath() {
        return soundPath;
    }

    public void setSoundPath(String soundPath) {
        this.soundPath = soundPath;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public long getDataSize() {
        return dataSize;
    }

    public void setDataSize(long dataSize) {
        this.dataSize = dataSize;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
