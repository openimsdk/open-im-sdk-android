package io.openim.android.sdk;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.InitSDKListener;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.manager.ConversationManager;
import io.openim.android.sdk.manager.FriendshipManager;
import io.openim.android.sdk.manager.GroupManager;
import io.openim.android.sdk.manager.MessageManager;
import io.openim.android.sdk.models.UserInfo;
import io.openim.android.sdk.utils.CommonUtil;
import open_im_sdk.Open_im_sdk;

public class OpenIMClient {
    //    public ImManager imManager;
    public ConversationManager conversationManager;
    public FriendshipManager friendshipManager;
    public GroupManager groupManager;
    public MessageManager messageManager;

    private OpenIMClient() {
//        imManager = new ImManager();
        conversationManager = new ConversationManager();
        friendshipManager = new FriendshipManager();
        groupManager = new GroupManager();
        messageManager = new MessageManager();
    }

    private static class Singleton {
        private static final OpenIMClient instance = new OpenIMClient();
    }

    public static OpenIMClient getInstance() {
        return Singleton.instance;
    }

    public void initSDK(int platform, String ipApi, String ipWs, String dbPath, InitSDKListener listener) {
        Map<String, Object> map = new HashMap<>();
        map.put("platform", platform);
        map.put("ipApi", ipApi);
        map.put("ipWs", ipWs);
        map.put("dbDir", dbPath);
        Open_im_sdk.initSDK(JSON.toJSONString(map), new open_im_sdk.IMSDKListener() {
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
                    CommonUtil.runMainThread(() -> listener.onSelfInfoUpdated(JSON.parseObject(s, UserInfo.class)));
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

    public void unInitSDK() {
        Open_im_sdk.unInitSDK();
    }

    public void login(OnBase<String> base, String uid, String token) {
        Open_im_sdk.login(uid, token, BaseImpl.stringBase(base));
    }

    public void logout(OnBase<String> base) {
        Open_im_sdk.logout(BaseImpl.stringBase(base));
    }

    public long getLoginStatus() {
        return Open_im_sdk.getLoginStatus();
    }

    public String getLoginUid() {
        return Open_im_sdk.getLoginUid();
    }

    public void getUsersInfo(OnBase<List<UserInfo>> base, List<String> uidList) {
        Open_im_sdk.getUsersInfo(JSON.toJSONString(uidList), BaseImpl.arrayBase(base, UserInfo.class));
    }

    public void setSelfInfo(OnBase<String> base, UserInfo info) {
        Open_im_sdk.setSelfInfo(JSON.toJSONString(info), BaseImpl.stringBase(base));
    }

    public void forceSyncLoginUerInfo() {
        Open_im_sdk.forceSyncLoginUerInfo();
    }

    public void forceReConn() {
        Open_im_sdk.forceReConn();
    }
}
