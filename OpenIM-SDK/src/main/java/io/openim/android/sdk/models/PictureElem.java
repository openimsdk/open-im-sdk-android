package io.openim.android.sdk.models;

public class PictureElem {
    /**
     * 本地资源地址
     */
    private String sourcePath;
    /**
     * 本地图片详情
     */
    private PictureInfo sourcePicture;
    /**
     * 大图详情
     */
    private PictureInfo bigPicture;
    /**
     * 缩略图详情
     */
    private PictureInfo snapshotPicture;


    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public PictureInfo getSourcePicture() {
        return sourcePicture;
    }

    public void setSourcePicture(PictureInfo sourcePicture) {
        this.sourcePicture = sourcePicture;
    }

    public PictureInfo getBigPicture() {
        return bigPicture;
    }

    public void setBigPicture(PictureInfo bigPicture) {
        this.bigPicture = bigPicture;
    }

    public PictureInfo getSnapshotPicture() {
        return snapshotPicture;
    }

    public void setSnapshotPicture(PictureInfo snapshotPicture) {
        this.snapshotPicture = snapshotPicture;
    }
}
