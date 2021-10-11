package io.openim.android.sdk.listener;

import io.openim.android.sdk.models.UserInfo;

/**
 * Created by alvince on 2021/9/29
 *
 * @author alvince.zy@gmail.com
 */
public interface UserStateChangedListener {
    /**
     * Called on user profile changed
     */
    void onSelfProfileUpdated(UserInfo info);

    /**
     * Called on user token expired
     * <p/>
     * Login via the newly `UserSig`
     */
    void onUserTokenExpired();
}
