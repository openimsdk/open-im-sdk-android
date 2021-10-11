package io.openim.android.sdk.util;

import java.util.List;

import io.openim.android.sdk.internal.schedule.Schedulers;
import io.openim.android.sdk.listener.OnBase;

public class CommonUtil {

    /**
     * Run task on Android main thread
     *
     * @deprecated instead of {@link Schedulers#runOnMainThread(Runnable)}
     */
    @Deprecated
    public static void runMainThread(Runnable runnable) {
        if (Predicates.isNull(runnable)) {
            return;
        }
        Schedulers.runOnMainThread(runnable);
    }

    public static <T> void returnError(OnBase<T> onBase, long code, String error) {
        if (onBase != null) {
            Schedulers.runOnMainThread(() -> onBase.onError(code, error));
        }
    }

    public static void returnSuccess(OnBase<String> onBase, String s) {
        if (onBase != null) {
            Schedulers.runOnMainThread(() -> onBase.onSuccess(s));
        }
    }

    public static <T> void returnObject(OnBase<T> onBase, Class<T> clazz, String s) {
        if (onBase != null) {
            Schedulers.runOnMainThread(() -> onBase.onSuccess(JsonUtil.toObj(s, clazz)));
        }
    }

    public static <T> void returnList(OnBase<List<T>> onBase, Class<T> clazz, String s) {
        if (onBase != null) {
            Schedulers.runOnMainThread(() -> onBase.onSuccess(JsonUtil.toArray(s, clazz)));
        }
    }
}
