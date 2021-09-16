package io.openim.android.sdk.listener;

/**
 * api接口回调
 */
public interface OnBase<T> {
    /**
     * 失败
     */
    void onError(long code, String error);

    /**
     * 成功
     */
    void onSuccess(T data);
}
