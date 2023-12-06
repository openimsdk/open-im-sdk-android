package io.openim.android.sdk.listener;

import java.util.List;

import io.openim.android.sdk.models.GroupApplicationInfo;
import io.openim.android.sdk.models.GroupInfo;
import io.openim.android.sdk.models.GroupMembersInfo;


/**
 * 群组监听
 */
public interface OnGroupListener {

    default void  onGroupApplicationAccepted(GroupApplicationInfo info){}

    default void  onGroupApplicationAdded(GroupApplicationInfo info){}

    default void  onGroupApplicationDeleted(GroupApplicationInfo info){}

    default void  onGroupApplicationRejected(GroupApplicationInfo info){}

    default void  onGroupDismissed(GroupInfo info){}

    default void  onGroupInfoChanged(GroupInfo info){}

    default void  onGroupMemberAdded(GroupMembersInfo info){}


    default void  onGroupMemberDeleted(GroupMembersInfo info){}


    default void  onGroupMemberInfoChanged(GroupMembersInfo info){}

    default void  onJoinedGroupAdded(GroupInfo info){}

    default void  onJoinedGroupDeleted(GroupInfo info){}
}
