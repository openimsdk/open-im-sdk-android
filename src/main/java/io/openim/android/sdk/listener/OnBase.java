package io.openim.android.sdk.listener;

public interface OnBase<T> {
    void onError(long code, String error);

    void onSuccess(T data);
}
