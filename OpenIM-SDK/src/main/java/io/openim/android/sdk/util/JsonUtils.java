package io.openim.android.sdk.util;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Simple utils for {@link org.json.JSONObject}
 * <p/>
 * Created by alvince on 2021/9/24
 *
 * @author alvince.zy@gmail.com
 */
public final class JsonUtils {

    private static final String EMPTY = "{}";

    @NonNull
    public static String toString(@Nullable Map<String, ?> map) {
        if (Predicates.isNull(map) || map.isEmpty()) {
            return EMPTY;
        }
        JSONObject json = JsonUtils.toJson(map);
        if (Predicates.isNull(json)) {
            return EMPTY;
        }
        return json.toString();
    }

    @Nullable
    public static JSONObject toJson(@NonNull Map<?, ?> map) {
        Predicates.requireNonNull(map);

        if (map.isEmpty()) {
            return null;
        }

        JSONObject bearer = new JSONObject();
        for (Map.Entry<?, ?> entry : Predicates.requireNonNull(map).entrySet()) {
            Object k = entry.getKey();
            if (Predicates.isNull(k)) {
                continue;
            }
            String key = StringUtils.asString(k);
            if (TextUtils.isEmpty(key)) {
                continue;
            }
            Object value = entry.getValue();
            if (Predicates.isNull(value)) {
                continue;
            }
            try {
                if (value instanceof Map) {
                    JSONObject element = JsonUtils.toJson((Map) value);
                    if (Predicates.nonNull(element)) {
                        bearer.putOpt(key, element);
                    }
                    continue;
                }
                bearer.putOpt(key, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bearer;
    }
}
