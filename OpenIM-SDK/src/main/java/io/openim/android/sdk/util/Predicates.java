package io.openim.android.sdk.util;

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

    /**
     * Throws an {@link IllegalArgumentException} if the value is null. Otherwise returns the not null value.
     */
    @NonNull
    public static <T> T requireNonNull(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        return value;
    }

    /**
     * Throws an {@link IllegalStateException} if the value is null. Otherwise returns the not null value.
     */
    @NonNull
    public static <T> T checkNotNull(T value) {
        if (value == null) {
            throw new IllegalStateException("Required value was null.");
        }
        return value;
    }

    public static <T> T checkParamValue(String name, T value) {
        if (value == null) {
            throw new IllegalArgumentException("The value of the parameter " + name + " cannot be null.");
        }
        return value;
    }
}
