package io.openim.android.sdk.models;


import org.jetbrains.annotations.NotNull;

import io.openim.android.sdk.utils.JsonUtil;

public class BaseEntity {
    @NotNull
    @Override
    public String toString() {
        return JsonUtil.toString(this);
    }
}
