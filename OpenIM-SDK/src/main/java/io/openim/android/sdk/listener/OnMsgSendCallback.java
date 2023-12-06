package io.openim.android.sdk.listener;


import io.openim.android.sdk.models.Message;

/**
 * 消息发送监听
 */
public interface OnMsgSendCallback extends OnBase<Message> {
    /**
     * 发送失败
     */
  default   void onError(int code, String error){}

    /**
     * 上传进度
     */
    default  void onProgress(long progress){}

    /**
     * 发送成功
     */
    default void onSuccess(Message s){}
}
