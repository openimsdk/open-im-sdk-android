package io.openim.android.sdk.listener;

/**
 * api接口回调
 */
public interface OnBase<T> {
    /**
     * 失败
     */
    default  void onError(int code, String error){}

    /**
     * 成功
     */
    default void onSuccess(T data){}
}
