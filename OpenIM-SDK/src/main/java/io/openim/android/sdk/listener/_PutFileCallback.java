package io.openim.android.sdk.listener;


import open_im_sdk_callback.UploadFileCallback;

public class _PutFileCallback extends BaseListener<OnPutFileListener> implements UploadFileCallback {

    public _PutFileCallback(OnPutFileListener listener) {
        super(listener);
    }


    @Override
    public void complete(long l, String s, long l1) {
        post(() -> listener.complete(l, s, l1));
    }

    @Override
    public void hashPartComplete(String s, String s1) {
        post(() -> listener.hashPartComplete(s, s1));
    }

    @Override
    public void hashPartProgress(long l, long l1, String s) {
        post(() -> listener.hashPartProgress(l, l1, s));
    }

    @Override
    public void open(long l) {
        post(() -> listener.open(l));
    }

    @Override
    public void partSize(long l, long l1) {
        post(() -> listener.partSize(l, l1));
    }


    @Override
    public void uploadComplete(long l, long l1, long l2) {
        post(() -> listener.uploadComplete(l, l1, l2));
    }

    @Override
    public void uploadID(String s) {
        post(() -> listener.uploadID(s));
    }

    @Override
    public void uploadPartComplete(long l, long l1, String s) {
        post(() -> listener.uploadPartComplete(l, l1, s));
    }
}
