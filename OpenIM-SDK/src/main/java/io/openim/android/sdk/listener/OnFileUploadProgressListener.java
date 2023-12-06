package io.openim.android.sdk.listener;


/**
 * 消息发送监听
 */
public interface OnFileUploadProgressListener extends OnBase<String> {
    /**
     * 上传失败
     */
    default void onError(int code, String error){}

    /**
     * 上传进度
     */
    default void onProgress(long progress){}

    /**
     * 上传成功
     */
    default void onSuccess(String s){}
}
