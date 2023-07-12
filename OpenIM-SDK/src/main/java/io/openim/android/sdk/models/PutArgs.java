package io.openim.android.sdk.models;

import io.openim.android.sdk.utils.CommonUtil;

public class PutArgs {
    /**
     * 本地文件路径
     */
    public String filepath;
    /**
     * 文件名
     */
    public String name;

    /**
     * 类型
     */
    public String cuase;

    public PutArgs(String filepath) {
        this.filepath = filepath;
        this.name = filepath;
    }
}
