package io.openim.android.sdk.manager;


import androidx.collection.ArrayMap;

import java.util.List;
import java.util.Map;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnFriendshipListener;
import io.openim.android.sdk.listener._FriendshipListener;
import io.openim.android.sdk.models.FriendApplicationInfo;
import io.openim.android.sdk.models.FriendInfo;
import io.openim.android.sdk.models.FriendshipInfo;
import io.openim.android.sdk.models.UserInfo;
import io.openim.android.sdk.utils.JsonUtil;
import io.openim.android.sdk.utils.ParamsUtil;
import open_im_sdk.Open_im_sdk;

/**
 * 好友关系管理器
 */
public class FriendshipManager {
    /**
     * 设置好友关系监听器
     **/
    public void setOnFriendshipListener(OnFriendshipListener listener) {
        Open_im_sdk.setFriendListener(new _FriendshipListener(listener));
    }

    /**
     * 根据用户id，批量查询好友资料
     *
     * @param uidList 好友id集合
     * @param base    callback List<{@link UserInfo}>
     */
    public void getFriendsInfo(OnBase<List<UserInfo>> base, List<String> uidList) {
        Open_im_sdk.getDesignatedFriendsInfo(BaseImpl.arrayBase(base, UserInfo.class), ParamsUtil.buildOperationID(), JsonUtil.toString(uidList));
    }

    /**
     * 发送好友申请
     *
     * @param uid        对方userID
     * @param reqMessage 请求消息
     * @param base       callback String
     */
    public void addFriend(OnBase<String> base, String uid, String reqMessage) {
        Map<String, Object> params = new ArrayMap<>();
        params.put("toUserID", uid);
        params.put("reqMsg", reqMessage);
        Open_im_sdk.addFriend(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), JsonUtil.toString(params));
    }

    /**
     * 收到好友申请列表
     *
     * @param base callback List<{@link UserInfo}>
     */
    public void getRecvFriendApplicationList(OnBase<List<FriendApplicationInfo>> base) {
        Open_im_sdk.getRecvFriendApplicationList(BaseImpl.arrayBase(base, FriendApplicationInfo.class), ParamsUtil.buildOperationID());
    }

    /**
     * 发出好友申请列表
     *
     * @param base callback List<{@link UserInfo}>
     */
    public void getSendFriendApplicationList(OnBase<List<FriendApplicationInfo>> base) {
        Open_im_sdk.getSendFriendApplicationList(BaseImpl.arrayBase(base, FriendApplicationInfo.class), ParamsUtil.buildOperationID());
    }

    /**
     * 好友列表
     * 返回的好友里包含了已拉入黑名单的好友
     * 需要根据字段isInBlackList做筛选，isInBlackList==1 已拉入黑名单
     *
     * @param base callback List<{@link UserInfo}>
     */
    public void getFriendList(OnBase<List<UserInfo>> base) {
        Open_im_sdk.getFriendList(BaseImpl.arrayBase(base, UserInfo.class), ParamsUtil.buildOperationID());
    }


    /**
     * 修改好友资料
     *
     * @param uid    用户id
     * @param remark 备注名
     * @param base   callback String
     */
    public void setFriendRemark(OnBase<String> base, String uid, String remark) {
        Map<String, Object> params = new ArrayMap<>();
        params.put("toUserID", uid);
        params.put("remark", remark);
        Open_im_sdk.setFriendRemark(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), JsonUtil.toString(params));
    }

    /**
     * 加入黑名单
     *
     * @param uid  用户ID
     * @param base callback String
     */
    public void addBlacklist(OnBase<String> base, String uid) {
        Open_im_sdk.addBlack(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), uid);
    }

    /**
     * 黑名单
     *
     * @param base callback List<{@link UserInfo}>
     */
    public void getBlacklist(OnBase<List<UserInfo>> base) {
        Open_im_sdk.getBlackList(BaseImpl.arrayBase(base, UserInfo.class), ParamsUtil.buildOperationID());
    }

    /**
     * 从黑名单删除
     *
     * @param uid  用户ID
     * @param base callback String
     */
    public void removeBlacklist(OnBase<String> base, String uid) {
        Open_im_sdk.removeBlack(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), uid);
    }

    /**
     * 根据用户id检查好友关系
     *
     * @param uidList 用户ID列表
     * @param base    callback List<{@link UserInfo}>
     */
    public void checkFriend(OnBase<List<FriendshipInfo>> base, List<String> uidList) {
        Open_im_sdk.checkFriend(BaseImpl.arrayBase(base, FriendshipInfo.class), ParamsUtil.buildOperationID(), JsonUtil.toString(uidList));
    }

    /**
     * 删除好友
     *
     * @param uid  用户ID
     * @param base callback String
     */
    public void deleteFriend(OnBase<String> base, String uid) {
        Open_im_sdk.deleteFriend(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), uid);
    }

    /**
     * 拒绝好友申请
     *
     * @param uid       用户ID
     * @param handleMsg 处理信息
     * @param base      callback String
     */
    public void refuseFriendApplication(OnBase<String> base, String uid, String handleMsg) {
        Map<String, Object> params = new ArrayMap<>();
        params.put("toUserID", uid);
        params.put("handleMsg", handleMsg);
        Open_im_sdk.refuseFriendApplication(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), JsonUtil.toString(params));
    }

    /**
     * 接受好友请求
     *
     * @param uid       用户ID
     * @param handleMsg 处理信息
     * @param base      callback String
     */
    public void acceptFriendApplication(OnBase<String> base, String uid, String handleMsg) {
        Map<String, Object> params = new ArrayMap<>();
        params.put("toUserID", uid);
        params.put("handleMsg", handleMsg);
        Open_im_sdk.acceptFriendApplication(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), JsonUtil.toString(params));
    }

    /**
     * 搜索好友
     *
     * @param keywordList      搜索关键词，目前仅支持一个关键词搜索，不能为空
     * @param isSearchUserID   是否以关键词搜索好友ID(注：不可以同时为false)，为空默认false
     * @param isSearchNickname 是否以关键词搜索昵称，为空默认false
     * @param isSearchRemark   是否以关键词搜索备注名，为空默认false
     */
    public void searchFriends(OnBase<List<FriendInfo>> base, List<String> keywordList, boolean isSearchUserID, boolean isSearchNickname, boolean isSearchRemark) {
        Map<String, Object> params = new ArrayMap<>();
        params.put("keywordList", keywordList);
        params.put("isSearchUserID", isSearchUserID);
        params.put("isSearchNickname", isSearchNickname);
        params.put("isSearchRemark", isSearchRemark);
        Open_im_sdk.searchFriends(BaseImpl.arrayBase(base, FriendInfo.class), ParamsUtil.buildOperationID(), JsonUtil.toString(params));
    }
}
