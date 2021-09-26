package io.openim.android.sdk;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import io.openim.android.sdk.internal.tools.Schedulers;
import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.ConnectListener;
import io.openim.android.sdk.listener.InitCallback;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.manager.ConversationManager;
import io.openim.android.sdk.manager.FriendshipManager;
import io.openim.android.sdk.manager.GroupManager;
import io.openim.android.sdk.manager.MessageManager;
import io.openim.android.sdk.models.UserInfo;
import io.openim.android.sdk.user.Credential;
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

    private ConnectListener mConnListener;

    OpenIMClientImpl() {
        conversationManager = new ConversationManager();
        friendshipManager = new FriendshipManager();
        groupManager = new GroupManager();
        messageManager = new MessageManager();
    }

    void init(@NonNull String jsonConf, @Nullable InitCallback callback) {
        if (TextUtils.isEmpty(jsonConf)) {
            RuntimeException err = new IllegalArgumentException("Invalid config json: empty.");
            if (Predicates.isNull(callback)) {
                throw err;
            }
            callback.onFailed(err);
            return;
        }
        Open_im_sdk.initSDK(jsonConf, createCoreListener());
    }

    void release() {
        Open_im_sdk.unInitSDK();
    }

    void registerConnListener(@NonNull ConnectListener listener) {
        mConnListener = Predicates.requireNonNull(listener);
    }

    void login(@NonNull Credential credential, @Nullable OnBase<String> callback) {
        Predicates.requireNonNull(credential);
        String uid = credential.getUid();
        String token = credential.getToken();
        if (TextUtils.isEmpty(uid) || TextUtils.isEmpty(token)) {
            if (Predicates.nonNull(callback)) {
                callback.onError(-1, "Empty uid or token.");
            }
            return;
        }
        Open_im_sdk.login(uid, token, BaseImpl.stringBase(callback));
    }

    void logout(@Nullable OnBase<String> callback) {
        Open_im_sdk.logout(BaseImpl.stringBase(Predicates.nonNull(callback) ? callback : new OnBase<String>() {
            @Override
            public void onError(long code, String error) {
            }

            @Override
            public void onSuccess(String data) {
            }
        }));
    }

    private open_im_sdk.IMSDKListener createCoreListener() {
        return new open_im_sdk.IMSDKListener() {
            @Override
            public void onConnectFailed(long code, String s) {
                if (Predicates.isNull(mConnListener)) return;
                final ConnectListener l = Predicates.requireNonNull(mConnListener);
                Schedulers.runOnMainThread(() -> l.onConnectFailed(code, s));
            }

            @Override
            public void onConnectSuccess() {
                if (Predicates.isNull(mConnListener)) return;
                final ConnectListener l = Predicates.requireNonNull(mConnListener);
                Schedulers.runOnMainThread(l::onConnectSuccess);
            }

            @Override
            public void onConnecting() {
                if (Predicates.isNull(mConnListener)) return;
                final ConnectListener l = Predicates.requireNonNull(mConnListener);
                Schedulers.runOnMainThread(l::onConnecting);
            }

            @Override
            public void onKickedOffline() {
                if (Predicates.isNull(mConnListener)) return;
                final ConnectListener l = Predicates.requireNonNull(mConnListener);
                Schedulers.runOnMainThread(l::onKickedOffline);
            }

            @Override
            public void onSelfInfoUpdated(String s) {
                if (Predicates.isNull(mConnListener)) return;
                final ConnectListener l = Predicates.requireNonNull(mConnListener);
                Schedulers.runOnMainThread(() -> l.onSelfInfoUpdated(JsonUtil.toObj(s, UserInfo.class)));
            }

            @Override
            public void onUserTokenExpired() {
                if (Predicates.isNull(mConnListener)) return;
                final ConnectListener l = Predicates.requireNonNull(mConnListener);
                Schedulers.runOnMainThread(l::onUserTokenExpired);
            }
        };
    }
}
