package io.openim.android.sdk.models;

public class PictureElem {
    private String sourcePath;
    private Info sourcePicture;
    private Info bigPicture;
    private Info snapshotPicture;


    public static class Info {
        private String uuID;
        private String type;
        private long size;
        private int width;
        private int height;
        private String url;

        public String getUuID() {
            return uuID;
        }

        public void setUuID(String uuID) {
            this.uuID = uuID;
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

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public Info getSourcePicture() {
        return sourcePicture;
    }

    public void setSourcePicture(Info sourcePicture) {
        this.sourcePicture = sourcePicture;
    }

    public Info getBigPicture() {
        return bigPicture;
    }

    public void setBigPicture(Info bigPicture) {
        this.bigPicture = bigPicture;
    }

    public Info getSnapshotPicture() {
        return snapshotPicture;
    }

    public void setSnapshotPicture(Info snapshotPicture) {
        this.snapshotPicture = snapshotPicture;
    }
}
