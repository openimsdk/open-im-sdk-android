package io.openim.android.sdk.models;

public class PictureElem {
    private String sourcePath;
    private PictureInfo sourcePicture;
    private PictureInfo bigPicture;
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
