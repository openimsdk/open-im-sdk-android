package io.openim.android.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;


import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

import io.openim.android.sdk.internal.log.LogcatHelper;
import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnConnListener;
import io.openim.android.sdk.listener.OnListenerForService;
import io.openim.android.sdk.listener._ConnListener;
import io.openim.android.sdk.listener._ListenerForService;
import io.openim.android.sdk.listener._PutFileCallback;
import io.openim.android.sdk.manager.ConversationManager;
import io.openim.android.sdk.manager.FriendshipManager;
import io.openim.android.sdk.manager.GroupManager;
import io.openim.android.sdk.manager.MessageManager;
import io.openim.android.sdk.manager.SignalingManager;
import io.openim.android.sdk.manager.UserInfoManager;
import io.openim.android.sdk.manager.WorkMomentsManager;
import io.openim.android.sdk.utils.CommonUtil;
import io.openim.android.sdk.utils.JsonUtil;
import io.openim.android.sdk.utils.ParamsUtil;
import open_im_sdk.Open_im_sdk;
import open_im_sdk_callback.Base;
import open_im_sdk_callback.PutFileCallback;

public class OpenIMClient {
    public ConversationManager conversationManager;
    public FriendshipManager friendshipManager;
    public GroupManager groupManager;
    public MessageManager messageManager;
    public UserInfoManager userInfoManager;
    public SignalingManager signalingManager;
    public WorkMomentsManager workMomentsManager;

    //前台Activity数量
    private int frontCount = 0;
    @NotNull("You need to call the 'initSDK' method first")
    private Application app;

    private OpenIMClient() {
        conversationManager = new ConversationManager();
        friendshipManager = new FriendshipManager();
        groupManager = new GroupManager();
        messageManager = new MessageManager();
        userInfoManager = new UserInfoManager();
        signalingManager = new SignalingManager();
        workMomentsManager = new WorkMomentsManager();
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
     * @param platform             平台{@link io.openim.android.sdk.enums.Platform}
     * @param apiUrl               SDK的API接口地址。如：http:xxx:10000
     * @param wsUrl                SDK的web socket地址。如： ws:xxx:17778
     * @param storageDir           数据存储目录路径
     * @param logLevel             日志等级，如：6
     * @param isLogStandardOutput  控制台是否输出日志
     * @param logFilePath          日志输出的路径
     * @param listener             SDK初始化监听
     * @param isExternalExtensions 消息扩展
     * @return boolean   true成功; false失败
     */
    public boolean initSDK(Application application, int platform, String apiUrl, String wsUrl, String storageDir, int logLevel, boolean isLogStandardOutput,
                           String logFilePath, boolean isExternalExtensions, @NotNull OnConnListener listener) {
        this.app = application;
        Map<String, Object> map = new ArrayMap<>();
        map.put("platformID", platform);
        map.put("apiAddr", apiUrl);
        map.put("wsAddr", wsUrl);
        map.put("dataDir", storageDir);
        map.put("logLevel", logLevel);
        map.put("isLogStandardOutput", isLogStandardOutput);
        map.put("logFilePath", logFilePath);
        map.put("isExternalExtensions", isExternalExtensions);

        boolean initialized = Open_im_sdk.initSDK(new _ConnListener(listener), ParamsUtil.buildOperationID(), JsonUtil.toString(map));
        LogcatHelper.logDInDebug(String.format("Initialization successful: %s", initialized));

        registerActivityLifecycleCallbacks();
        return initialized;
    }

    private void registerNetworkCallback() {
        ConnectivityManager connectivityManager = (ConnectivityManager) app.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {//API 大于26时
            connectivityManager.registerDefaultNetworkCallback(networkCallback);
        } else {//API 大于21时
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            NetworkRequest request = builder.build();
            connectivityManager.registerNetworkCallback(request, networkCallback);
        }
    }

    private final ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() {
        @Override
        public void onAvailable(@NonNull Network network) {
            //网络可用的时候调用
            networkChanged();
        }

        @Override
        public void onLosing(@NonNull Network network, int maxMsToLive) {
            //网络正在减弱，链接会丢失数据，即将断开网络时调用
            networkChanged();
        }

        @Override
        public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
            //网络功能发生改变时调用
            networkChanged();
        }

        @Override
        public void onLinkPropertiesChanged(@NonNull Network network, @NonNull LinkProperties linkProperties) {
            //网络连接属性发生改变时调用
            networkChanged();
        }
    };


    private void registerActivityLifecycleCallbacks() {
        app.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityStarted(Activity activity) {
                if (frontCount++ == 0) {
                    // 执行切换到前台的逻辑
                    setAppBackgroundStatus(false);
                }
            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {
                if (--frontCount == 0) {
                    // 执行切换到后台的逻辑
                    setAppBackgroundStatus(true);
                }
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    private static void setAppBackgroundStatus(boolean isBackground) {
        Open_im_sdk.setAppBackgroundStatus(new Base() {
            @Override
            public void onError(int i, String s) {

            }

            @Override
            public void onSuccess(String s) {

            }
        }, ParamsUtil.buildOperationID(), isBackground);
    }

    /**
     * 登录
     * 注：调用此方法前请先注册各类监听如：OnAdvanceMsgListener、OnFriendshipListener、OnConversationListener、OnGroupListener等...
     *
     * @param uid   用户id
     * @param token 用户token
     * @param base  callback String
     */
    public void login(@NotNull OnBase<String> base, String uid, String token) {
        Open_im_sdk.login(new Base() {
            @Override
            public void onError(int i, String s) {
                CommonUtil.returnError(base, i, s);
            }

            @Override
            public void onSuccess(String s) {
                registerNetworkCallback();

                CommonUtil.returnSuccess(base, s);
            }
        }, ParamsUtil.buildOperationID(), uid, token);
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
    public int getLoginStatus() {
        return (int) Open_im_sdk.getLoginStatus();
    }


    /**
     * 上传文件到服务器
     *
     * @param path 路径
     */
    public void uploadFile(OnBase<String> base, PutFileCallback listener, String path) {
        Open_im_sdk.putFile(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), path, new _PutFileCallback(listener));
    }

    /**
     * 更新firebase token
     *
     * @param fcmToken token
     */
    public void updateFcmToken(OnBase<String> base, String fcmToken) {
        Open_im_sdk.updateFcmToken(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), fcmToken);
    }


    public void setOnListenerForService(OnListenerForService listener) {
        Open_im_sdk.setListenerForService(new _ListenerForService(listener));
    }

    public void networkChanged() {
        Open_im_sdk.networkStatusChanged(new Base() {
            @Override
            public void onError(int i, String s) {

            }

            @Override
            public void onSuccess(String s) {

            }
        }, ParamsUtil.buildOperationID());
    }
}

