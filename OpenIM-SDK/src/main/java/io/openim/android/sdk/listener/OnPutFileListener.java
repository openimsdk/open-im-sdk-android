package io.openim.android.sdk.listener;


public interface OnPutFileListener    {
    /**
     *  上传完成 - onSuccess
     * @param size
     * @param url
     * @param type
     */
    void complete(long size, String url, long type);

    void hashPartComplete(String var1, String var2);

    void hashPartProgress(long var1, long var3, String var5);

    void open(long var1);

    void partSize(long var1, long var3);

    /**
     *  上传进度
     */
    void uploadComplete(long size, long progress, long l2);

    void uploadID(String var1);

    void uploadPartComplete(long var1, long var3, String var5);
}
