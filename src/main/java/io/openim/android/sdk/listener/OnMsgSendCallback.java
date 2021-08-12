package io.openim.android.sdk.listener;

public interface OnMsgSendCallback extends OnBase<String> {
    void onError(long code, String error);

    void onProgress(long progress);

    void onSuccess(String s);
}
