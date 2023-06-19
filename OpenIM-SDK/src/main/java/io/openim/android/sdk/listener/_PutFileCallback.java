package io.openim.android.sdk.listener;


import org.jetbrains.annotations.NotNull;

import open_im_sdk_callback.PutFileCallback;

public class _PutFileCallback extends BaseListener<OnPutFileListener> implements PutFileCallback {

    public _PutFileCallback(@NotNull("OnPutFileListener can't is null") OnPutFileListener listener) {
        super(listener);
    }


    @Override
    public void hashComplete(String md5, long size) {
        post(() -> listener.hashComplete(md5, size));
    }


    @Override
    public void hashProgress(long l, long l1) {
        post(() -> listener.hashProgress(l, l1));
    }

    /**
     *
     * @param l
     */
    @Override
    public void open(long l) {
        post(() -> listener.open(l));
    }

    /**
     *  上传完成
     * @param l  总大小
     * @param l1  类型
     */
    @Override
    public void putComplete(long l, long l1) {
        post(() -> listener.putComplete(l, l1));
    }

    /**
     *上传 中
     * @param l
     * @param l1 当前上传大小
     * @param l2  文件总大小
     */
    @Override
    public void putProgress(long l, long l1, long l2) {
        post(() -> listener.putProgress(l, l1, l2));
    }

    /**
     * 开始上传
     * @param l
     * @param l1
     */
    @Override
    public void putStart(long l, long l1) {
        post(() -> listener.putStart(l, l1));
    }
}
