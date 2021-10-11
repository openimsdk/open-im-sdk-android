package io.openim.example

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.openim.android.sdk.OpenIMClient
import io.openim.android.sdk.OpenIMConfig
import io.openim.android.sdk.listener.*
import io.openim.android.sdk.models.*
import io.openim.android.sdk.user.Credential
import io.openim.android.sdk.util.JsonUtil
import io.openim.example.util.logD
import io.openim.example.util.logE
import io.openim.example.util.logI

class MainActivity : AppCompatActivity(), InitSDKListener, OnAdvanceMsgListener, OnConversationListener, OnFriendshipListener, OnGroupListener {

    // api地址
    val IP_API = "http://1.14.194.38:10000"

    // websocket地址
    val IP_WS = "ws://1.14.194.38:17778"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val path = externalCacheDir!!.absolutePath
        val client = OpenIMClient.getInstance()
        // client.initSDK(IP_API, IP_WS, path, this);
        val credential = OpenIMConfig.builder().setHostUrl(IP_API).setWsHostUrl(IP_WS).setStorageDir(path).build()
        client.init(credential, object : InitCallback {
            override fun onSucceed() {
                logI { "init succeed >>>" }
            }

            override fun onFailed(throwable: Throwable) {
                logE(throwable = throwable) { "init failed: ${throwable.message}" }
            }
        })
        client.registerConnListener(object : ConnectListener {
            override fun onConnectFailed(code: Long, error: String?) {
                this@MainActivity.onConnectFailed(code, error)
            }

            override fun onConnectSuccess() {
                this@MainActivity.onConnectSuccess()
            }

            override fun onConnecting() {
                this@MainActivity.onConnecting()
            }

            override fun onKickedOffline() {
                this@MainActivity.onKickedOffline()
            }
        })
        client.registerUserChangedListener(object : UserStateChangedListener {
            override fun onSelfProfileUpdated(info: UserInfo?) {
                this@MainActivity.onSelfInfoUpdated(info)
            }

            override fun onUserTokenExpired() {
                this@MainActivity.onUserTokenExpired()
            }
        })
        client.messageManager.addAdvancedMsgListener(this)
        client.groupManager.setOnGroupListener(this)
        client.conversationManager.setOnConversationListener(this)
        client.friendshipManager.setOnFriendshipListener(this)
        // uid: 13918588195, token: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
    }

    /* InitSDKListener*/

    override fun onConnectFailed(code: Long, error: String?) {
        logE { "=======onConnectFailed=================" }
    }

    override fun onConnectSuccess() {
        logI { "===========onConnectSuccess=============" }
    }

    override fun onConnecting() {
        logD { "==========onConnecting==============" }
    }

    override fun onKickedOffline() {
        logD { "==========onKickedOffline==============" }
    }

    override fun onSelfInfoUpdated(info: UserInfo?) {
        logD { "==========onSelfInfoUpdated==============" }
    }

    override fun onUserTokenExpired() {
        logD { "=========onUserTokenExpired===============" }
    }

    /* OnAdvanceMsgListener */

    override fun onRecvNewMessage(msg: Message?) {
        logD { "=========onRecvNewMessage===============" }
    }

    override fun onRecvC2CReadReceipt(list: MutableList<HaveReadInfo>?) {
        logD { "========onRecvC2CReadReceipt================" }
    }

    override fun onRecvMessageRevoked(msgId: String?) {
        logD { "=======onRecvMessageRevoked=================" }
    }

    /* OnConversationListener */

    override fun onConversationChanged(list: MutableList<ConversationInfo>?) {
        logD { "========onConversationChanged================" }
    }

    override fun onNewConversation(list: MutableList<ConversationInfo>?) {
        logD { "==========onNewConversation==============" }
    }

    override fun onSyncServerFailed() {
        logD { "========onSyncServerFailed================" }
    }

    override fun onSyncServerFinish() {
        logD { "=========onSyncServerFinish===============" }
    }

    override fun onSyncServerStart() {
        logD { "=========onSyncServerStart===============" }
    }

    override fun onTotalUnreadMessageCountChanged(i: Int) {
        logD { "==========onTotalUnreadMessageCountChanged==============" }
    }

    /* OnFriendshipListener */

    override fun onBlackListAdd(u: UserInfo?) {
        logD { "==========onBlackListAdd==============" }
    }

    override fun onBlackListDeleted(u: UserInfo?) {
        logD { "=======onBlackListDeleted=================" }
    }

    override fun onFriendApplicationListAccept(u: UserInfo?) {
        logD { "=========onFriendApplicationListAccept===============" }
    }

    override fun onFriendApplicationListAdded(u: UserInfo?) {
        logD { "==========onFriendApplicationListAdded==============" }
    }

    override fun onFriendApplicationListDeleted(u: UserInfo?) {
        logD { "======onFriendApplicationListDeleted==================" }
    }

    override fun onFriendApplicationListReject(u: UserInfo?) {
        logD { "=======onFriendApplicationListReject=================" }
    }

    override fun onFriendInfoChanged(u: UserInfo?) {
        logD { "=====onFriendInfoChanged===================" }
    }

    override fun onFriendListAdded(u: UserInfo?) {
        logD { "========onFriendListAdded================" }
    }

    override fun onFriendListDeleted(u: UserInfo?) {
        logD { "========onFriendListDeleted================" }
    }

    /* OnGroupListener */

    override fun onMemberEnter(groupId: String?, list: MutableList<GroupMembersInfo>?) {
        logD { "========onMemberEnter================" }
    }

    override fun onMemberLeave(groupId: String?, info: GroupMembersInfo?) {
        logD { "=========onMemberLeave===============" }
    }

    override fun onMemberInvited(
        groupId: String?,
        opUser: GroupMembersInfo?,
        list: MutableList<GroupMembersInfo>?
    ) {
        logD { "=========onMemberInvited===============" }
    }

    override fun onMemberKicked(
        groupId: String?,
        opUser: GroupMembersInfo?,
        list: MutableList<GroupMembersInfo>?
    ) {
        logD { "=========onMemberKicked===============" }
    }

    override fun onGroupCreated(groupId: String?) {
        logD { "==========onGroupCreated==============" }
    }

    override fun onGroupInfoChanged(groupId: String?, info: GroupInfo?) {
        logD { "===========onGroupInfoChanged=============" }
    }

    override fun onReceiveJoinApplication(
        groupId: String?,
        info: GroupMembersInfo?,
        opReason: String?
    ) {
        logD { "===========onReceiveJoinApplication=============" }
    }

    override fun onApplicationProcessed(
        groupId: String?,
        opUser: GroupMembersInfo?,
        agreeOrReject: Int,
        opReason: String?
    ) {
        logD { "============onApplicationProcessed============" }
    }

    fun onGetConversation(view: View?) {
        OpenIMClient.getInstance().conversationManager.getAllConversationList(
            object : OnBase<List<ConversationInfo?>?> {
                override fun onError(code: Long, error: String) {}

                override fun onSuccess(data: List<ConversationInfo?>?) {
                    logI { "onGetConversation: ${JsonUtil.toString(data)}" }
                }
            }
        )
    }

    fun onLogin(view: View?) {
        Credential(
            "13918588195",
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVSUQiOiIxMzkxODU4ODE5NSIsIlBsYXRmb3JtIjoiQW5kcm9pZCIsImV4cCI6MTYzNDM3ODE3MSwiaWF0IjoxNjMzNzczMzcxLCJuYmYiOjE2MzM3NzMzNzF9.d6vAIBlbOF2r7Ouz2Opl6GvroDpHkGCp-QNxm5cKiFU"
        ).also {
            OpenIMClient.getInstance().login(it, object : OnBase<String?> {
                override fun onError(code: Long, error: String) {
                    logE { "login err: $code - $error" }
                }

                override fun onSuccess(data: String?) {
                    logI { "登录成功!" }
                }
            })
        }
    }

    fun onGetMessageHistory(view: View?) {
        OpenIMClient.getInstance().messageManager.getHistoryMessageList(
            "0b55c23c7fac2b34",
            "",
            null,
            20,
            object : OnBase<List<Message?>> {
                override fun onError(code: Long, error: String) {
                    logE { "getHistoryMessageList error: $code - $error" }
                }

                override fun onSuccess(data: List<Message?>) {
                    logI { "消息数：${data.size}" }
                }
            })
    }
}
