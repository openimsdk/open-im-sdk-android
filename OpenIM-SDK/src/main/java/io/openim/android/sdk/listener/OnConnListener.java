package io.openim.android.sdk.listener;

import io.openim.android.sdk.models.UserInfo;

/**
 * 只有在调用sdk的login方法后才开始回调
 */
public interface OnConnListener {

    /**
     * 连接服务器失败
     * 可以提示用户当前网络连接不可用
     */
    default void onConnectFailed(long code, String error){}

    /**
     * 已经成功连接到服务器
     */
    default void onConnectSuccess(){}

    /**
     * 正在连接到服务器
     * 适合在 UI 上展示“正在连接”状态。
     */
    default void onConnecting(){}

    /**
     * 当前用户被踢下线
     * 此时可以 UI 提示用户“您已经在其他端登录了当前账号，是否重新登录？”
     */
    default void onKickedOffline(){}

    /**
     * 登录票据已经过期
     * 请使用新签发的 UserSig 进行登录。
     */
    default void onUserTokenExpired(){}

    /**
     * 登录票据无效
     * 请使用新签发的 UserSig 进行登录。
     */
    default void onUserTokenInvalid(String s){}
}
