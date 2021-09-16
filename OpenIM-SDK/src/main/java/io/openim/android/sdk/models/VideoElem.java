package io.openim.android.sdk.models;

public class VideoElem {
    /**
     * 视频本地资源地址
     */
    private String videoPath;
    /**
     * 视频唯一ID
     */
    private String videoUUID;
    /**
     * 视频oss地址
     */
    private String videoUrl;
    /**
     * 视频类型
     */
    private String videoType;
    /**
     * 视频大小
     */
    private long videoSize;
    /**
     * 视频时长
     */
    private long duration;
    /**
     * 视频快照本地地址
     */
    private String snapshotPath;
    /**
     * 视频快照唯一ID
     */
    private String snapshotUUID;
    /**
     * 视频快照大小
     */
    private long snapshotSize;
    /**
     * 视频快照oss地址
     */
    private String snapshotUrl;
    /**
     * 视频快照宽度
     */
    private int snapshotWidth;
    /**
     * 视频快照高度
     */
    private int snapshotHeight;

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getVideoUUID() {
        return videoUUID;
    }

    public void setVideoUUID(String videoUUID) {
        this.videoUUID = videoUUID;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public long getVideoSize() {
        return videoSize;
    }

    public void setVideoSize(long videoSize) {
        this.videoSize = videoSize;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getSnapshotPath() {
        return snapshotPath;
    }

    public void setSnapshotPath(String snapshotPath) {
        this.snapshotPath = snapshotPath;
    }

    public String getSnapshotUUID() {
        return snapshotUUID;
    }

    public void setSnapshotUUID(String snapshotUUID) {
        this.snapshotUUID = snapshotUUID;
    }

    public long getSnapshotSize() {
        return snapshotSize;
    }

    public void setSnapshotSize(long snapshotSize) {
        this.snapshotSize = snapshotSize;
    }

    public String getSnapshotUrl() {
        return snapshotUrl;
    }

    public void setSnapshotUrl(String snapshotUrl) {
        this.snapshotUrl = snapshotUrl;
    }

    public int getSnapshotWidth() {
        return snapshotWidth;
    }

    public void setSnapshotWidth(int snapshotWidth) {
        this.snapshotWidth = snapshotWidth;
    }

    public int getSnapshotHeight() {
        return snapshotHeight;
    }

    public void setSnapshotHeight(int snapshotHeight) {
        this.snapshotHeight = snapshotHeight;
    }
}
