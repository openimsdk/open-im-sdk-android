package io.openim.android.sdk.utils;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;

import java.util.Collections;
import java.util.Map;

/**
 * Created by alvince on 2021/9/24
 *
 * @author alvince.zy@gmail.com
 */
public final class CollectionUtil {

    @NonNull
    public static Map<String, Object> simpleMapOf(Object... kvPairs) {
        int len = kvPairs.length;
        if (len < 2) {
            return Collections.emptyMap();
        }
        int size = (len & 1) == 1 ? (len - 1) : len;
        Map<String, Object> result = new ArrayMap<>(size >> 1);
        Object k, v;
        for (int i = 0; i < size; i += 2) {
            k = kvPairs[i];
            v = kvPairs[i + 1];
            if (Predicates.isNull(k) || Predicates.isNull(v)) {
                continue;
            }
            result.put(StringUtil.asString(k), v);
        }
        return result;
    }
}
