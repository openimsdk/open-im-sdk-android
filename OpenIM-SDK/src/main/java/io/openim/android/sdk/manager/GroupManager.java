package io.openim.android.sdk.manager;


import androidx.collection.ArrayMap;

import java.util.List;
import java.util.Map;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnGroupListener;
import io.openim.android.sdk.listener._GroupListener;
import io.openim.android.sdk.models.GroupApplicationInfo;
import io.openim.android.sdk.models.GroupInfo;
import io.openim.android.sdk.models.GroupInviteResult;
import io.openim.android.sdk.models.GroupMemberRole;
import io.openim.android.sdk.models.GroupMembersInfo;
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
    public void inviteUserToGroup(OnBase<List<GroupInviteResult>> base, String groupId, List<String> uidList, String reason) {
        Open_im_sdk.inviteUserToGroup(BaseImpl.arrayBase(base, GroupInviteResult.class), ParamsUtil.buildOperationID(), groupId, reason, JsonUtil.toString(uidList));
    }

    /**
     * 踢出群
     *
     * @param groupId 群组ID
     * @param uidList 被踢出群的用户id列表
     * @param reason  说明
     * @param base    callback List<{@link GroupInviteResult}>>
     */
    public void kickGroupMember(OnBase<List<GroupInviteResult>> base, String groupId, List<String> uidList, String reason) {
        Open_im_sdk.kickGroupMember(BaseImpl.arrayBase(base, GroupInviteResult.class), ParamsUtil.buildOperationID(), groupId, reason, JsonUtil.toString(uidList));
    }


    /**
     * 批量获取群成员信息
     *
     * @param groupId 群组ID
     * @param uidList 群成员ID集合
     * @param base    callback List<{@link GroupMembersInfo}>
     **/
    public void getGroupMembersInfo(OnBase<List<GroupMembersInfo>> base, String groupId, List<String> uidList) {
        Open_im_sdk.getGroupMembersInfo(BaseImpl.arrayBase(base, GroupMembersInfo.class), ParamsUtil.buildOperationID(), groupId, JsonUtil.toString(uidList));
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
     * 获取已加入的群列表
     *
     * @param base callback List<{@link GroupInfo}></>
     */
    public void getJoinedGroupList(OnBase<List<GroupInfo>> base) {
        Open_im_sdk.getJoinedGroupList(BaseImpl.arrayBase(base, GroupInfo.class), ParamsUtil.buildOperationID());
    }

    /**
     * 创建群
     *
     * @param groupName    群名称
     * @param faceURL      群icon
     * @param notification 群公告
     * @param introduction 群简介
     * @param groupType
     * @param ex           其他信息
     * @param list         List<{@link GroupMemberRole}> 创建群是选择的成员. setRole：0:普通成员 2:管理员；1：群主
     */
    public void createGroup(OnBase<GroupInfo> base, String groupName, String faceURL, String notification, String introduction, int groupType, String ex, List<GroupMemberRole> list) {
        Map<String, Object> map = new ArrayMap<>();
        map.put("groupName", groupName);
        map.put("notification", notification);
        map.put("introduction", introduction);
        map.put("faceURL", faceURL);
        map.put("groupType", groupType);
        map.put("ex", ex);
        Open_im_sdk.createGroup(BaseImpl.objectBase(base, GroupInfo.class), ParamsUtil.buildOperationID(), JsonUtil.toString(map), JsonUtil.toString(list));
    }

    /**
     * 设置或更新群资料
     *
     * @param groupID      群ID
     * @param groupName    群名称
     * @param faceURL      群icon
     * @param notification 群公告
     * @param introduction 群简介
     * @param ex           其他信息
     * @param base         callback String
     */
    public void setGroupInfo(OnBase<String> base, String groupID, String groupName, String faceURL, String notification, String introduction, String ex) {
        Map<String, Object> map = new ArrayMap<>();
        map.put("groupName", groupName);
        map.put("notification", notification);
        map.put("introduction", introduction);
        map.put("faceURL", faceURL);
        map.put("ex", ex);
        Open_im_sdk.setGroupInfo(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), groupID, JsonUtil.toString(map));
    }


    /**
     * 批量获取群资料
     *
     * @param gidList 群ID集合
     * @param base    callback List<{@link GroupInfo}>
     */
    public void getGroupsInfo(OnBase<List<GroupInfo>> base, List<String> gidList) {
        Open_im_sdk.getGroupsInfo(BaseImpl.arrayBase(base, GroupInfo.class), ParamsUtil.buildOperationID(), JsonUtil.toString(gidList));
    }

    /**
     * 申请加入群组
     *
     * @param gid    群组ID
     * @param reason 请求原因
     * @param base   callback String
     */
    public void joinGroup(OnBase<String> base, String gid, String reason) {
        Open_im_sdk.joinGroup(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), gid, reason);
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
    public void getRecvGroupApplicationList(OnBase<GroupApplicationInfo> base) {
        Open_im_sdk.getRecvGroupApplicationList(BaseImpl.objectBase(base, GroupApplicationInfo.class), ParamsUtil.buildOperationID());
    }

    /**
     * 发出群申请列表
     *
     * @param base callback {@link GroupApplicationInfo}
     */
    public void getSendGroupApplicationList(OnBase<GroupApplicationInfo> base) {
        Open_im_sdk.getSendGroupApplicationList(BaseImpl.objectBase(base, GroupApplicationInfo.class), ParamsUtil.buildOperationID());
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
}
