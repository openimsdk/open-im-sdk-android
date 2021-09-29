//package io.openim.android.sdk.listener;
//
//import io.openim.android.sdk.models.UserInfo;
//
///**
// * IM connect change listener
// * <p/>
// * Created by alvince on 2021/9/25
// *
// * @author alvince.zy@gmail.com
// */
//public interface ConnectListener {
//
//    void onConnectFailed(long code, String error);
//
//    /**
//     * Called on connect to server succeed
//     */
//    void onConnectSuccess();
//
//    /**
//     * Called on connecting server
//     * <p/>
//     * Could show connecting… in UI
//     */
//    void onConnecting();
//
//    /**
//     * Called on user kicked offline
//     */
//    void onKickedOffline();
//
//    /**
//     * Called on user profile changed
//     */
//    void onSelfInfoUpdated(UserInfo info);
//
//    /**
//     * Called on user token expired
//     * <p/>
//     * Login via the newly `UserSig`
//     */
//    void onUserTokenExpired();
//}
