package io.openim.android.sdk.internal.log;

import android.text.TextUtils;
import android.util.Log;

import io.openim.android.sdk.BuildConfig;

/**
 * Created by alvince on 2021/9/24
 *
 * @author alvince.zy@gmail.com
 */
public final class LogcatHelper {

    private static final String TAG = "OpenIM-SDK";

    public static void logDInDebug(String message) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        if (BuildConfig.DEBUG) {
            Log.d(TAG, message);
        }
    }
}
