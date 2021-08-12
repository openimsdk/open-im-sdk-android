package io.openim.android.sdk.listener;

import io.openim.android.sdk.models.UserInfo;

public interface InitSDKListener {

    void onConnectFailed(long code, String error);


    void onConnectSuccess();


    void onConnecting();


    void onKickedOffline();


    void onSelfInfoUpdated(UserInfo info);


    void onUserTokenExpired();
}
