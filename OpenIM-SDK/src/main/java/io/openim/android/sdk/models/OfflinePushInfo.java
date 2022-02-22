package io.openim.android.sdk.models;

public class OfflinePushInfo {
    private String title;
    private String desc;
    private String ex;
    private String iOSPushSound;
    private boolean iOSBadgeCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getiOSPushSound() {
        return iOSPushSound;
    }

    public void setiOSPushSound(String iOSPushSound) {
        this.iOSPushSound = iOSPushSound;
    }

    public boolean isiOSBadgeCount() {
        return iOSBadgeCount;
    }

    public void setiOSBadgeCount(boolean iOSBadgeCount) {
        this.iOSBadgeCount = iOSBadgeCount;
    }
}
