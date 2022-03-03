SDK使用步骤

##### 1，初始化

```
String apiUrl = ""; // SDK的API接口地址。如：http://xxx:10000
String wsUrl = ""; // SDK的Websocket地址。如：ws://xxx:17778
String storageDir = ""; // 数据存储路径。如：context.getCacheDir().getAbsolutePath()
int logLevel = 6; // 日志等级
String objectStorage = "cos"; // 图片上传服务器如 腾讯cos
boolean result = OpenIMClient.getInstance().initSDK(apiUrl, wsUrl, storageDir, logLevel, objectStorage,
    new OnConnListener() {
        @Override
        public void onConnectFailed(long code, String error) {
            // 连接服务器失败，可以提示用户当前网络连接不可用
        }

        @Override
        public void onConnectSuccess() {
            // 已经成功连接到服务器
        }

        @Override
        public void onConnecting() {
            // 正在连接到服务器，适合在 UI 上展示“正在连接”状态。
        }

        @Override
        public void onKickedOffline() {
            // 当前用户被踢下线，此时可以 UI 提示用户“您已经在其他端登录了当前账号，是否重新登录？”
        }

        @Override
        public void onUserTokenExpired() {
            // 登录票据已经过期，请使用新签发的 UserSig 进行登录。
        }
    });
```

##### 2，设置监听器

```
OpenIMClient.getInstance().userInfoManager.setOnUserListener(new OnUserListener() {
    @Override
    public void onSelfInfoUpdated(UserInfo info) {
        // 当前登录用户资料变更回调
    }
});

OpenIMClient.getInstance().messageManager.setAdvancedMsgListener(new OnAdvanceMsgListener() {
    @Override
    public void onRecvNewMessage(Message msg) {
        // 收到新消息，界面添加新消息
    }

    @Override
    public void onRecvC2CReadReceipt(List<ReadReceiptInfo> list) {
        // 消息被阅读回执，将消息标记为已读
    }

    @Override
    public void onRecvMessageRevoked(String msgId) {
        // 消息成功撤回，从界面移除消息
    }
});

OpenIMClient.getInstance().friendshipManager.setOnFriendshipListener(new OnFriendshipListener() {
    @Override
    public void onBlacklistAdded(BlacklistInfo u) {
        // 拉入黑名单
    }

    @Override
    public void onBlacklistDeleted(BlacklistInfo u) {
        // 从黑名单删除
    }

    @Override
    public void onFriendApplicationAccepted(FriendApplicationInfo u) {
        // 发出或收到的好友申请已同意
    }

    @Override
    public void onFriendApplicationAdded(FriendApplicationInfo u) {
        // 发出或收到的好友申请被添加
    }

    @Override
    public void onFriendApplicationDeleted(FriendApplicationInfo u) {
        // 发出或收到的好友申请被删除
    }

    @Override
    public void onFriendApplicationRejected(FriendApplicationInfo u) {
        // 发出或收到的好友申请被拒绝
    }

    @Override
    public void onFriendInfoChanged(FriendInfo u) {
        // 朋友的资料发生变化
    }

    @Override
    public void onFriendAdded(FriendInfo u) {
        // 好友被添加
    }

    @Override
    public void onFriendDeleted(FriendInfo u) {
        // 好友被删除
    }
});

OpenIMClient.getInstance().conversationManager.setOnConversationListener(new OnConversationListener() {
    @Override
    public void onConversationChanged(List<ConversationInfo> list) {
        // 已添加的会话发送改变
    }

    @Override
    public void onNewConversation(List<ConversationInfo> list) {
        // 新增会话
    }

    @Override
    public void onSyncServerFailed() {

    }

    @Override
    public void onSyncServerFinish() {

    }

    @Override
    public void onSyncServerStart() {

    }

    @Override
    public void onTotalUnreadMessageCountChanged(int i) {
        // 未读消息数发送变化
    }
});

OpenIMClient.getInstance().groupManager.setOnGroupListener(new OnGroupListener() {
    @Override
    public void onGroupApplicationAccepted(GroupApplicationInfo info) {
        // 发出或收到的组申请被接受
    }

    @Override
    public void onGroupApplicationAdded(GroupApplicationInfo info) {
        // 发出或收到的组申请有新增
    }

    @Override
    public void onGroupApplicationDeleted(GroupApplicationInfo info) {
        // 发出或收到的组申请被删除
    }

    @Override
    public void onGroupApplicationRejected(GroupApplicationInfo info) {
        // 发出或收到的组申请被拒绝
    }

    @Override
    public void onGroupInfoChanged(GroupInfo info) {
        // 组资料变更
    }

    @Override
    public void onGroupMemberAdded(GroupMembersInfo info) {
        // 组成员进入
    }

    @Override
    public void onGroupMemberDeleted(GroupMembersInfo info) {
        // 组成员退出
    }

    @Override
    public void onGroupMemberInfoChanged(GroupMembersInfo info) {
        // 组成员信息发生变化
    }

    @Override
    public void onJoinedGroupAdded(GroupInfo info) {
        // 创建群： 初始成员收到；邀请进群：被邀请者收到
    }

    @Override
    public void onJoinedGroupDeleted(GroupInfo info) {
        // 退出群：退出者收到；踢出群：被踢者收到
    }
});
```

##### 3，登录

```
String uid = ""; // uid来自于自身业务服务器
String token = ""; // token需要业务服务器根据secret向OpenIM服务端交换获取
OpenIMClient.getInstance().login(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, uid, token);
```



## 方法名、参数、返回值说明

- ##### logout（ 登出）

```
OpenIMClient.getInstance().logout(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {
        
    }

    @Override
    public void onSuccess(String data) {

    }
});
```

- ##### getUsersInfo（根据用户ID批量获取用户信息）

```
List<String> uidList = new ArrayList<>(); // 用户ID集合
OpenIMClient.getInstance().userInfoManager.getUsersInfo(new OnBase<List<UserInfo>>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(List<UserInfo> data) {

    }
}, uidList);
```

- ##### getSelfUserInfo（获取当前登录用户的资料）

```
OpenIMClient.getInstance().userInfoManager.getSelfUserInfo(new OnBase<UserInfo>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(UserInfo data) {
        // 返回当前登录用户的资料
    }
});
```

- ##### setSelfInfo（修改当前用登录户资料）

会触发当用户的onSelfInfoUpdated回调，以及好友的onFriendInfoChanged、onConversationChanged回调。

```
String nickname = ""; // 用户昵称
String faceURL = ""; // 用户头像 
int gender = 0; // 性别：1男，0女
int appMangerLevel = 1;
String phoneNumber = ""; // 手机号
long birth = 0L; // 出生日期
String email = ""; //邮箱
String ex = ""; // 额外信息
OpenIMClient.getInstance().userInfoManager.setSelfInfo(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, nickname, faceURL, gender, appMangerLevel, phoneNumber, birth, email, ex);
```

- ##### getAllConversationList（获取所有会话）

```
OpenIMClient.getInstance().conversationManager.getAllConversationList(new OnBase<List<ConversationInfo>>() {
    @Override
    public void onError(int code, String error) {
        
    }

    @Override
    public void onSuccess(List<ConversationInfo> data) {

    }
});
```

- ##### getConversationListSplit（分页获取会话）

```
long offset = 0; // 偏移量，如：第1页，offset：0，count：20；第2页：offset：20；
long count = 0; // 每页数量
OpenIMClient.getInstance().conversationManager.getConversationListSplit(new OnBase<List<ConversationInfo>>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(List<ConversationInfo> data) {

    }
}, count, offset);
```

- ##### getOneConversation（获取一个会话，如果不存在会自动创建）

```
String sourceID = ""; // 如果是单聊值传userID，如果是群聊groupID
int sessionType = 1; // 如果是单聊值传1，如果是群聊值传2
OpenIMClient.getInstance().conversationManager.getOneConversation(new OnBase<ConversationInfo>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(ConversationInfo data) {

    }
}, sourceID, sessionType);
```

- ##### getMultipleConversation（根据会话id查询会话）

```
List<String> conversationIDList = new ArrayList<>(); // 会话ID集合
OpenIMClient.getInstance().conversationManager.getMultipleConversation(new OnBase<List<ConversationInfo>>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(List<ConversationInfo> data) {

    }
}, conversationIDList);
```

- ##### deleteConversation（根据会话id删除指定会话)

会触onTotalUnreadMessageCountChanged回调

```
String conversationID = ""; // 会话id
OpenIMClient.getInstance().conversationManager.deleteConversation(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, conversationID);
```

- ##### setConversationDraft（设置会话草稿）

会触onConversationChanged回调

```
String conversationID = ""; // 会话id
String draftText = ""; // 草稿
OpenIMClient.getInstance().conversationManager.setConversationDraft(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, conversationID, draftText);
```

- ##### pinConversation（置顶会话）

会触onConversationChanged回调

```
String conversationID = ""; // 会话id
boolean isPinned = true; // true：置顶；false：取消置顶
OpenIMClient.getInstance().conversationManager.pinConversation(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, conversationID, isPinned);
```

- ##### markGroupMessageHasRead（标记群会话已读，清除未读数）

会触onConversationChanged、onTotalUnreadMessageCountChanged回调

```
String groupID = ""; // 组ID
OpenIMClient.getInstance().conversationManager.markGroupMessageHasRead(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, groupID);
```

- ##### getTotalUnreadMsgCount（获取未读消息总数）

```
OpenIMClient.getInstance().conversationManager.getTotalUnreadMsgCount(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {
        
    }

    @Override
    public void onSuccess(String data) {

    }
});
```

- ##### getConversationIDBySessionType（查询会话id）

```
String sourceID = ""; // 如果是单聊值传userID，如果是群聊groupID
int sessionType = 1; // 如果是单聊值传1，如果是群聊值传2
OpenIMClient.getInstance().conversationManager.getConversationIDBySessionType(sourceID, sessionType);
```

- ##### setConversationRecvMessageOpt（设置免打扰模式）

```
List<String> conversationIDs = new ArrayList<>(); // 会话id列表
long status = 0; // 1：不接受消息；2：接受在线消息不接受离线消息；0：正常
OpenIMClient.getInstance().conversationManager.setConversationRecvMessageOpt(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, conversationIDs, status);
```

- ##### getConversationRecvMessageOpt（查询免打扰状态）

```
List<String> conversationIDs = new ArrayList<>(); // 会话id列表
OpenIMClient.getInstance().conversationManager.getConversationRecvMessageOpt(new OnBase<List<NotDisturbInfo>>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(List<NotDisturbInfo> data) {

    }
}, conversationIDs);
```

- ##### simpleComparator（自定义会话排序规则）

```
OpenIMClient.getInstance().conversationManager.simpleComparator();
```

- ##### getFriendsInfo（根据userID查询好友资料）

```
List<String> uidList = new ArrayList<>(); // userId列表
OpenIMClient.getInstance().friendshipManager.getFriendsInfo(new OnBase<List<UserInfo>>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(List<UserInfo> data) {

    }
}, uidList);
```

- ##### addFriend（发起好友申请）

主动申请者收到OnFriendApplicationAdded

被添加者收到OnFriendApplicationAdded 

```
String uid = ""; // 用户id
String reqMessage = ""; // 发起好友申请的描述信息
OpenIMClient.getInstance().friendshipManager.addFriend(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, uid, reqMessage);
```

- ##### checkFriend（检查是否是好友）

```
List<String> uidList = new ArrayList<>(); // userId列表
OpenIMClient.getInstance().friendshipManager.checkFriend(new OnBase<List<FriendshipInfo>>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(List<FriendshipInfo> data) {

    }
}, uidList);
```

- ##### deleteFriend（删除好友）

操作者收到OnFriendDeleted

```
String uid = ""; // 用户id
OpenIMClient.getInstance().friendshipManager.deleteFriend(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, uid);
```

- ##### setFriendRemark（好友备注设置）

操作者收到OnFriendInfoChanged

```
String uid = ""; // 用户id
String remark = ""; // 备注名
OpenIMClient.getInstance().friendshipManager.setFriendRemark(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, uid, remark);
```

- ##### getFriendList（好友列表）

返回的数据里包含已拉入黑名单的好友，可以根据isBlacklist字段筛选。

```
OpenIMClient.getInstance().friendshipManager.getFriendList(new OnBase<List<UserInfo>>() {
    @Override
    public void onError(int code, String error) {
        
    }

    @Override
    public void onSuccess(List<UserInfo> data) {

    }
});
```

- ##### getRecvFriendApplicationList（收到的好友申请）

```
OpenIMClient.getInstance().friendshipManager.getRecvFriendApplicationList(new 		OnBase<List<FriendApplicationInfo>>() {
    @Override
    public void onError(int code, String error) {
        
    }

    @Override
    public void onSuccess(List<FriendApplicationInfo> data) {

    }
});
```

- ##### getSendFriendApplicationList（发出的好友申请）

```
OpenIMClient.getInstance().friendshipManager.getSendFriendApplicationList(new OnBase<List<FriendApplicationInfo>>() {
    @Override
    public void onError(int code, String error) {
        
    }

    @Override
    public void onSuccess(List<FriendApplicationInfo> data) {

    }
});
```

- ##### addBlacklist（拉黑好友）

操作者收到OnBlackAdded

```
String uid = ""; // 用户id
OpenIMClient.getInstance().friendshipManager.addBlacklist(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, uid);
```

- ##### getBlacklist（黑名单）

```
OpenIMClient.getInstance().friendshipManager.getBlacklist(new OnBase<List<UserInfo>>() {
    @Override
    public void onError(int code, String error) {
        
    }

    @Override
    public void onSuccess(List<UserInfo> data) {

    }
});
```

- ##### removeBlacklist（移除黑名单）

操作者收到OnBlackDeleted

```
String uid = ""; // 用户id
OpenIMClient.getInstance().friendshipManager.removeBlacklist(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, uid);
```

- ##### acceptFriendApplication（接受好友申请）

操作者收到OnFriendApplicationAccepted、OnFriendAdded

申请者收到OnFriendApplicationAccepted、OnFriendAdded

```
String uid = ""; // 用户id
String handleMsg = ""; // 描述信息
OpenIMClient.getInstance().friendshipManager.acceptFriendApplication(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, uid, handleMsg);
```

- ##### refuseFriendApplication（拒绝好友申请）

操作者收到OnFriendApplicationRejected

申请者收到OnFriendApplicationRejected 

```
String uid = ""; // 用户id
String handleMsg = ""; // 描述信息
OpenIMClient.getInstance().friendshipManager.refuseFriendApplication(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, uid, handleMsg);
```

- ##### inviteUserToGroup（邀请进组）

直接进组无需同意。

被邀请者收到OnJoinedGroupAdded

群成员（不包括被邀请者）收到OnGroupMemberAdded 

```
String groupID = ""; // 组ID
List<String> uidList = new ArrayList<>(); // 成员 userID 列表
String reason = ""; // 备注信息
OpenIMClient.getInstance().groupManager.inviteUserToGroup(new OnBase<List<GroupInviteResult>>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(List<GroupInviteResult> data) {

    }
}, groupID, uidList, reason);
```

- ##### kickGroupMember（移除组成员）

被踢者收到OnJoinedGroupDeleted

群成员收到OnGroupMemberDeleted 

```
String groupID = ""; // 组ID
List<String> uidList = new ArrayList<>(); // 成员 userID 列表
String reason = ""; // 备注信息
OpenIMClient.getInstance().groupManager.kickGroupMember(new OnBase<List<GroupInviteResult>>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(List<GroupInviteResult> data) {

    }
}, groupID, uidList, reason);
```

- ##### getGroupMembersInfo（查询组成员信息）

```
String groupID = ""; // 组ID
List<String> uidList = new ArrayList<>(); // 成员 userID 列表
OpenIMClient.getInstance().groupManager.getGroupMembersInfo(new OnBase<List<GroupMembersInfo>>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(List<GroupMembersInfo> data) {

    }
}, groupID, uidList);
```

- ##### getGroupMemberList（组成员列表）

```
String groupID = ""; // 组ID
int filter = 0; // 1普通成员, 2群主，3管理员
int offset = 0; // 偏移量，每次开始的index值
int count = 0; // 每次拉取的数量
OpenIMClient.getInstance().groupManager.getGroupMemberList(new OnBase<GroupMembersInfo>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(GroupMembersInfo data) {

    }
}, groupID, filter, offset, count);
```

- ##### getJoinedGroupList（获取已加入的群组）

```
OpenIMClient.getInstance().groupManager.getJoinedGroupList(new OnBase<List<GroupInfo>>() {
    @Override
    public void onError(int code, String error) {
        
    }

    @Override
    public void onSuccess(List<GroupInfo> data) {

    }
});
```

- ##### createGroup（创建组）

初始成员收到OnJoinedGroupAdded

```
String groupName = ""; // 组名
String faceURL = ""; // 头像
String notification = ""; // 群公告
String introduction = ""; // 群简介
int groupType = 0; // 类型
String ex = ""; // 扩展信息
List<GroupMemberRole> list = new ArrayList<>(); // 成员角色集合
OpenIMClient.getInstance().groupManager.createGroup(new OnBase<GroupInfo>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(GroupInfo data) {

    }
}, groupName, faceURL, notification, introduction, groupType, ex, list);
```

- ##### setGroupInfo（修改组信息）

群成员收到OnGroupInfoChanged

```
String groupID = ""; // 组ID
String groupName = ""; // 组名
String faceURL = ""; // 头像
String notification = ""; // 群公告
String introduction = ""; // 群简介
String ex = ""; // 扩展信息
OpenIMClient.getInstance().groupManager.setGroupInfo(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, groupID, groupName, faceURL, notification, introduction, ex);
```

- ##### getGroupsInfo（根据id查询组信息）

```
List<String> gidList = new ArrayList<>();
OpenIMClient.getInstance().groupManager.getGroupsInfo(new OnBase<List<GroupInfo>>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(List<GroupInfo> data) {

    }
}, gidList);
```

- ##### joinGroup（申请入群组）

需要通过管理员同意。

申请者收到OnGroupApplicationAdded

群主+管理员收到OnGroupApplicationAdded 

```
String groupID = ""; // 组ID
String reason = ""; // 备注信息
OpenIMClient.getInstance().groupManager.joinGroup(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, groupID, reason);
```

- ##### quitGroup（退出组）

退出者收到OnJoinedGroupDeleted

群成员收到OnGroupMemberDeleted

```
String groupID = ""; // 组ID
OpenIMClient.getInstance().groupManager.quitGroup(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, groupID);
```

- ##### transferGroupOwner（群转让）

```
String groupID = ""; // 组ID
String newOwnerUserID = ""; // 新群主ID
OpenIMClient.getInstance().groupManager.transferGroupOwner(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, groupID, newOwnerUserID);
```

- ##### getRecvGroupApplicationList（收到的入群申请）

作为群主或者管理员，获取收到的群成员申请进群列表。

```
OpenIMClient.getInstance().groupManager.getRecvGroupApplicationList(new OnBase<GroupApplicationInfo>() {
    @Override
    public void onError(int code, String error) {
        
    }

    @Override
    public void onSuccess(GroupApplicationInfo data) {

    }
});
```

- ##### getSendGroupApplicationList（发出的入群申请）

```
OpenIMClient.getInstance().groupManager.getSendGroupApplicationList(new OnBase<GroupApplicationInfo>() {
    @Override
    public void onError(int code, String error) {
        
    }

    @Override
    public void onSuccess(GroupApplicationInfo data) {

    }
});
```

- ##### acceptGroupApplication（接受入群申请）

申请者收到OnJoinedGroupAdded  OnGroupApplicationAccepted

群成员（不包括申请者）收到OnGroupMemberAdded

审批者（群主或者管理员）收到OnGroupMemberAdded OnGroupApplicationAccepted

```
String groupID = ""; // 组ID
String uid = ""; // 申请人userID
String handleMsg = ""; //备注信息
OpenIMClient.getInstance().groupManager.acceptGroupApplication(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, groupID, uid, handleMsg);
```

- ##### refuseGroupApplication（拒绝入群申请）

申请者收到OnGroupApplicationRejected

审批者（群主或者管理员）收到OnGroupApplicationRejected 

```
String groupID = ""; // 组ID
String uid = ""; // 申请人userID
String handleMsg = ""; //备注信息
OpenIMClient.getInstance().groupManager.refuseGroupApplication(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, groupID, uid, handleMsg);
```

- ##### sendMessage（发送消息）

```
Message message = null; // 消息体；不为null，来自创建消息体方法的返回值
String userID = ""; // 接受消息的userID
String groupID = ""; // 接受消息的群ID
OfflinePushInfo offlinePushInfo = new OfflinePushInfo();  // 离线推送的消息备注；不为null
OpenIMClient.getInstance().messageManager.sendMessage(new OnMsgSendCallback() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onProgress(long progress) {
				 // 返回新的消息体，替换发送传入的，不然扯回消息会有bug
    }

    @Override
    public void onSuccess(Message message) {
 				// 返回新的消息体；替换发送传入的，不然扯回消息会有bug
    }
}, message, userID, groupID, offlinePushInfo);
```

- ##### getHistoryMessageList（获取聊天记录）

```
Message startMsg = null; // 消息体，取界面上显示的消息体对象
String userID = ""; // 接受消息的userID
String groupID = ""; // 接受消息的群ID
int count = 20; //  // 每次拉取的数量
OpenIMClient.getInstance().messageManager.getHistoryMessageList(new OnBase<List<Message>>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(List<Message> data) {

    }
}, userID, groupID, startMsg, count);
```

注：消息列表list，index == list.length -1 是最新的一条消息。 index == 0 是从最新的这条记录后的第19条。所以startMsg首次传null，

下次就是index == 0，以此类推。

- ##### revokeMessage（撤回消息）

撤回成功需要当前用户从列表里移除Message然后更新ui，而另外一方通过撤回监听（onRecvMessageRevoked）移除。

```
Message message = null; // 消息体，不为null，取界面上显示的消息体对象
OpenIMClient.getInstance().messageManager.revokeMessage(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, message);
```

- ##### deleteMessageFromLocalStorage（删除单条消息）

```
Message message = null; // 消息体，不为null，取界面上显示的消息体对象
OpenIMClient.getInstance().messageManager.deleteMessageFromLocalStorage(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, message);
```

- ##### insertSingleMessageToLocalStorage（向本地插入一条消息）

```
String receiverID = "";// 接收者 userID
String senderID = ""; // 发送中 userID
Message message = null; // 不为null，来自创建消息体方法的返回值
OpenIMClient.getInstance().messageManager.insertSingleMessageToLocalStorage(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, message, receiverID, senderID);
```

- ##### markC2CMessageAsRead（标记c2c消息已读）

当调用此方法后，已读的消息会通过已读回执（onRecvC2CReadReceipt）告诉对方。

```
String userID = ""; // 接收者 userID
List<String> messageIDList = new ArrayList<>(); // 已读的消息id列表
OpenIMClient.getInstance().messageManager.markC2CMessageAsRead(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, userID, messageIDList);
```

- ##### typingStatusUpdate（正在输入提示）

会通过onRecvNewMessage回调

```
String userID = ""; // 接收者 userID
String msgTip = ""; // 自定义提示内容
OpenIMClient.getInstance().messageManager.typingStatusUpdate(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, userID, msgTip);
```

- ##### clearC2CHistoryMessage（清空c2c聊天记录）

```
String userID = ""; // 接收者 userID
OpenIMClient.getInstance().messageManager.clearC2CHistoryMessage(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, userID);
```

- ##### clearGroupHistoryMessage（清空群聊天记录）

```
String groupID = ""; // 组ID
OpenIMClient.getInstance().messageManager.clearGroupHistoryMessage(new OnBase<String>() {
    @Override
    public void onError(int code, String error) {

    }

    @Override
    public void onSuccess(String data) {

    }
}, groupID);
```

- ##### createTextMessage（文本消息）

```
String text = ""; // 发送的内容
Message message = OpenIMClient.getInstance().messageManager.createTextMessage(text);
```

- ##### createTextAtMessage（@消息）

```
String text = ""; // 发送的内容
List<String> atUidList = new ArrayList<>(); // 被@的用户id列表
Message message = OpenIMClient.getInstance().messageManager.createTextAtMessage(text, atUidList);
```

- ##### createImageMessage（图片消息，相对路径）

```
String imagePath = ""; // 图片路径
Message message = OpenIMClient.getInstance().messageManager.createImageMessage(imagePath);
```

注：initSDK时传入了数据缓存（dataDir）路径，如路径：A，这时需要你将图片复制到A路径下后，如 A/pic/a.png路径，imagePath的值：“/pic/a.png”。同以下其他消息的相对路径。

- ##### createImageMessageFromFullPath（图片消息全路径）

```
String imagePath = ""; // 图片路径
Message message = OpenIMClient.getInstance().messageManager.createImageMessageFromFullPath(imagePath);
```

- ##### createSoundMessage（语音消息，相对路径）

```
String soundPath = ""; // 路径
long duration = 0; // 时长s
Message message = OpenIMClient.getInstance().messageManager.createSoundMessage(soundPath, duration);
```

- ##### createSoundMessageFromFullPath（语音消息全路径）

```
String soundPath = ""; // 路径
long duration = 0; // 时长s
Message message = OpenIMClient.getInstance().messageManager.createSoundMessage(soundPath, duration);
```

- ##### createVideoMessage（视频消息，相对路径）

```
String videoPath = ""; // 路径
String videoType = ""; // minetype
String snapshotPath = ""; // 站位缩略图
long duration = 0; // 时长s
Message message = OpenIMClient.getInstance().messageManager.createVideoMessage(videoPath, videoType, duration, snapshotPath);
```

- ##### createVideoMessageFromFullPath（视频消息全路径）

```
String videoPath = ""; // 路径
String videoType = ""; // minetype
String snapshotPath = ""; // 站位缩略图
long duration = 0; // 时长s
Message message = OpenIMClient.getInstance().messageManager.createVideoMessage(videoPath, videoType, duration, snapshotPath);
```

- ##### createFileMessage（文件消息，相对路径）

```
String fileName = ""; // 文件名
String filePath = ""; // 路径
Message message = OpenIMClient.getInstance().messageManager.createFileMessage(filePath, fileName);
```

- ##### createFileMessageFromFullPath（文件消息全路径）

```
String fileName = ""; // 文件名
String filePath = ""; // 路径
Message message = OpenIMClient.getInstance().messageManager.createFileMessageFromFullPath(filePath, fileName);
```

- ##### createForwardMessage（转发消息）

```
Message message = null; // 消息体，不为null，取界面上显示的消息体对象
Message message1 = OpenIMClient.getInstance().messageManager.createForwardMessage(message);
```

- ##### createMergerMessage（合并消息）

```
List<Message> messageList = new ArrayList<>(); // 消息列表
String title = ""; // 标题
List<String> summaryList = new ArrayList<>(); // 每条消息的摘要
Message message = OpenIMClient.getInstance().messageManager.createMergerMessage(messageList, title, summaryList);
```

- ##### createLocationMessage（位置消息）

```
long latitude = 0;// 纬度
long longitude = 0; // 经度
String description = ""; // 位置描述信息
Message message = OpenIMClient.getInstance().messageManager.createLocationMessage(latitude, longitude, description);
```

- ##### createCustomMessage（自定义消息）

```
String data = "";// 自定义内容
String extension = ""; // 扩展信息
String description = "";// 描述消息
Message message = OpenIMClient.getInstance().messageManager.createCustomMessage(data, extension, description);
```

- ##### createQuoteMessage（引用消息/消息回复）

```
String text = ""; // 回复内容
Message quoteMsg = null;// 不为null；被回复的消息体
Message message = OpenIMClient.getInstance().messageManager.createQuoteMessage(text,quoteMsg);
```

- ##### createCardMessage（名片消息）

```
String content = ""; // 自定义内容
Message message = OpenIMClient.getInstance().messageManager.createCardMessage(content);
```
