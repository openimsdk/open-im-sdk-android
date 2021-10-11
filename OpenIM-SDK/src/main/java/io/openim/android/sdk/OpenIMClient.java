package io.openim.android.sdk;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import io.openim.android.sdk.listener.ConnectListener;
import io.openim.android.sdk.listener.InitCallback;
import io.openim.android.sdk.listener.InitSDKListener;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.UserStateChangedListener;
import io.openim.android.sdk.manager.ConversationManager;
import io.openim.android.sdk.manager.FriendshipManager;
import io.openim.android.sdk.manager.GroupManager;
import io.openim.android.sdk.manager.MessageManager;
import io.openim.android.sdk.models.UserInfo;
import io.openim.android.sdk.user.Credential;
import io.openim.android.sdk.util.Predicates;

public final class OpenIMClient {

    @NonNull
    private static final OpenIMClient INSTANCE;

    //    public ImManager imManager;
    public ConversationManager conversationManager;
    public FriendshipManager friendshipManager;
    public GroupManager groupManager;
    public MessageManager messageManager;
    private final OpenIMClientImpl clientImpl;

    private OpenIMClient() {
        clientImpl = new OpenIMClientImpl();
        conversationManager = clientImpl.conversationManager;
        friendshipManager = clientImpl.friendshipManager;
        groupManager = clientImpl.groupManager;
        messageManager = clientImpl.messageManager;
//        imManager = new ImManager();
//        conversationManager = new ConversationManager();
//        friendshipManager = new FriendshipManager();
//        groupManager = new GroupManager();
//        messageManager = new MessageManager();
    }

    static {
        INSTANCE = new OpenIMClient();
    }

    @NonNull
    public static OpenIMClient getInstance() {
        return INSTANCE;
    }

    /**
     * Init sdk by config specified, must provide callback for init result.
     *
     * @param config   init configs
     * @param callback init result callback
     */
    public void init(@NonNull OpenIMConfig config, @NonNull InitCallback callback) {
        Predicates.requireNonNull(config);
        Predicates.requireNonNull(callback);

        clientImpl.init(config, callback);
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
    public boolean initSDK(String apiUrl, String wsUrl, String storageDir, InitSDKListener listener) {
        return clientImpl.initSDK(apiUrl, wsUrl, storageDir, listener);
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
     * @deprecated use {@link #login(Credential, OnBase)} instead
     */
    public void login(OnBase<String> base, String uid, String token) {
        if (TextUtils.isEmpty(uid) || TextUtils.isEmpty(token)) {
            if (Predicates.nonNull(base)) {
                // FIXME: give correct error-code for empty uid or token
                base.onError(-1, "Empty uid or token.");
            }
            return;
        }
        login(new Credential(uid, token), base);
    }

    /**
     * Login via user-credential
     *
     * @param credential user credential
     * @param callback   login callback
     */
    public void login(@NonNull Credential credential, OnBase<String> callback) {
        clientImpl.login(credential, callback);
    }

    /**
     * 登出
     */
    public void logout(OnBase<String> base) {
        clientImpl.logout(base);
    }

    /**
     * 查询登录状态
     */
    public long getLoginStatus() {
        return clientImpl.getLoginStatus();
    }

    /**
     * 当前登录uid
     */
    public String getLoginUid() {
        return clientImpl.getLoginUid();
    }

//    /**
//     * Returns message service instance
//     */
//    @NonNull
//    public MessageService getMessageService() {
//        return clientImpl.messageManager;
//    }

    /**
     * 根据uid 批量查询用户信息
     *
     * @param uidList 用户id列表
     * @param base    callback List<{@link UserInfo}>
     */
    public void getUsersInfo(OnBase<List<UserInfo>> base, List<String> uidList) {
        clientImpl.getUsersInfo(base, uidList);
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
        clientImpl.setSelfInfo(base, name, icon, gender, mobile, birth, email);
    }

    public void forceSyncLoginUerInfo() {
        clientImpl.forceSyncLoginUerInfo();
    }

    public void forceReConn() {
        clientImpl.forceReConn();
    }

    public void registerConnListener(@NonNull ConnectListener listener) {
        Predicates.requireNonNull(listener);

        clientImpl.registerConnListener(listener);
    }

    public void unregisterConnListener(@Nullable ConnectListener listener) {
        clientImpl.unregisterConnListener(listener);
    }

    public void registerUserChangedListener(@NonNull UserStateChangedListener listener) {
        Predicates.requireNonNull(listener);

        clientImpl.registerUserChangedListener(listener);
    }

    public void unregisterUserChangedListener(@Nullable UserStateChangedListener listener) {
        clientImpl.unregisterUserChangedListener(listener);
    }
}

