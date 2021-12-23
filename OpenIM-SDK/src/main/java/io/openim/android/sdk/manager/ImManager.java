//package io.openim.android.sdk.manager;
//
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import io.openim.android.sdk.listener.BaseImpl;
//import io.openim.android.sdk.listener.InitSDKListener;
//import io.openim.android.sdk.listener.OnBase;
//import io.openim.android.sdk.models.UserInfo;
//import io.openim.android.sdk.utils.CommonUtil;
//import io.openim.android.sdk.utils.JsonUtil;
//import open_im_sdk.Open_im_sdk;
//
//public class ImManager {
//    public ConversationManager conversationManager;
//    public FriendshipManager friendshipManager;
//    public GroupManager groupManager;
//    public MessageManager messageManager;
//    private String uid;
//
//    public ImManager() {
//        conversationManager = new ConversationManager();
//        friendshipManager = new FriendshipManager();
//        groupManager = new GroupManager();
//        messageManager = new MessageManager();
//    }
//
//    /**
//     * 初始化
//     *
//     * @param platform {@link io.openim.android.sdk.enums.Platform}
//     * @param ipApi    SDK的api地。如http:xxx:10000
//     * @param ipWs     SDK的web socket地址。如： ws:xxx:17778
//     * @param dbPath   数据存储路径
//     * @param listener 初始化监听 {@link InitSDKListener}
//     *                 正在连接到服务器：onConnecting
//     *                 连接服务器失败：onConnectFailed
//     *                 已经成功连接到服务器：onConnectSuccess
//     *                 当前用户被踢下线：onKickedOffline
//     *                 登录票据已经过期：onUserTokenExpired
//     *                 当前用户的资料发生了更新：onSelfInfoUpdated
//     */
//    public void initSDK(int platform, String ipApi, String ipWs, String dbPath, InitSDKListener listener) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("platform", platform);
//        map.put("ipApi", ipApi);
//        map.put("ipWs", ipWs);
//        map.put("dbDir", dbPath);
//        Open_im_sdk.initSDK(JsonUtil.toString(map), new open_im_sdk.IMSDKListener() {
//            @Override
//            public void onConnectFailed(long l, String s) {
//                if (null != listener) {
//                    CommonUtil.runMainThread(() -> listener.onConnectFailed(l, s));
//                }
//            }
//
//            @Override
//            public void onConnectSuccess() {
//                if (null != listener) {
//                    CommonUtil.runMainThread(listener::onConnectSuccess);
//                }
//            }
//
//            @Override
//            public void onConnecting() {
//                if (null != listener) {
//                    CommonUtil.runMainThread(listener::onConnecting);
//                }
//            }
//
//            @Override
//            public void onKickedOffline() {
//                if (null != listener) {
//                    CommonUtil.runMainThread(listener::onKickedOffline);
//                }
//            }
//
//            @Override
//            public void onSelfInfoUpdated(String s) {
//                if (null != listener) {
//                    CommonUtil.runMainThread(() -> listener.onSelfInfoUpdated(JsonUtil.toObj(s, UserInfo.class)));
//                }
//            }
//
//            @Override
//            public void onUserTokenExpired() {
//                if (null != listener) {
//                    CommonUtil.runMainThread(listener::onUserTokenExpired);
//                }
//            }
//        });
//
//    }
//
//    /**
//     * 取消初始化
//     * <p>
//     * 一般用于在初始化后需要重新初始化
//     */
//    public void unInitSDK() {
//        Open_im_sdk.unInitSDK();
//    }
//
//    /**
//     * 登录
//     *
//     * @param uid   用户ID
//     *              uid来自于自身业务服务器
//     * @param token 用户token
//     *              token需要业务服务器根据secret向OpenIM服务端交换获取。
//     * @param base  callback String
//     */
//    public void login(OnBase<String> base, String uid, String token) {
//        Open_im_sdk.login(this.uid = uid, token, BaseImpl.stringBase(base));
//    }
//
//    /**
//     * 登出
//     *
//     * @param base callback String
//     */
//    public void logout(OnBase<String> base) {
//        Open_im_sdk.logout(BaseImpl.stringBase(base));
//    }
//
//    /**
//     * 获取登录状态
//     *
//     * @return 1:success
//     */
//    public long getLoginStatus() {
//        return Open_im_sdk.getLoginStatus();
//    }
//
//    /**
//     * 获取登录用户uid
//     */
//    public String getLoginUid() {
//        return uid;
//    }
//
//    /**
//     * 根据uid批量查询用户信息
//     *
//     * @param uidList 用户id列表
//     * @param base    List<{@link UserInfo}>
//     */
//    public void getUsersInfo(OnBase<List<UserInfo>> base, List<String> uidList) {
//        Open_im_sdk.getUsersInfo(JsonUtil.toString(uidList), BaseImpl.arrayBase(base, UserInfo.class));
//    }
//
//    /**
//     * 修改当前登录用户信息
//     * <p>
//     * 非null,则修改
//     *
//     * @param name   名称
//     * @param icon   头像
//     * @param gender 性别 1：男，2：女
//     * @param mobile 手机号
//     * @param birth  出生日期
//     * @param email  邮箱
//     * @param base   callback String
//     */
//    public void setSelfInfo(OnBase<String> base, String name, String icon, int gender, String mobile, String birth, String email) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", name);
//        map.put("icon", icon);
//        map.put("gender", gender);
//        map.put("mobile", mobile);
//        map.put("birth", birth);
//        map.put("email", email);
//        Open_im_sdk.setSelfInfo(JsonUtil.toString(map), BaseImpl.stringBase(base));
//    }
//
//    public void enabledSDKLog(boolean enabled) {
//        Open_im_sdk.setSdkLog(enabled ? 0 : 1);
//    }
//
//    public void forceSyncLoginUerInfo() {
//        Open_im_sdk.forceSyncLoginUerInfo();
//    }
//
////    public void forceReConn() {
////        Open_im_sdk.forceReConn();
////    }
//}
