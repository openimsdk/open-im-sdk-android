package io.openim.android.sdk.models;

import androidx.annotation.NonNull;

import io.openim.android.sdk.utils.JsonUtil;

public class BaseEntity {
    @NonNull
    @Override
    public String toString() {
        return JsonUtil.toString(this);
    }
}
