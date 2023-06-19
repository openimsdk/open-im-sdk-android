package io.openim.android.sdk.listener;


public interface OnPutFileListener    {
    /**
     *  hash 完成
     * @param hash md5值
     * @param total  文件大小
     */
    void hashComplete(String hash, long total);

    /**
     *  hash 计算进度
     * @param current 当前进度
     * @param total 总大小
     */
    void hashProgress(long current, long total);

    void open(long size);

    /**
     *  上传完成
     * @param total  总大小
     * @param putType  类型
     */
    void putComplete(long total, long putType);

    /**
     *上传 中
     * @param save
     * @param current 当前上传大小
     * @param total  文件总大小
     */
    void putProgress(long save, long current, long total);

    /**
     * 开始上传
     * @param current 当前上传大小
     * @param total 文件总大小
     */
    void putStart(long current, long total);
}
