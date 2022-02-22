package io.openim.android.sdk.utils;

public class ParamsUtil {
    public static String buildOperationID() {
        return String.valueOf(System.currentTimeMillis());
    }
}
