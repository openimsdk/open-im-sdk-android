package io.openim.android.sdk.models;

/**
 * apiUrl              SDK的API接口地址。如：http:xxx:10000
 * wsUrl               SDK的web socket地址。如： ws:xxx:17778
 * storageDir          数据存储目录路径
 * logLevel            日志等级，如：6
 * isLogStandardOutput 控制台是否输出日志
 * logFilePath         日志输出的路径
 */
public class InitConfig {
    public InitConfig(String apiUrl, String wsUrl, String storageDir) {
        this.apiAddr = apiUrl;
        this.wsAddr = wsUrl;
        this.dataDir = storageDir;
    }

    public final int platformID = 2;
    public String apiAddr;
    public String wsAddr;
    public String dataDir;
    public int logLevel = 6;
    public boolean isLogStandardOutput;
    public String logFilePath;
}
