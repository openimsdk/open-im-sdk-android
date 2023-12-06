package io.openim.android.sdk.listener;


public interface OnPutFileListener    {
    /**
     *  上传完成 - onSuccess
     * @param size
     * @param url
     * @param type
     */
    default void  complete(long size, String url, long type){}

    default void  hashPartComplete(String var1, String var2){}

    default void  hashPartProgress(long var1, long var3, String var5){}

    default void  open(long var1){}

    default void  partSize(long var1, long var3){}

    /**
     *  上传进度
     */
    default void  uploadComplete(long size, long progress, long l2){}

    default void  uploadID(String var1){}

    default void  uploadPartComplete(long var1, long var3, String var5){}
}
