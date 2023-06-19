package io.openim.android.sdk.listener;


import org.jetbrains.annotations.NotNull;

import open_im_sdk_callback.PutFileCallback;

public class _PutFileCallback extends BaseListener<PutFileCallback> implements PutFileCallback {

    public _PutFileCallback(@NotNull PutFileCallback listener) {
        super(listener);
    }

    @Override
    public void hashComplete(String s, long l) {
        post(() -> listener.hashComplete(s, l));
    }

    @Override
    public void hashProgress(long l, long l1) {
        post(() -> listener.hashProgress(l, l1));
    }

    @Override
    public void open(long l) {
        post(() -> listener.open(l));
    }

    @Override
    public void putComplete(long l, long l1) {
        post(() -> listener.putComplete(l, l1));
    }

    @Override
    public void putProgress(long l, long l1, long l2) {
        post(() -> listener.putProgress(l, l1, l2));
    }

    @Override
    public void putStart(long l, long l1) {
        post(() -> listener.putStart(l, l1));
    }
}
