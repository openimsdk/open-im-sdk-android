package io.openim.android.sdk;

import io.openim.android.sdk.internal.log.LogcatHelper;
import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener._SDKListener;
import io.openim.android.sdk.listener.OnInitSDKListener;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.manager.ConversationManager;
import io.openim.android.sdk.manager.FriendshipManager;
import io.openim.android.sdk.manager.GroupManager;
import io.openim.android.sdk.manager.MessageManager;
import io.openim.android.sdk.manager.UserInfoManager;
import io.openim.android.sdk.utils.CollectionUtils;
import io.openim.android.sdk.utils.JsonUtil;
import open_im_sdk.Open_im_sdk;

public class OpenIMClient {
    //    public ImManager imManager;
    public ConversationManager conversationManager;
    public FriendshipManager friendshipManager;
    public GroupManager groupManager;
    public MessageManager messageManager;
    public UserInfoManager userInfoManager;

    private OpenIMClient() {
//        imManager = new ImManager();
        conversationManager = new ConversationManager();
        friendshipManager = new FriendshipManager();
        groupManager = new GroupManager();
        messageManager = new MessageManager();
        userInfoManager = new UserInfoManager();
    }

    private static class Singleton {
        private static final OpenIMClient INSTANCE = new OpenIMClient();
    }

    public static OpenIMClient getInstance() {
        return Singleton.INSTANCE;
    }

    /**
     * 初始化sdk
     * 注：在创建图片，语音，视频，文件等需要路径参数的消息体时，
     * 如果选择的是非全路径方法如：createSoundMessage（全路径方法为：createSoundMessageFromFullPath）,
     * 需要将文件自行拷贝到dbPath目录下，如果此时文件路径为 apath+"/sound/a.mp3"，则参数path的值为：/sound/a.mp3。
     * 如果选择的全路径方法，路径为你文件的实际路径不需要再拷贝。
     *
     * @param apiUrl     SDK的API接口地址。如：http:xxx:10000
     * @param wsUrl      SDK的web socket地址。如： ws:xxx:17778
     * @param storageDir 数据存储目录路径
     * @param listener   SDK初始化监听
     * @return boolean   true成功; false失败
     */
    public boolean initSDK(String apiUrl, String wsUrl, String storageDir, OnInitSDKListener listener) {
        // fastjson is unreliable, should instead with google/gson in android
        String paramsText = JsonUtil.toString(CollectionUtils.simpleMapOf("platform", 2, "ipApi", apiUrl, "ipWs", wsUrl, "dbDir", storageDir));
        LogcatHelper.logDInDebug(String.format("init config: %s", paramsText));
        boolean initialized = Open_im_sdk.initSDK(paramsText, new _SDKListener(listener));
        LogcatHelper.logDInDebug(String.format("Initialization successful: %s", initialized));
        return initialized;
    }

//    /**
//     * 反初始化sdk
//     */
//    public void unInitSDK() {
//        Open_im_sdk.unInitSDK();
//    }

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

//    /**
//     * 当前登录uid
//     */
//    public String getLoginUid() {
//        return Open_im_sdk.getLoginUid();
//    }



//    public void forceReConn() {
//        clientImpl.forceReConn();
//    }
}

