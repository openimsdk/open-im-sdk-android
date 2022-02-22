package io.openim.android.sdk.listener;

import java.util.List;

import io.openim.android.sdk.models.GroupApplicationInfo;
import io.openim.android.sdk.models.GroupInfo;
import io.openim.android.sdk.models.GroupMembersInfo;


/**
 * 群组监听
 */
public interface OnGroupListener {

    void onGroupApplicationAccepted(GroupApplicationInfo info);

    void onGroupApplicationAdded(GroupApplicationInfo info);

    void onGroupApplicationDeleted(GroupApplicationInfo info);

    void onGroupApplicationRejected(GroupApplicationInfo info);

    void onGroupInfoChanged(GroupInfo info);

    void onGroupMemberAdded(GroupMembersInfo info);


    void onGroupMemberDeleted(GroupMembersInfo info);


    void onGroupMemberInfoChanged(GroupMembersInfo info);

    void onJoinedGroupAdded(GroupInfo info);

    void onJoinedGroupDeleted(GroupInfo info);
}
