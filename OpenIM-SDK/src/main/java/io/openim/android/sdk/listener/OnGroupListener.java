package io.openim.android.sdk.listener;

import java.util.List;

import io.openim.android.sdk.models.GroupInfo;
import io.openim.android.sdk.models.GroupMembersInfo;


/**
 * 群组监听
 */
public interface OnGroupListener {
    /**
     * 有人进群时回调
     */
    void onMemberEnter(String groupId, List<GroupMembersInfo> list);

    /**
     * 群成员退群时回调
     */
    void onMemberLeave(String groupId, GroupMembersInfo info);

    /**
     * 接受邀请时回调
     */
    void onMemberInvited(String groupId, GroupMembersInfo opUser, List<GroupMembersInfo> list);

    /**
     * 成员被踢出时回调
     */
    void onMemberKicked(String groupId, GroupMembersInfo opUser, List<GroupMembersInfo> list);

    /**
     * 群创建完成时回调
     */
    void onGroupCreated(String groupId);

    /**
     * 群资料发生变化时回调
     */
    void onGroupInfoChanged(String groupId, GroupInfo info);

    /**
     * 收到入群申请
     */
    void onReceiveJoinApplication(String groupId, GroupMembersInfo info, String opReason);

    /**
     * 进群申请被处理时回调
     */
    void onApplicationProcessed(String groupId, GroupMembersInfo opUser, int agreeOrReject, String opReason);
}
