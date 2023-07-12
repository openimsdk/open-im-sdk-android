package io.openim.android.sdk.listener;


import open_im_sdk_callback.UploadFileCallback;

public class _PutFileCallback extends BaseListener<OnPutFileListener> implements UploadFileCallback {

    public _PutFileCallback(OnPutFileListener listener) {
        super(listener);
    }


    @Override
    public void complete(long l, String s, int i) {
        post(() -> listener.complete(l,s,i));
    }

    @Override
    public void hashPartComplete(String s, String s1) {
        post(() -> listener.hashPartComplete(s,s1));
    }

    @Override
    public void hashPartProgress(int i, long l, String s) {
        post(() -> listener.hashPartProgress(i,l,s));
    }

    @Override
    public void open(long l) {
        post(() -> listener.open(l));
    }

    @Override
    public void partSize(long l, int i) {
        post(() -> listener.partSize(l));
    }

    @Override
    public void uploadComplete(long l, long l1, long l2) {
        post(() -> listener.unloadProgress(l, l1, l2));
    }

    @Override
    public void uploadID(String s) {
        post(() -> listener.uploadID(s));
    }

    @Override
    public void uploadPartComplete(int i, long l, String s) {
        post(() -> listener.uploadPartComplete(i, l, s));
    }
}
