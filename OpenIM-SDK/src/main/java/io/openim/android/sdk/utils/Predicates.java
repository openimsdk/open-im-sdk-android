package io.openim.android.sdk.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by alvince on 2021/9/24
 *
 * @author alvince.zy@gmail.com
 */
public final class Predicates {

    public static boolean isNull(@Nullable Object obj) {
        return obj == null;
    }

    public static boolean nonNull(Object obj) {
        return obj != null;
    }

    @NonNull
    public static <T> T requireNonNull(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        return obj;
    }

    public static <T> T checkParamValue(String name, T value) {
        if (value == null) {
            throw new IllegalArgumentException("The value of the parameter " + name + " cannot be null.");
        }
        return value;
    }
}
