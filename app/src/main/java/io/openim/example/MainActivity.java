package io.openim.example;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import io.openim.android.sdk.OpenIMClient;
import io.openim.android.sdk.listener.OnAdvanceMsgListener;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnConnListener;
import io.openim.android.sdk.listener.OnConversationListener;
import io.openim.android.sdk.listener.OnFriendshipListener;
import io.openim.android.sdk.listener.OnGroupListener;
import io.openim.android.sdk.listener.OnUserListener;
import io.openim.android.sdk.models.BlacklistInfo;
import io.openim.android.sdk.models.ConversationInfo;
import io.openim.android.sdk.models.FriendApplicationInfo;
import io.openim.android.sdk.models.FriendInfo;
import io.openim.android.sdk.models.GroupApplicationInfo;
import io.openim.android.sdk.models.GroupInfo;
import io.openim.android.sdk.models.GroupMembersInfo;
import io.openim.android.sdk.models.Message;
import io.openim.android.sdk.models.ReadReceiptInfo;
import io.openim.android.sdk.models.UserInfo;
import io.openim.android.sdk.utils.JsonUtil;

public class MainActivity extends AppCompatActivity implements OnConnListener, OnUserListener, OnAdvanceMsgListener, OnConversationListener, OnFriendshipListener,
    OnGroupListener {

    /// api地址
    final static String IP_API = "http://43.128.5.63:10000";
    /// websocket地址
    final static String IP_WS = "ws://43.128.5.63:17778";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String path = getExternalCacheDir().getAbsolutePath();
        OpenIMClient client = OpenIMClient.getInstance();
        client.initSDK(IP_API, IP_WS, path, 6, "cos", this);
        client.userInfoManager.setOnUserListener(this);
        client.messageManager.setAdvancedMsgListener(this);
        client.groupManager.setOnGroupListener(this);
        client.conversationManager.setOnConversationListener(this);
        client.friendshipManager.setOnFriendshipListener(this);
        // uid: 13918588195, token: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
    }

    @Override
    public void onConnectFailed(long code, String error) {
        System.out.println("=======onConnectFailed=================");
    }

    @Override
    public void onConnectSuccess() {
        System.out.println("===========onConnectSuccess=============");
    }

    @Override
    public void onConnecting() {
        System.out.println("==========onConnecting==============");
    }

    @Override
    public void onKickedOffline() {
        System.out.println("==========onKickedOffline==============");
    }

    @Override
    public void onSelfInfoUpdated(UserInfo info) {
        System.out.println("==========onSelfInfoUpdated==============");
    }

    @Override
    public void onUserTokenExpired() {
        System.out.println("=========onUserTokenExpired===============");
    }

    @Override
    public void onRecvNewMessage(Message msg) {
        System.out.println("=========onRecvNewMessage===============");
    }

    @Override
    public void onRecvC2CReadReceipt(List<ReadReceiptInfo> list) {
        System.out.println("========onRecvC2CReadReceipt================");
    }

    @Override
    public void onRecvGroupMessageReadReceipt(List<ReadReceiptInfo> list) {

    }

    @Override
    public void onRecvMessageRevoked(String msgId) {
        System.out.println("=======onRecvMessageRevoked=================");
    }

    @Override
    public void onConversationChanged(List<ConversationInfo> list) {
        System.out.println("========onConversationChanged================");
    }

    @Override
    public void onNewConversation(List<ConversationInfo> list) {
        System.out.println("==========onNewConversation==============");
    }

    @Override
    public void onSyncServerFailed() {
        System.out.println("========onSyncServerFailed================");
    }

    @Override
    public void onSyncServerFinish() {
        System.out.println("=========onSyncServerFinish===============");
    }

    @Override
    public void onSyncServerStart() {
        System.out.println("=========onSyncServerStart===============");
    }

    @Override
    public void onTotalUnreadMessageCountChanged(int i) {
        System.out.println("==========onTotalUnreadMessageCountChanged==============");
    }


    public void onGetConversation(View view) {
        OpenIMClient.getInstance().conversationManager.getAllConversationList(new OnBase<List<ConversationInfo>>() {
            @Override
            public void onError(int code, String error) {
            }

            @Override
            public void onSuccess(List<ConversationInfo> data) {
                System.out.println("onGetConversation:" + JsonUtil.toString(data));
            }
        });
    }

    public void onLogin(View view) {
        System.out.println("============login============");
        OpenIMClient.getInstance().login(new OnBase<String>() {
            @Override
            public void onError(int code, String error) {

            }

            @Override
            public void onSuccess(String data) {
                System.out.println("登录成功!");

            }
        }, "13900000000", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVSUQiOiIxMzkwMDAwMDAwMCIsIlBsYXRmb3JtIjoiQW5kcm9pZCIsImV4cCI6MTk2Mzk3MjE0NCwibmJmIjoxNjQ4NjEyMTQ0LCJpYXQiOjE2NDg2MTIxNDR9.BEqWSNHV4P6d9NrA1Ji_kyHx1WnZY7R1Iket_6Oqpns");
    }

    public void onGetMessageHistory(View view) {

    }

    public void onSendMsgTest(View view) {

    }

    @Override
    public void onBlacklistAdded(BlacklistInfo u) {

    }

    @Override
    public void onBlacklistDeleted(BlacklistInfo u) {

    }

    @Override
    public void onFriendApplicationAccepted(FriendApplicationInfo u) {

    }

    @Override
    public void onFriendApplicationAdded(FriendApplicationInfo u) {

    }

    @Override
    public void onFriendApplicationDeleted(FriendApplicationInfo u) {

    }

    @Override
    public void onFriendApplicationRejected(FriendApplicationInfo u) {

    }

    @Override
    public void onFriendInfoChanged(FriendInfo u) {

    }

    @Override
    public void onFriendAdded(FriendInfo u) {

    }

    @Override
    public void onFriendDeleted(FriendInfo u) {

    }

    @Override
    public void onGroupApplicationAccepted(GroupApplicationInfo info) {

    }

    @Override
    public void onGroupApplicationAdded(GroupApplicationInfo info) {

    }

    @Override
    public void onGroupApplicationDeleted(GroupApplicationInfo info) {

    }

    @Override
    public void onGroupApplicationRejected(GroupApplicationInfo info) {

    }

    @Override
    public void onGroupInfoChanged(GroupInfo info) {

    }

    @Override
    public void onGroupMemberAdded(GroupMembersInfo info) {

    }

    @Override
    public void onGroupMemberDeleted(GroupMembersInfo info) {

    }

    @Override
    public void onGroupMemberInfoChanged(GroupMembersInfo info) {

    }

    @Override
    public void onJoinedGroupAdded(GroupInfo info) {

    }

    @Override
    public void onJoinedGroupDeleted(GroupInfo info) {

    }
}
