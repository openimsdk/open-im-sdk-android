package io.openim.android.sdk.listener;

import org.jetbrains.annotations.NotNull;

import io.openim.android.sdk.models.GroupApplicationInfo;
import io.openim.android.sdk.models.GroupInfo;
import io.openim.android.sdk.models.GroupMembersInfo;
import io.openim.android.sdk.utils.CommonUtil;
import io.openim.android.sdk.utils.JsonUtil;

final public class _GroupListener implements open_im_sdk_callback.OnGroupListener {
    final private OnGroupListener listener;

    public _GroupListener(@NotNull("OnGroupListener can't is null") OnGroupListener listener) {
        this.listener = listener;
    }

    @Override
    public void onGroupApplicationAccepted(String s) {
        GroupApplicationInfo u = JsonUtil.toObj(s, GroupApplicationInfo.class);
        CommonUtil.runMainThread(() -> listener.onGroupApplicationAccepted(u));
    }

    @Override
    public void onGroupApplicationAdded(String s) {
            GroupApplicationInfo u = JsonUtil.toObj(s, GroupApplicationInfo.class);
            CommonUtil.runMainThread(() -> listener.onGroupApplicationAdded(u));
    }

    @Override
    public void onGroupApplicationDeleted(String s) {
            GroupApplicationInfo u = JsonUtil.toObj(s, GroupApplicationInfo.class);
            CommonUtil.runMainThread(() -> listener.onGroupApplicationDeleted(u));
    }

    @Override
    public void onGroupApplicationRejected(String s) {
        GroupApplicationInfo u = JsonUtil.toObj(s, GroupApplicationInfo.class);
        CommonUtil.runMainThread(() -> listener.onGroupApplicationRejected(u));
    }

    @Override
    public void onGroupDismissed(String s) {
        GroupInfo u = JsonUtil.toObj(s, GroupInfo.class);
        CommonUtil.runMainThread(() -> listener.onGroupDismissed(u));
    }

    @Override
    public void onGroupInfoChanged(String s) {
        GroupInfo u = JsonUtil.toObj(s, GroupInfo.class);
        CommonUtil.runMainThread(() -> listener.onGroupInfoChanged(u));
    }

    @Override
    public void onGroupMemberAdded(String s) {
        GroupMembersInfo u = JsonUtil.toObj(s, GroupMembersInfo.class);
        CommonUtil.runMainThread(() -> listener.onGroupMemberAdded(u));
    }

    @Override
    public void onGroupMemberDeleted(String s) {
        GroupMembersInfo u = JsonUtil.toObj(s, GroupMembersInfo.class);
        CommonUtil.runMainThread(() -> listener.onGroupMemberDeleted(u));
    }

    @Override
    public void onGroupMemberInfoChanged(String s) {
        GroupMembersInfo u = JsonUtil.toObj(s, GroupMembersInfo.class);
        CommonUtil.runMainThread(() -> listener.onGroupMemberInfoChanged(u));
    }

    @Override
    public void onJoinedGroupAdded(String s) {
        GroupInfo u = JsonUtil.toObj(s, GroupInfo.class);
        CommonUtil.runMainThread(() -> listener.onJoinedGroupAdded(u));
    }

    @Override
    public void onJoinedGroupDeleted(String s) {
        GroupInfo u = JsonUtil.toObj(s, GroupInfo.class);
        CommonUtil.runMainThread(() -> listener.onJoinedGroupDeleted(u));
    }
}
