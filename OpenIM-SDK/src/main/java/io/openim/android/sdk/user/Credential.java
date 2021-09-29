package io.openim.android.sdk.user;

import androidx.annotation.NonNull;

import io.openim.android.sdk.util.Predicates;
import io.openim.android.sdk.util.StringUtils;

/**
 * IM user credential
 * <p/>
 * Created by alvince on 2021/9/25
 *
 * @author alvince.zy@gmail.com
 */
public final class Credential {

    private final String uid;
    private final String token;

    public Credential(@NonNull String uid, @NonNull String token) {
        this.uid = Predicates.requireNonNull(uid);
        this.token = Predicates.requireNonNull(token);
    }

    @NonNull
    public String getUid() {
        return StringUtils.orEmpty(uid);
    }

    @NonNull
    public String getToken() {
        return StringUtils.orEmpty(token);
    }
}
