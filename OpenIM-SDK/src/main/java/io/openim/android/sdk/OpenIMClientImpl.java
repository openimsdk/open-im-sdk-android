package io.openim.android.sdk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.openim.android.sdk.internal.log.LogcatHelper;
import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.InitSDKListener;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.manager.ConversationManager;
import io.openim.android.sdk.manager.FriendshipManager;
import io.openim.android.sdk.manager.GroupManager;
import io.openim.android.sdk.manager.MessageManager;
import io.openim.android.sdk.models.UserInfo;
import io.openim.android.sdk.util.CollectionUtils;
import io.openim.android.sdk.util.CommonUtil;
import io.openim.android.sdk.util.JsonUtil;
import io.openim.android.sdk.util.Predicates;
import open_im_sdk.Open_im_sdk;

/**
 * Created by alvince on 2021/9/24
 *
 * @author alvince.zy@gmail.com
 */
class OpenIMClientImpl {
    ConversationManager conversationManager;
    FriendshipManager friendshipManager;
    GroupManager groupManager;
    MessageManager messageManager;


    OpenIMClientImpl() {
        conversationManager = new ConversationManager();
        friendshipManager = new FriendshipManager();
        groupManager = new GroupManager();
        messageManager = new MessageManager();
    }

    /**
     * 初始化sdk
     * 注：在创建图片，语音，视频，文件等需要路径参数的消息体时，
     * 如果选择的是非全路径方法如：createSoundMessage（全路径方法为：createSoundMessageFromFullPath）,
     * 需要将文件自行拷贝到dbPath目录下，如果此时文件路径为 apath+"/sound/a.mp3"，则参数path的值为：/sound/a.mp3。
     * 如果选择的全路径方法，路径为你文件的实际路径不需要再拷贝。
     *
     * @param platform {@link io.openim.android.sdk.enums.Platform}
     * @param ipApi    SDK的API接口地址。如：http:xxx:10000
     * @param ipWs     SDK的web socket地址。如： ws:xxx:17778
     * @param dbDir    数据存储目录路径
     * @param listener SDK初始化监听
     */
    public void initSDK(int platform, String ipApi, String ipWs, String dbDir, InitSDKListener listener) {

        // fastjson is unreliable, should instead with google/gson in android
        String paramsText = JsonUtil.toString(CollectionUtils.simpleMapOf("platform", platform, "ipApi", Predicates.checkParamValue("ipApi", ipApi), "ipWs", Predicates.checkParamValue("ipWs", ipWs), "dbDir", Predicates.checkParamValue("dbDir", dbDir)));
        LogcatHelper.logDInDebug(String.format("init config: %s", paramsText));
        Open_im_sdk.initSDK(paramsText, new open_im_sdk.IMSDKListener() {
            @Override
            public void onConnectFailed(long l, String s) {
                if (null != listener) {
                    CommonUtil.runMainThread(() -> listener.onConnectFailed(l, s));
                }
            }

            @Override
            public void onConnectSuccess() {
                if (null != listener) {
                    CommonUtil.runMainThread(listener::onConnectSuccess);
                }
            }

            @Override
            public void onConnecting() {
                if (null != listener) {
                    CommonUtil.runMainThread(listener::onConnecting);
                }
            }

            @Override
            public void onKickedOffline() {
                if (null != listener) {
                    CommonUtil.runMainThread(listener::onKickedOffline);
                }
            }

            @Override
            public void onSelfInfoUpdated(String s) {
                if (null != listener) {
                    CommonUtil.runMainThread(() -> listener.onSelfInfoUpdated(JsonUtil.toObj(s, UserInfo.class)));
                }
            }

            @Override
            public void onUserTokenExpired() {
                if (null != listener) {
                    CommonUtil.runMainThread(listener::onUserTokenExpired);
                }
            }
        });
    }

    /**
     * 反初始化sdk
     */
    public void unInitSDK() {
//        Open_im_sdk.unInitSDK();
    }

    /**
     * 登录
     *
     * @param uid   用户id
     * @param token 用户token
     * @param base  callback String
     */
    public void login(OnBase<String> base, String uid, String token) {
        Open_im_sdk.login(uid, token, BaseImpl.stringBase(base));
    }

    /**
     * 登出
     */
    public void logout(OnBase<String> base) {
        Open_im_sdk.logout(BaseImpl.stringBase(base));
    }

    /**
     * 查询登录状态
     */
    public long getLoginStatus() {
        return Open_im_sdk.getLoginStatus();
    }

    /**
     * 当前登录uid
     */
    public String getLoginUid() {
        return Open_im_sdk.getLoginUid();
    }

    /**
     * 根据uid 批量查询用户信息
     *
     * @param uidList 用户id列表
     * @param base    callback List<{@link UserInfo}>
     */
    public void getUsersInfo(OnBase<List<UserInfo>> base, List<String> uidList) {
        Open_im_sdk.getUsersInfo(JsonUtil.toString(uidList), BaseImpl.arrayBase(base, UserInfo.class));
    }

    /**
     * 修改资料
     *
     * @param name   名字
     * @param icon   头像
     * @param gender 性别
     * @param mobile 手机号
     * @param birth  出生日期
     * @param email  邮箱
     * @param base   callback String
     */
    public void setSelfInfo(OnBase<String> base, String name, String icon, int gender, String mobile, String birth, String email) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("icon", icon);
        map.put("gender", gender);
        map.put("mobile", mobile);
        map.put("birth", birth);
        map.put("email", email);
        Open_im_sdk.setSelfInfo(JsonUtil.toString(map), BaseImpl.stringBase(base));
    }

    public void forceSyncLoginUerInfo() {
        Open_im_sdk.forceSyncLoginUerInfo();
    }

    public void forceReConn() {
        Open_im_sdk.forceReConn();
    }
}
