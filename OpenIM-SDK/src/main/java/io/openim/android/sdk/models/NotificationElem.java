package io.openim.android.sdk.models;

public class NotificationElem {
    /**
     * 通知内容详情
     */
    private String detail;
    /**
     * 默认提示内容
     */
    private String defaultTips;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDefaultTips() {
        return defaultTips;
    }

    public void setDefaultTips(String defaultTips) {
        this.defaultTips = defaultTips;
    }
}
