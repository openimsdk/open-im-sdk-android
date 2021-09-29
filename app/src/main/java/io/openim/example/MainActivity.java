package io.openim.example;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import io.openim.android.sdk.OpenIMClient;
import io.openim.android.sdk.listener.InitSDKListener;
import io.openim.android.sdk.listener.OnAdvanceMsgListener;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnConversationListener;
import io.openim.android.sdk.listener.OnFriendshipListener;
import io.openim.android.sdk.listener.OnGroupListener;
import io.openim.android.sdk.models.ConversationInfo;
import io.openim.android.sdk.models.GroupInfo;
import io.openim.android.sdk.models.GroupMembersInfo;
import io.openim.android.sdk.models.HaveReadInfo;
import io.openim.android.sdk.models.Message;
import io.openim.android.sdk.models.UserInfo;
import io.openim.android.sdk.user.Credential;
import io.openim.android.sdk.util.JsonUtil;

public class MainActivity extends AppCompatActivity implements InitSDKListener, OnAdvanceMsgListener, OnConversationListener, OnFriendshipListener,
    OnGroupListener {

    /// api地址
    final static String IP_API = "https://open-im.rentsoft.cn";
    /// websocket地址
    final static String IP_WS = "wss://open-im.rentsoft.cn/wss";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String path = getExternalCacheDir().getAbsolutePath();
        OpenIMClient client = OpenIMClient.getInstance();
        client.initSDK(2, IP_API, IP_WS, path, this);
        client.messageManager.addAdvancedMsgListener(this);
//        OpenIMClient.getInstance().conversationManager.setOnConversationListener(this);
//        OpenIMClient.getInstance().friendshipManager.setOnFriendListener(this);
//        OpenIMClient.getInstance().groupManager.setOnGroupListener(this);
//        Credential credential = new Credential(
//            "345513c4bd30ed21",
//            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVSUQiOiIzNDU1MTNjNGJkMzBlZDIxIiwiUGxhdGZvcm0iOiJJT1MiLCJleHAiOjE2MzAwMzczNzAsImlhdCI6MTYyOTQzMjU3MCwibmJmIjoxNjI5NDMyNTcwfQ.jWMhpQMpchJXvJX3CC4BYCrEUxeuHoFeqmx4GPUsOWg"
//        );
//        client.login(credential, new OnBase<String>() {
//            @Override
//            public void onError(long code, String error) {
//                System.out.println("=======login onError =================");
//            }
//
//            @Override
//            public void onSuccess(String data) {
//                System.out.println("=======login onSuccess =================");
//            }
//        });
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
    public void onRecvC2CReadReceipt(List<HaveReadInfo> list) {
        System.out.println("========onRecvC2CReadReceipt================");
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

    @Override
    public void onBlackListAdd(UserInfo u) {
        System.out.println("==========onBlackListAdd==============");
    }

    @Override
    public void onBlackListDeleted(UserInfo u) {
        System.out.println("=======onBlackListDeleted=================");
    }

    @Override
    public void onFriendApplicationListAccept(UserInfo u) {
        System.out.println("=========onFriendApplicationListAccept===============");
    }

    @Override
    public void onFriendApplicationListAdded(UserInfo u) {
        System.out.println("==========onFriendApplicationListAdded==============");
    }

    @Override
    public void onFriendApplicationListDeleted(UserInfo u) {
        System.out.println("======onFriendApplicationListDeleted==================");
    }

    @Override
    public void onFriendApplicationListReject(UserInfo u) {
        System.out.println("=======onFriendApplicationListReject=================");
    }

    @Override
    public void onFriendInfoChanged(UserInfo u) {
        System.out.println("=====onFriendInfoChanged===================");
    }

    @Override
    public void onFriendListAdded(UserInfo u) {
        System.out.println("========onFriendListAdded================");
    }

    @Override
    public void onFriendListDeleted(UserInfo u) {
        System.out.println("========onFriendListDeleted================");
    }

    @Override
    public void onMemberEnter(String groupId, List<GroupMembersInfo> list) {
        System.out.println("========onMemberEnter================");
    }

    @Override
    public void onMemberLeave(String groupId, GroupMembersInfo info) {
        System.out.println("=========onMemberLeave===============");
    }

    @Override
    public void onMemberInvited(String groupId, GroupMembersInfo opUser, List<GroupMembersInfo> list) {
        System.out.println("=========onMemberInvited===============");
    }

    @Override
    public void onMemberKicked(String groupId, GroupMembersInfo opUser, List<GroupMembersInfo> list) {
        System.out.println("=========onMemberKicked===============");
    }

    @Override
    public void onGroupCreated(String groupId) {
        System.out.println("==========onGroupCreated==============");
    }

    @Override
    public void onGroupInfoChanged(String groupId, GroupInfo info) {
        System.out.println("===========onGroupInfoChanged=============");
    }

    @Override
    public void onReceiveJoinApplication(String groupId, GroupMembersInfo info, String opReason) {
        System.out.println("===========onReceiveJoinApplication=============");
    }

    @Override
    public void onApplicationProcessed(String groupId, GroupMembersInfo opUser, int agreeOrReject, String opReason) {
        System.out.println("============onApplicationProcessed============");
    }

    public void onGetConversation(View view) {
        OpenIMClient.getInstance().conversationManager.getAllConversationList(new OnBase<List<ConversationInfo>>() {
            @Override
            public void onError(long code, String error) {
            }

            @Override
            public void onSuccess(List<ConversationInfo> data) {
                System.out.println("onGetConversation:" + JsonUtil.toString(data));
            }
        });
    }
}
