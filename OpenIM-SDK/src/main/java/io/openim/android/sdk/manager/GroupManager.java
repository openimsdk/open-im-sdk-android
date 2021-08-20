package io.openim.android.sdk.manager;


import java.util.List;

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

public class GroupManager {
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

    public void inviteUserToGroup(OnBase<List<GroupInviteResult>> base, String groupId, List<String> uidList, String reason) {
        Open_im_sdk.inviteUserToGroup(groupId, reason, JsonUtil.toString(uidList), BaseImpl.arrayBase(base, GroupInviteResult.class));
    }

    public void kickGroupMember(OnBase<List<GroupInviteResult>> base, String groupId, List<String> uidList, String reason) {
        Open_im_sdk.kickGroupMember(groupId, reason, JsonUtil.toString(uidList), BaseImpl.arrayBase(base, GroupInviteResult.class));
    }


    public void getGroupMembersInfo(OnBase<List<GroupMembersInfo>> base, String groupId, List<String> uidList) {
        Open_im_sdk.getGroupMembersInfo(groupId, JsonUtil.toString(uidList), BaseImpl.arrayBase(base, GroupMembersInfo.class));
    }

    public void getGroupMemberList(OnBase<GroupMembersList> base, String groupId, int filter, int next) {
        Open_im_sdk.getGroupMemberList(groupId, filter, next, BaseImpl.objectBase(base, GroupMembersList.class));
    }


    public void getJoinedGroupList(OnBase<List<GroupInfo>> base) {
        Open_im_sdk.getJoinedGroupList(BaseImpl.arrayBase(base, GroupInfo.class));
    }

    public void createGroup(OnBase<String> base, GroupInfo info, List<GroupMemberRole> list) {
        Open_im_sdk.createGroup(JsonUtil.toString(info), JsonUtil.toString(list), BaseImpl.stringBase(base));
    }

    public void setGroupInfo(OnBase<String> base, GroupInfo info) {
        Open_im_sdk.setGroupInfo(JsonUtil.toString(info), BaseImpl.stringBase(base));
    }


    public void getGroupsInfo(OnBase<List<GroupInfo>> base, List<String> gidList) {
        Open_im_sdk.getGroupsInfo(JsonUtil.toString(gidList), BaseImpl.arrayBase(base, GroupInfo.class));
    }

    public void joinGroup(OnBase<String> base, String gid, String reason) {
        Open_im_sdk.joinGroup(gid, reason, BaseImpl.stringBase(base));
    }

    public void quitGroup(OnBase<String> base, String gid) {
        Open_im_sdk.quitGroup(gid, BaseImpl.stringBase(base));
    }


    public void transferGroupOwner(OnBase<String> base, String gid, String uid) {
        Open_im_sdk.transferGroupOwner(gid, uid, BaseImpl.stringBase(base));
    }

    public void getGroupApplicationList(OnBase<GroupApplicationList> base) {
        Open_im_sdk.getGroupApplicationList(BaseImpl.objectBase(base, GroupApplicationList.class));
    }

    public void acceptGroupApplication(OnBase<String> base, GroupApplicationInfo info, String reason) {
        Open_im_sdk.acceptGroupApplication(JsonUtil.toString(info), reason, BaseImpl.stringBase(base));

    }

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
