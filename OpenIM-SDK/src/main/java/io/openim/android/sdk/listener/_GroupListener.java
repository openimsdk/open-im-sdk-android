package io.openim.android.sdk.listener;

import io.openim.android.sdk.models.GroupInfo;
import io.openim.android.sdk.models.GroupMembersInfo;
import io.openim.android.sdk.utils.JsonUtil;

final public class _GroupListener implements open_im_sdk.OnGroupListener {
    final private OnGroupListener listener;

    public _GroupListener(OnGroupListener listener) {
        this.listener = listener;
    }

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
}
