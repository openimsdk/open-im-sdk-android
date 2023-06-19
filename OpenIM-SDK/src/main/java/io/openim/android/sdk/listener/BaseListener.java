package io.openim.android.sdk.listener;




import org.jetbrains.annotations.NotNull;

import io.openim.android.sdk.utils.CommonUtil;

public class BaseListener<T> {
    protected T listener;

    public BaseListener(@NotNull T listener) {
        this.listener = listener;
    }

    protected void post(Runnable runnable) {
        CommonUtil.runMainThread(runnable);
    }
}
