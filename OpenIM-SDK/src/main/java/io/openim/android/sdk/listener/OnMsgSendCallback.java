package io.openim.android.sdk.listener;


/**
 * 消息发送监听
 */
public interface OnMsgSendCallback extends OnBase<String> {
    /**
     * 发送失败
     */
    void onError(long code, String error);

    /**
     * 上传进度
     */
    void onProgress(long progress);

    /**
     * 发送成功
     */
    void onSuccess(String s);
}
