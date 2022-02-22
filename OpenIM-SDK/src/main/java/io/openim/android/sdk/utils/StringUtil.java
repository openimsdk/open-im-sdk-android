package io.openim.android.sdk.utils;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by alvince on 2021/9/24
 *
 * @author alvince.zy@gmail.com
 */
public final class StringUtil {

    @NonNull
    public static String asString(@NonNull Object obj) {
        Predicates.requireNonNull(obj);

        if (obj instanceof String) {
            return (String) obj;
        }
        return obj.toString();
    }

    @NonNull
    public static String orEmpty(@Nullable String text) {
        if (TextUtils.isEmpty(text)) {
            return "";
        }
        return Predicates.requireNonNull(text);
    }

    @NonNull
    public static String orDefault(@Nullable String text, @NonNull String defaultVal) {
        if (TextUtils.isEmpty(text)) {
            return defaultVal;
        }
        return Predicates.requireNonNull(text);
    }
}
