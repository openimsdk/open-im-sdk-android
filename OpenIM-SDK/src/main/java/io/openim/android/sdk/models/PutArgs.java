package io.openim.android.sdk.models;

public class PutArgs {
    /**
     * userId_ Random number
     */
    public String putID;
    /**
     * 本地文件路径
     */
    public String filepath;
    /**
     * 文件名
     */
    public String name;

    public PutArgs(String filepath) {
        this.filepath = filepath;
        this.name = filepath;
    }
}
