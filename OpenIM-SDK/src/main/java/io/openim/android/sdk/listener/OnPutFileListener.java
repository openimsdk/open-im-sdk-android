package io.openim.android.sdk.listener;


public interface OnPutFileListener    {
    /**
     *  上传完成 - onSuccess
     * @param size
     * @param url
     * @param type
     */
     void complete(long size, String url, int type);

    /**
     *  hash 计算进度
     */
    void hashPartComplete(String s, String s1);

    void hashPartProgress(int index, long size, String s);

    void open(long size);

    void partSize(long l);
    /**
     *  上传进度
     */
    void unloadProgress(long size, long progress, long l2);

    void uploadID(String s);

    void uploadPartComplete(int i, long l, String s);
}
