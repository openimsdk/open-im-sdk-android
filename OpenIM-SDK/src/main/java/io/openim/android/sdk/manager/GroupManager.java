package io.openim.android.sdk.manager;


import android.util.ArrayMap;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnGroupListener;
import io.openim.android.sdk.listener._GroupListener;
import io.openim.android.sdk.models.GroupApplicationInfo;
import io.openim.android.sdk.models.GroupInfo;
import io.openim.android.sdk.models.GroupInfoReq;
import io.openim.android.sdk.models.GroupInviteResult;
import io.openim.android.sdk.models.GroupMembersInfo;
import io.openim.android.sdk.models.GroupMemberInfoReq;
import io.openim.android.sdk.models.SetGroupMemberInfo;
import io.openim.android.sdk.utils.JsonUtil;
import io.openim.android.sdk.utils.ParamsUtil;
import open_im_sdk.Open_im_sdk;

/**
 * 群组管理器
 */
public class GroupManager {
    /**
     * 设置组监听器
     */
    public void setOnGroupListener(OnGroupListener listener) {
        Open_im_sdk.setGroupListener(new _GroupListener(listener));
    }

    /**
     * 邀请进群
     *
     * @param groupId 群组ID
     * @param uidList 被邀请的用户id列表
     * @param reason  邀请说明
     * @param base    callback List<{@link GroupInviteResult}>>
     */
    public void inviteUserToGroup(OnBase<String> base, String groupId, List<String> uidList, String reason) {
        Open_im_sdk.inviteUserToGroup(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), groupId, reason, JsonUtil.toString(uidList));
    }

    /**
     * 踢出群
     *
     * @param groupId 群组ID
     * @param uidList 被踢出群的用户id列表
     * @param reason  说明
     * @param base    callback List<{@link GroupInviteResult}>>
     */
    public void kickGroupMember(OnBase<String> base, String groupId, List<String> uidList, String reason) {
        Open_im_sdk.kickGroupMember(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), groupId, reason, JsonUtil.toString(uidList));
    }


    /**
     * 批量获取群成员信息
     *
     * @param groupId 群组ID
     * @param uidList 群成员ID集合
     * @param base    callback List<{@link GroupMembersInfo}>
     **/
    public void getGroupMembersInfo(OnBase<List<GroupMembersInfo>> base, String groupId, List<String> uidList) {
        Open_im_sdk.getSpecifiedGroupMembersInfo(BaseImpl.arrayBase(base, GroupMembersInfo.class), ParamsUtil.buildOperationID(), groupId,
            JsonUtil.toString(uidList));
    }

    /**
     * 获取群成员
     *
     * @param groupId 群组ID
     * @param filter  过滤成员 1普通成员, 2群主，3管理员，0所有
     * @param offset  偏移量
     * @param count   每页数量
     */
    public void getGroupMemberList(OnBase<List<GroupMembersInfo>> base, String groupId, int filter, int offset, int count) {
        Open_im_sdk.getGroupMemberList(BaseImpl.arrayBase(base, GroupMembersInfo.class), ParamsUtil.buildOperationID(), groupId, filter, offset, count);
    }

    /**
     * 通过群ID获取
     *
     * @param groupID          组ID号
     * @param userIdList  用户id列表
     */
    public void getUsersInGroup(OnBase<List<String>> base, String groupID, List<String> userIdList) {
        Open_im_sdk.getUsersInGroup(BaseImpl.arrayBase(base, String.class), ParamsUtil.buildOperationID(), groupID, JsonUtil.toString(userIdList));
    }

    /**
     * 获取已加入的群列表
     *
     * @param base callback List<{@link GroupInfo}></>
     */
    public void getJoinedGroupList(OnBase<List<GroupInfo>> base) {
        Open_im_sdk.getJoinedGroupList(BaseImpl.arrayBase(base, GroupInfo.class), ParamsUtil.buildOperationID());
    }

    /**
     * 分批获取已加入的群列表
     *
     * @param base callback List<{@link GroupInfo}></>
     * @param offset 每一批的偏移
     * @param count 一批的最大数量
     */
    public void getJoinedGroupListPage(OnBase<List<GroupInfo>> base, int offset, int count) {
        Open_im_sdk.getJoinedGroupListPage(BaseImpl.arrayBase(base, GroupInfo.class), ParamsUtil.buildOperationID(), offset, count);
    }

    /**
     * 创建群
     *
     * @param memberUserIDs 初始化群成员ID列表
     * @param adminUserIDs  管理用户用户ID列表
     * @param groupInfo     List<{@link GroupInfo}>
     * @param ownerUserID   群主ID
     */
    public void createGroup(List<String> memberUserIDs, List<String> adminUserIDs, GroupInfo groupInfo, String ownerUserID, OnBase<GroupInfo> callBack) {
        Map<String, Object> map = new ArrayMap<>();
        map.put("memberUserIDs", memberUserIDs);
        map.put("groupInfo", groupInfo);
        map.put("adminUserIDs", adminUserIDs);
        map.put("ownerUserID", ownerUserID);

        Open_im_sdk.createGroup(BaseImpl.objectBase(callBack, GroupInfo.class), ParamsUtil.buildOperationID(), JsonUtil.toString(map));
    }

    /**
     * 设置或更新群资料
     * <p>
     * * @param groupID      群ID
     * * @param groupName    群名称
     * * @param faceURL      群icon
     * * @param notification 群公告
     * * @param introduction 群简介
     * * @param ex           其他信息
     */
    public void setGroupInfo(GroupInfo groupInfo, OnBase<String> callBack) {
        Open_im_sdk.setGroupInfo(BaseImpl.stringBase(callBack), ParamsUtil.buildOperationID(), JsonUtil.toString(groupInfo));
    }

    /**
     * 批量获取群资料
     *
     * @param gidList 群ID集合
     * @param base    callback List<{@link GroupInfo}>
     */
    public void getGroupsInfo(OnBase<List<GroupInfo>> base, List<String> gidList) {
        Open_im_sdk.getSpecifiedGroupsInfo(BaseImpl.arrayBase(base, GroupInfo.class), ParamsUtil.buildOperationID(), JsonUtil.toString(gidList));
    }

    /**
     * 申请加入群组
     *
     * @param gid        群组ID
     * @param reason     请求原因
     * @param joinSource 2：通过邀请  3：通过搜索  4：通过二维码
     * @param base       callback String
     */
    public void joinGroup(OnBase<String> base, String gid, String reason, int joinSource) {
        joinGroup(base, gid, reason, joinSource, null);
    }

    public void joinGroup(OnBase<String> base, String gid, String reason, int joinSource, String ex) {
        Open_im_sdk.joinGroup(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), gid, reason, joinSource, ex);
    }

    /**
     * 退群
     *
     * @param gid  群组ID
     * @param base callback String
     */
    public void quitGroup(OnBase<String> base, String gid) {
        Open_im_sdk.quitGroup(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), gid);
    }

    /**
     * 转让群主
     *
     * @param gid  群组ID
     * @param uid  新拥有者（群主）id
     * @param base callback String
     */
    public void transferGroupOwner(OnBase<String> base, String gid, String uid) {
        Open_im_sdk.transferGroupOwner(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), gid, uid);
    }

    /**
     * 收到群申请列表
     *
     * @param base callback {@link GroupApplicationInfo}
     */
    public void getRecvGroupApplicationList(OnBase<List<GroupApplicationInfo>> base) {
        Open_im_sdk.getGroupApplicationListAsRecipient(BaseImpl.arrayBase(base, GroupApplicationInfo.class), ParamsUtil.buildOperationID());
    }

    /**
     * 发出群申请列表
     *
     * @param base callback {@link GroupApplicationInfo}
     */
    public void getSendGroupApplicationList(OnBase<List<GroupApplicationInfo>> base) {
        Open_im_sdk.getGroupApplicationListAsApplicant(BaseImpl.arrayBase(base, GroupApplicationInfo.class), ParamsUtil.buildOperationID());
    }

    /**
     * 接受入群申请
     *
     * @param gid       群ID
     * @param uid       申请入群的用户ID
     * @param handleMsg 说明
     * @param base      callback String
     */
    public void acceptGroupApplication(OnBase<String> base, String gid, String uid, String handleMsg) {
        Open_im_sdk.acceptGroupApplication(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), gid, uid, handleMsg);

    }

    /**
     * 拒绝入群申请
     *
     * @param gid       群ID
     * @param uid       申请入群的用户ID
     * @param handleMsg 说明
     * @param base      callback String
     */
    public void refuseGroupApplication(OnBase<String> base, String gid, String uid, String handleMsg) {
        Open_im_sdk.refuseGroupApplication(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), gid, uid, handleMsg);

    }

    /**
     * 解散群
     *
     * @param gid 群ID
     */
    public void dismissGroup(OnBase<String> base, String gid) {
        Open_im_sdk.dismissGroup(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), gid);
    }

    /**
     * 开启群禁言
     *
     * @param gid  群ID
     * @param mute true开启
     */
    public void changeGroupMute(OnBase<String> base, String gid, boolean mute) {
        Open_im_sdk.changeGroupMute(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), gid, mute);

    }

    /**
     * 禁言群成员
     *
     * @param gid     群ID
     * @param uid     群成员userID
     * @param seconds 禁言时间s
     */
    public void changeGroupMemberMute(OnBase<String> base, String gid, String uid, long seconds) {
        Open_im_sdk.changeGroupMemberMute(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), gid, uid, seconds);
    }

    /**
     * 根据关键词搜索群组
     *
     * @param keywordList       关键词
     * @param isSearchGroupID   是通过群组id进行查询
     * @param isSearchGroupName 是通过群名称查询
     */
    public void searchGroups(OnBase<List<GroupInfo>> base, List<String> keywordList, boolean isSearchGroupID, boolean isSearchGroupName) {
        Map<String, Object> map = new ArrayMap<>();
        map.put("keywordList", keywordList);
        map.put("isSearchGroupID", isSearchGroupID);
        map.put("isSearchGroupName", isSearchGroupName);
        Open_im_sdk.searchGroups(BaseImpl.arrayBase(base, GroupInfo.class), ParamsUtil.buildOperationID(), JsonUtil.toString(map));
    }

    /**
     * 修改群成员信息
     * @param base 方法执行回调
     * @param setGroupMemberInfo 需要设置的成员信息，属性为空即为不传
     */
    public void setGroupMemberInfo(SetGroupMemberInfo setGroupMemberInfo, OnBase<String> base) {
        Open_im_sdk.setGroupMemberInfo(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), JsonUtil.toStringWithoutNull(setGroupMemberInfo));
    }

    /**
     * 根据加入时间分页获取组成员列表
     *
     * @param groupID           组ID号
     * @param offset            开始下标
     * @param count             每页大小
     * @param joinTimeBegin     加入开始时间
     * @param joinTimeEnd       加入结束时间
     * @param excludeUserIDList 排除的用户
     */
    public void getGroupMemberListByJoinTime(OnBase<List<GroupMembersInfo>> base, String groupID, int offset, int count, long joinTimeBegin, long joinTimeEnd
        , List<String> excludeUserIDList) {
        Open_im_sdk.getGroupMemberListByJoinTimeFilter(BaseImpl.arrayBase(base, GroupMembersInfo.class), ParamsUtil.buildOperationID(), groupID, offset,
            count, joinTimeBegin, joinTimeEnd, JsonUtil.toString(excludeUserIDList));
    }

    /**
     * 获取群拥有者，管理员
     *
     * @param groupID 组ID号
     */
    public void getGroupMemberOwnerAndAdmin(OnBase<List<GroupMembersInfo>> base, String groupID) {
        Open_im_sdk.getGroupMemberOwnerAndAdmin(BaseImpl.arrayBase(base, GroupMembersInfo.class), ParamsUtil.buildOperationID(), groupID);
    }

    /**
     * 根据关键词搜索群组
     *
     * @param groupID                群id
     * @param keywordList            关键词
     * @param isSearchUserID         是否以关键词搜成员id
     * @param isSearchMemberNickname 是否以关键词搜索成员昵称
     * @param offset                 开始index
     * @param count                  每次获取的总数
     */
    public void searchGroupMembers(OnBase<List<GroupMembersInfo>> base, String groupID, List<String> keywordList, boolean isSearchUserID,
                                   boolean isSearchMemberNickname, int offset, int count) {
        Map<String, Object> map = new ArrayMap<>();
        map.put("groupID", groupID);
        map.put("keywordList", keywordList);
        map.put("isSearchUserID", isSearchUserID);
        map.put("isSearchMemberNickname", isSearchMemberNickname);
        map.put("offset", offset);
        map.put("count", count);
        Open_im_sdk.searchGroupMembers(BaseImpl.arrayBase(base, GroupMembersInfo.class), ParamsUtil.buildOperationID(), JsonUtil.toString(map));
    }

    /**
     * 是否加入群
     *
     * @param gid
     * @param callBack
     */
    public void isJoinGroup(String gid, OnBase<Boolean> callBack) {
        Open_im_sdk.isJoinGroup(BaseImpl.objectBase(callBack, Boolean.class),
            ParamsUtil.buildOperationID(), gid);
    }
}
