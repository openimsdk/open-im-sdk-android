package io.openim.android.sdk.manager;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnGroupListener;
import io.openim.android.sdk.models.GroupApplicationInfo;
import io.openim.android.sdk.models.GroupApplicationList;
import io.openim.android.sdk.models.GroupInfo;
import io.openim.android.sdk.models.GroupInviteResult;
import io.openim.android.sdk.models.GroupMemberRole;
import io.openim.android.sdk.models.GroupMembersInfo;
import io.openim.android.sdk.models.GroupMembersList;
import io.openim.android.sdk.utils.JsonUtil;
import open_im_sdk.Open_im_sdk;

/**
 * 群组管理器
 */
public class GroupManager {
    /**
     * 设置组监听器
     * <p>
     * 群申请被处理：onApplicationProcessed
     * 群创建完成：onGroupCreated
     * 群资料发生变化：onGroupInfoChanged
     * 进群：onMemberEnter
     * 接受邀请：onMemberInvited
     * 成员被踢出：onMemberKicked
     * 群成员退群：onMemberLeave
     * 收到入群申请：onReceiveJoinApplication
     */
    public void setOnGroupListener(OnGroupListener listener) {
        Open_im_sdk.setGroupListener(new open_im_sdk.OnGroupListener() {
            @Override
            public void onApplicationProcessed(String s, String s1, int i, String s2) {
                if (null != listener) {
                    listener.onApplicationProcessed(s, JsonUtil.toObj(s1, GroupMembersInfo.class), i, s2);
                }
            }

            @Override
            public void onGroupCreated(String s) {
                if (null != listener) {
                    listener.onGroupCreated(s);
                }
            }

            @Override
            public void onGroupInfoChanged(String s, String s1) {
                if (null != listener) {
                    listener.onGroupInfoChanged(s, JsonUtil.toObj(s1, GroupInfo.class));
                }
            }

            @Override
            public void onMemberEnter(String s, String s1) {
                if (null != listener) {
                    listener.onMemberEnter(s, JsonUtil.toArray(s1, GroupMembersInfo.class));
                }
            }

            @Override
            public void onMemberInvited(String s, String s1, String s2) {
                if (null != listener) {
                    listener.onMemberInvited(s, JsonUtil.toObj(s1, GroupMembersInfo.class),
                            JsonUtil.toArray(s2, GroupMembersInfo.class));
                }
            }

            @Override
            public void onMemberKicked(String s, String s1, String s2) {
                if (null != listener) {
                    listener.onMemberKicked(s, JsonUtil.toObj(s1, GroupMembersInfo.class),
                            JsonUtil.toArray(s2, GroupMembersInfo.class));
                }
            }

            @Override
            public void onMemberLeave(String s, String s1) {
                if (null != listener) {
                    listener.onMemberLeave(s, JsonUtil.toObj(s1, GroupMembersInfo.class));
                }
            }

            @Override
            public void onReceiveJoinApplication(String s, String s1, String s2) {
                if (null != listener) {
                    listener.onReceiveJoinApplication(s, JsonUtil.toObj(s1, GroupMembersInfo.class), s2);
                }
            }
        });
    }

    /**
     * 邀请进群
     *
     * @param groupId 群组ID
     * @param uidList 被要用的用户id列表
     * @param reason  邀请说明
     * @param base    callback List<{@link GroupInviteResult}>>
     */
    public void inviteUserToGroup(OnBase<List<GroupInviteResult>> base, String groupId, List<String> uidList, String reason) {
        Open_im_sdk.inviteUserToGroup(groupId, reason, JsonUtil.toString(uidList), BaseImpl.arrayBase(base, GroupInviteResult.class));
    }

    /**
     * 踢出群
     *
     * @param groupId 群组ID
     * @param uidList 被要踢出群的用户id列表
     * @param reason  说明
     * @param base    callback List<{@link GroupInviteResult}>>
     */
    public void kickGroupMember(OnBase<List<GroupInviteResult>> base, String groupId, List<String> uidList, String reason) {
        Open_im_sdk.kickGroupMember(groupId, reason, JsonUtil.toString(uidList), BaseImpl.arrayBase(base, GroupInviteResult.class));
    }


    /**
     * 批量获取群成员信息
     *
     * @param groupId 群组ID
     * @param uidList 群成员ID
     * @param base    callback List<{@link GroupMembersInfo}>
     **/
    public void getGroupMembersInfo(OnBase<List<GroupMembersInfo>> base, String groupId, List<String> uidList) {
        Open_im_sdk.getGroupMembersInfo(groupId, JsonUtil.toString(uidList), BaseImpl.arrayBase(base, GroupMembersInfo.class));
    }

    /**
     * 获取群成员
     *
     * @param groupId 群组ID
     * @param filter  过滤成员，0不过滤，1群的创建者，2管理员；默认值0
     * @param next    分页，从next条开始获取，默认值0。参照{@link GroupMembersList}的nextSeq字段的值。
     */
    public void getGroupMemberList(OnBase<GroupMembersList> base, String groupId, int filter, int next) {
        Open_im_sdk.getGroupMemberList(groupId, filter, next, BaseImpl.objectBase(base, GroupMembersList.class));
    }


    /**
     * 获取已加入的群列表
     *
     * @param base callback List<{@link GroupInfo}></>
     */
    public void getJoinedGroupList(OnBase<List<GroupInfo>> base) {
        Open_im_sdk.getJoinedGroupList(BaseImpl.arrayBase(base, GroupInfo.class));
    }

    /**
     * 创建群
     *
     * @param groupName    群名称
     * @param notification 群公告
     * @param introduction 群简介
     * @param faceUrl      群icon
     * @param list         List<{@link GroupMemberRole}> 创建群是选择的成员. setRole：0:普通成员 2:管理员；1：群主
     */
    public void createGroup(OnBase<String> base, String groupName, String notification, String introduction, String faceUrl, List<GroupMemberRole> list) {
        Map<String, Object> map = new HashMap<>();
        map.put("groupName", groupName);
        map.put("notification", notification);
        map.put("introduction", introduction);
        map.put("faceUrl", faceUrl);
        Open_im_sdk.createGroup(JsonUtil.toString(map), JsonUtil.toString(list), BaseImpl.stringBase(base));
    }

    /**
     * 设置或更新群资料
     *
     * @param groupName    群名称
     * @param notification 群公告
     * @param introduction 群简介
     * @param faceUrl      群icon
     * @param base         callbak String
     */
    public void setGroupInfo(OnBase<String> base, String groupName, String notification, String introduction, String faceUrl) {
        Map<String, Object> map = new HashMap<>();
        map.put("groupName", groupName);
        map.put("notification", notification);
        map.put("introduction", introduction);
        map.put("faceUrl", faceUrl);
        Open_im_sdk.setGroupInfo(JsonUtil.toString(map), BaseImpl.stringBase(base));
    }


    /**
     * 批量获取群资料
     *
     * @param gidList 群ID集合
     * @param base    callback List<{@link GroupInfo}>
     */
    public void getGroupsInfo(OnBase<List<GroupInfo>> base, List<String> gidList) {
        Open_im_sdk.getGroupsInfo(JsonUtil.toString(gidList), BaseImpl.arrayBase(base, GroupInfo.class));
    }

    /**
     * 申请加入群组
     *
     * @param gid    群组ID
     * @param reason 请求原因
     * @param base   callback String
     */
    public void joinGroup(OnBase<String> base, String gid, String reason) {
        Open_im_sdk.joinGroup(gid, reason, BaseImpl.stringBase(base));
    }

    /**
     * 退群
     *
     * @param gid  群组ID
     * @param base callback String
     */
    public void quitGroup(OnBase<String> base, String gid) {
        Open_im_sdk.quitGroup(gid, BaseImpl.stringBase(base));
    }

    /**
     * 转让群主
     *
     * @param gid  群组ID
     * @param uid  被转让的用户ID
     * @param base callback String
     */
    public void transferGroupOwner(OnBase<String> base, String gid, String uid) {
        Open_im_sdk.transferGroupOwner(gid, uid, BaseImpl.stringBase(base));
    }

    /**
     * 获取群申请列表
     *
     * @param base callback {@link GroupApplicationList}
     */
    public void getGroupApplicationList(OnBase<GroupApplicationList> base) {
        Open_im_sdk.getGroupApplicationList(BaseImpl.objectBase(base, GroupApplicationList.class));
    }

    /**
     * 接受入群申请
     *
     * @param info   getGroupApplicationList返回值的item
     * @param reason 说明
     * @param base   callback String
     */
    public void acceptGroupApplication(OnBase<String> base, GroupApplicationInfo info, String reason) {
        Open_im_sdk.acceptGroupApplication(JsonUtil.toString(info), reason, BaseImpl.stringBase(base));

    }

    /**
     * 拒绝入群申请
     *
     * @param info   getGroupApplicationList返回值的item
     * @param reason 说明
     * @param base   callback String
     */
    public void refuseGroupApplication(OnBase<String> base, GroupApplicationInfo info, String reason) {
        Open_im_sdk.refuseGroupApplication(JsonUtil.toString(info), reason, BaseImpl.stringBase(base));

    }

    public void forceSyncApplyGroupRequest() {
        Open_im_sdk.forceSyncApplyGroupRequest();
    }

    public void forceSyncGroupRequest() {
        Open_im_sdk.forceSyncGroupRequest();
    }

    public void forceSyncJoinedGroup() {
        Open_im_sdk.forceSyncJoinedGroup();
    }

    public void forceSyncJoinedGroupMember() {
        Open_im_sdk.forceSyncJoinedGroupMember();
    }
}
