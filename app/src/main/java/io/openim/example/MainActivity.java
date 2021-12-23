package io.openim.example;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import io.openim.android.sdk.OpenIMClient;
import io.openim.android.sdk.listener.OnInitSDKListener;
import io.openim.android.sdk.listener.OnAdvanceMsgListener;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnConversationListener;
import io.openim.android.sdk.listener.OnFriendshipListener;
import io.openim.android.sdk.listener.OnGroupListener;
import io.openim.android.sdk.listener.OnMsgSendCallback;
import io.openim.android.sdk.models.ConversationInfo;
import io.openim.android.sdk.models.GroupInfo;
import io.openim.android.sdk.models.GroupMembersInfo;
import io.openim.android.sdk.models.HaveReadInfo;
import io.openim.android.sdk.models.Message;
import io.openim.android.sdk.models.UserInfo;
import io.openim.android.sdk.utils.JsonUtil;

public class MainActivity extends AppCompatActivity implements OnInitSDKListener, OnAdvanceMsgListener, OnConversationListener, OnFriendshipListener,
    OnGroupListener {

    /// api地址
    final static String IP_API = "http://121.37.25.71:10000";
    /// websocket地址
    final static String IP_WS = "ws://121.37.25.71:17778";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String path = getExternalCacheDir().getAbsolutePath();
        OpenIMClient client = OpenIMClient.getInstance();
        client.initSDK(IP_API, IP_WS, path, this);
        client.messageManager.addAdvancedMsgListener(this);
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

    public void onLogin(View view) {
        OpenIMClient.getInstance().login(new OnBase<String>() {
            @Override
            public void onError(long code, String error) {

            }

            @Override
            public void onSuccess(String data) {
                System.out.println("登录成功!");

            }
        }, "13918588195", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVSUQiOiIxMzkxODU4ODE5NSIsIlBsYXRmb3JtIjoiQW5kcm9pZCIsImV4cCI6MTYzNzU1MDk1OSwibmJmIjoxNjM2OTQ2MTU5LCJpYXQiOjE2MzY5NDYxNTl9.vztWBG0bT3FaA1yKSUuc8WURTOafousbIU8Ixv3eWNo");
    }

    public void onGetMessageHistory(View view) {
        OpenIMClient.getInstance().messageManager.getHistoryMessageList(new OnBase<List<Message>>() {
            @Override
            public void onError(long code, String error) {

            }

            @Override
            public void onSuccess(List<Message> data) {
                System.out.println("消息数：" + data.size());
            }
        }, "0b55c23c7fac2b34", "", null, 20);
    }

    public void onSendMsgTest(View view) {
        Message message = OpenIMClient.getInstance().messageManager.createTextMessage("哟，这是测试消息");
        OpenIMClient.getInstance().messageManager.sendMessage(new OnMsgSendCallback() {
            @Override
            public void onError(long code, String error) {
                System.out.println("========onError==========="+ error);
            }

            @Override
            public void onProgress(long progress) {
                System.out.println("========progress==========="+ progress);
            }

            @Override
            public void onSuccess(String s) {
                System.out.println("========onSuccess==========="+ s);
            }
        }, message, "17396220460", null, false);
    }
}
