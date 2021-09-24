package io.openim.android.sdk.util;

import androidx.annotation.NonNull;

/**
 * Created by alvince on 2021/9/24
 *
 * @author alvince.zy@gmail.com
 */
public final class StringUtils {

    @NonNull
    public static String asString(@NonNull Object obj) {
        Predicates.requireNonNull(obj);

        if (obj instanceof String) {
            return (String) obj;
        }
        return obj.toString();
    }
}
