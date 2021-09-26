package io.openim.android.sdk.manager;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnFriendshipListener;
import io.openim.android.sdk.models.UserInfo;
import io.openim.android.sdk.util.CommonUtil;
import io.openim.android.sdk.util.JsonUtil;
import open_im_sdk.Open_im_sdk;

/**
 * 好友关系管理器
 */
public class FriendshipManager {
    /**
     * 设置好友关系监听器
     * <p>
     * 好友被拉入黑名单回调onBlackListAdd
     * 好友从黑名单移除回调onBlackListDeleted
     * 发起的好友请求被接受时回调onFriendApplicationListAccept
     * 我接受别人的发起的好友请求时回调onFriendApplicationListAdded
     * 删除好友请求时回调onFriendApplicationListAdded
     * 请求被拒绝回调onFriendApplicationListReject
     * 好友资料发生变化时回调onFriendInfoChanged
     * 已添加好友回调onFriendListAdded
     * 好友被删除时回调onFriendListDeleted
     **/
    public void setOnFriendshipListener(OnFriendshipListener listener) {
        Open_im_sdk.setFriendListener(new open_im_sdk.OnFriendshipListener() {
            @Override
            public void onBlackListAdd(String s) {
                if (null != listener) {
                    UserInfo u = JsonUtil.toObj(s, UserInfo.class);
                    CommonUtil.runMainThread(() -> listener.onBlackListAdd(u));
                }
            }

            @Override
            public void onBlackListDeleted(String s) {
                if (null != listener) {
                    UserInfo u = JsonUtil.toObj(s, UserInfo.class);
                    CommonUtil.runMainThread(() -> listener.onBlackListDeleted(u));
                }
            }

            @Override
            public void onFriendApplicationListAccept(String s) {
                if (null != listener) {
                    UserInfo u = JsonUtil.toObj(s, UserInfo.class);
                    CommonUtil.runMainThread(() -> listener.onFriendApplicationListAccept(u));
                }
            }

            @Override
            public void onFriendApplicationListAdded(String s) {
                if (null != listener) {
                    UserInfo u = JsonUtil.toObj(s, UserInfo.class);
                    CommonUtil.runMainThread(() -> listener.onFriendApplicationListAdded(u));
                }
            }

            @Override
            public void onFriendApplicationListDeleted(String s) {
                if (null != listener) {
                    UserInfo u = JsonUtil.toObj(s, UserInfo.class);
                    CommonUtil.runMainThread(() -> listener.onFriendApplicationListDeleted(u));
                }
            }

            @Override
            public void onFriendApplicationListReject(String s) {
                if (null != listener) {
                    UserInfo u = JsonUtil.toObj(s, UserInfo.class);
                    CommonUtil.runMainThread(() -> listener.onFriendApplicationListReject(u));
                }
            }

            @Override
            public void onFriendInfoChanged(String s) {
                if (null != listener) {
                    UserInfo u = JsonUtil.toObj(s, UserInfo.class);
                    CommonUtil.runMainThread(() -> listener.onFriendInfoChanged(u));
                }
            }

            @Override
            public void onFriendListAdded(String s) {
                if (null != listener) {
                    UserInfo u = JsonUtil.toObj(s, UserInfo.class);
                    CommonUtil.runMainThread(() -> listener.onFriendListAdded(u));
                }
            }

            @Override
            public void onFriendListDeleted(String s) {
                if (null != listener) {
                    UserInfo u = JsonUtil.toObj(s, UserInfo.class);
                    CommonUtil.runMainThread(() -> listener.onFriendListDeleted(u));
                }
            }
        });
    }

    /**
     * 好友列表
     * 返回的好友里包含了已拉入黑名单的好友
     * 需要根据字段isInBlackList做筛选，isInBlackList==1 已拉入黑名单
     *
     * @param base callback List<{@link UserInfo}>
     */
    public void getFriendList(OnBase<List<UserInfo>> base) {
        Open_im_sdk.getFriendList(BaseImpl.arrayBase(base, UserInfo.class));
    }

    /**
     * 好友申请列表
     *
     * @param base callback List<{@link UserInfo}>
     */
    public void getFriendApplicationList(OnBase<List<UserInfo>> base) {
        Open_im_sdk.getFriendApplicationList(BaseImpl.arrayBase(base, UserInfo.class));
    }

    /**
     * 添加朋友
     *
     * @param uid    对方userID
     * @param reason 请求消息
     * @param base   callback String
     */
    public void addFriend(OnBase<String> base, String uid, String reason) {
        Map<String, Object> params = new HashMap<>();
        params.put("uid", uid);
        params.put("reqMessage", reason);
        Open_im_sdk.addFriend(BaseImpl.stringBase(base), JsonUtil.toString(params));
    }

    /**
     * 根据用户id，批量查询好友资料
     *
     * @param uidList 好友id集合
     * @param base    callback List<{@link UserInfo}>
     */
    public void getFriendsInfo(OnBase<List<UserInfo>> base, List<String> uidList) {
        Open_im_sdk.getFriendsInfo(BaseImpl.arrayBase(base, UserInfo.class), JsonUtil.toString(uidList));
    }

    /**
     * 修改好友资料
     *
     * @param uid     用户id
     * @param comment 备注
     * @param base    callback String
     */
    public void setFriendInfo(OnBase<String> base, String uid, String comment) {
        Map<String, Object> params = new HashMap<>();
        params.put("uid", uid);
        params.put("comment", comment);
        Open_im_sdk.setFriendInfo(JsonUtil.toString(params), BaseImpl.stringBase(base));
    }

    /**
     * 拒绝好友申请
     *
     * @param uid  用户ID
     * @param base callback String
     */
    public void refuseFriendApplication(OnBase<String> base, String uid) {
        Open_im_sdk.refuseFriendApplication(BaseImpl.stringBase(base), JsonUtil.toString(uid));
    }

    /**
     * 接受好友请求
     *
     * @param uid  用户ID
     * @param base callback String
     */
    public void acceptFriendApplication(OnBase<String> base, String uid) {
        Open_im_sdk.acceptFriendApplication(BaseImpl.stringBase(base), JsonUtil.toString(uid));
    }

    /**
     * 删除好友
     *
     * @param uid  用户ID
     * @param base callback String
     */
    public void deleteFromFriendList(OnBase<String> base, String uid) {
        Open_im_sdk.deleteFromFriendList(JsonUtil.toString(uid), BaseImpl.stringBase(base));
    }

    /**
     * 根据用户id检查好友关系
     * flag == 1 是好友
     *
     * @param uidList 用户ID列表
     * @param base    callback List<{@link UserInfo}>
     */
    public void checkFriend(OnBase<List<UserInfo>> base, List<String> uidList) {
        Open_im_sdk.checkFriend(BaseImpl.arrayBase(base, UserInfo.class), JsonUtil.toString(uidList));
    }

    /**
     * 从黑名单删除
     *
     * @param uid  用户ID
     * @param base callback String
     */
    public void deleteFromBlackList(OnBase<String> base, String uid) {
        Open_im_sdk.deleteFromBlackList(BaseImpl.stringBase(base), JsonUtil.toString(uid));
    }

    /**
     * 黑名单
     *
     * @param base callback List<{@link UserInfo}>
     */
    public void getBlackList(OnBase<List<UserInfo>> base) {
        Open_im_sdk.getBlackList(BaseImpl.arrayBase(base, UserInfo.class));
    }

    /**
     * 加入黑名单
     *
     * @param uid  用户ID
     * @param base callback String
     */
    public void addToBlackList(OnBase<String> base, String uid) {
        Open_im_sdk.addToBlackList(BaseImpl.stringBase(base), JsonUtil.toString(uid));
    }

    public void forceSyncFriend() {
        Open_im_sdk.forceSyncFriend();
    }

    public void forceSyncBlackList() {
        Open_im_sdk.forceSyncBlackList();
    }

    public void forceSyncFriendApplication() {
        Open_im_sdk.forceSyncFriendApplication();
    }
}
