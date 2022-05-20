package io.openim.android.sdk;

import androidx.collection.ArrayMap;

import java.util.Map;

import io.openim.android.sdk.internal.log.LogcatHelper;
import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnConnListener;
import io.openim.android.sdk.listener.OnFileUploadProgressListener;
import io.openim.android.sdk.listener._ConnListener;
import io.openim.android.sdk.listener._FileUploadProgressListener;
import io.openim.android.sdk.manager.ConversationManager;
import io.openim.android.sdk.manager.FriendshipManager;
import io.openim.android.sdk.manager.GroupManager;
import io.openim.android.sdk.manager.MessageManager;
import io.openim.android.sdk.manager.OrganizationManager;
import io.openim.android.sdk.manager.SignalingManager;
import io.openim.android.sdk.manager.UserInfoManager;
import io.openim.android.sdk.manager.WorkMomentsManager;
import io.openim.android.sdk.utils.JsonUtil;
import io.openim.android.sdk.utils.ParamsUtil;
import open_im_sdk.Open_im_sdk;

public class OpenIMClient {
    //    public ImManager imManager;
    public ConversationManager conversationManager;
    public FriendshipManager friendshipManager;
    public GroupManager groupManager;
    public MessageManager messageManager;
    public UserInfoManager userInfoManager;
    public SignalingManager signalingManager;
    public WorkMomentsManager workMomentsManager;
    public OrganizationManager organizationManager;

    private OpenIMClient() {
//        imManager = new ImManager();
        conversationManager = new ConversationManager();
        friendshipManager = new FriendshipManager();
        groupManager = new GroupManager();
        messageManager = new MessageManager();
        userInfoManager = new UserInfoManager();
        signalingManager = new SignalingManager();
        workMomentsManager = new WorkMomentsManager();
        organizationManager = new OrganizationManager();
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
     * @param apiUrl        SDK的API接口地址。如：http:xxx:10000
     * @param wsUrl         SDK的web socket地址。如： ws:xxx:17778
     * @param storageDir    数据存储目录路径
     * @param logLevel      日志等级，如：6
     * @param objectStorage 图片上传配置 如：cos
     * @param listener      SDK初始化监听
     * @return boolean   true成功; false失败
     */
    public boolean initSDK(String apiUrl, String wsUrl, String storageDir, int logLevel, String objectStorage, OnConnListener listener) {
        Map<String, Object> map = new ArrayMap<>();
        map.put("platform", 2);
        map.put("api_addr", apiUrl);
        map.put("ws_addr", wsUrl);
        map.put("data_dir", storageDir);
        map.put("log_level", logLevel);
        map.put("object_storage", objectStorage);
        boolean initialized = Open_im_sdk.initSDK(new _ConnListener(listener), ParamsUtil.buildOperationID(), JsonUtil.toString(map));
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
        Open_im_sdk.login(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), uid, token);
    }


    /**
     * 登出
     */
    public void logout(OnBase<String> base) {
        Open_im_sdk.logout(BaseImpl.stringBase(base), ParamsUtil.buildOperationID());
    }

    /**
     * 查询登录状态
     */
    public long getLoginStatus() {
        return Open_im_sdk.getLoginStatus();
    }


    public void wakeUp(OnBase<String> base) {
        Open_im_sdk.wakeUp(BaseImpl.stringBase(base), ParamsUtil.buildOperationID());
    }


    /**
     * 上传文件到服务器
     *
     * @param path 路径
     */
    public void uploadFile(OnFileUploadProgressListener listener, String path) {
        Open_im_sdk.uploadFile(new _FileUploadProgressListener(listener), ParamsUtil.buildOperationID(), path);
    }
}

