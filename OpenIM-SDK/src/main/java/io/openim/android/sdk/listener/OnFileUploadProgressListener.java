package io.openim.android.sdk.listener;


/**
 * 消息发送监听
 */
public interface OnFileUploadProgressListener extends OnBase<String> {
    /**
     * 上传失败
     */
    void onError(int code, String error);

    /**
     * 上传进度
     */
    void onProgress(long progress);

    /**
     * 上传成功
     */
    void onSuccess(String s);
}
