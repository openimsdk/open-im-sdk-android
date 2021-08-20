package io.openim.android.sdk.manager;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnFriendshipListener;
import io.openim.android.sdk.models.UserInfo;
import io.openim.android.sdk.utils.CommonUtil;
import io.openim.android.sdk.utils.JsonUtil;
import open_im_sdk.Open_im_sdk;

public class FriendshipManager {
    public void setOnFriendListener(OnFriendshipListener listener) {
        Open_im_sdk.setFriendListener(new open_im_sdk.OnFriendshipListener() {
            @Override
            public void onBlackListAdd(String s) {
                if (null != listener) {
                    UserInfo u = JsonUtil.toObj(s, UserInfo.class);
                    CommonUtil.runMainThread(() -> listener.onBlackListAdd(u));
                }
            }

            @Override
            public void onBlackListDeleted(String s) {
                if (null != listener) {
                    UserInfo u = JsonUtil.toObj(s, UserInfo.class);
                    CommonUtil.runMainThread(() -> listener.onBlackListDeleted(u));
                }
            }

            @Override
            public void onFriendApplicationListAccept(String s) {
                if (null != listener) {
                    UserInfo u = JsonUtil.toObj(s, UserInfo.class);
                    CommonUtil.runMainThread(() -> listener.onFriendApplicationListAccept(u));
                }
            }

            @Override
            public void onFriendApplicationListAdded(String s) {
                if (null != listener) {
                    UserInfo u = JsonUtil.toObj(s, UserInfo.class);
                    CommonUtil.runMainThread(() -> listener.onFriendApplicationListAdded(u));
                }
            }

            @Override
            public void onFriendApplicationListDeleted(String s) {
                if (null != listener) {
                    UserInfo u = JsonUtil.toObj(s, UserInfo.class);
                    CommonUtil.runMainThread(() -> listener.onFriendApplicationListDeleted(u));
                }
            }

            @Override
            public void onFriendApplicationListReject(String s) {
                if (null != listener) {
                    UserInfo u = JsonUtil.toObj(s, UserInfo.class);
                    CommonUtil.runMainThread(() -> listener.onFriendApplicationListReject(u));
                }
            }

            @Override
            public void onFriendInfoChanged(String s) {
                if (null != listener) {
                    UserInfo u = JsonUtil.toObj(s, UserInfo.class);
                    CommonUtil.runMainThread(() -> listener.onFriendInfoChanged(u));
                }
            }

            @Override
            public void onFriendListAdded(String s) {
                if (null != listener) {
                    UserInfo u = JsonUtil.toObj(s, UserInfo.class);
                    CommonUtil.runMainThread(() -> listener.onFriendListAdded(u));
                }
            }

            @Override
            public void onFriendListDeleted(String s) {
                if (null != listener) {
                    UserInfo u = JsonUtil.toObj(s, UserInfo.class);
                    CommonUtil.runMainThread(() -> listener.onFriendListDeleted(u));
                }
            }
        });
    }

    public void getFriendList(OnBase<List<UserInfo>> base) {
        Open_im_sdk.getFriendList(BaseImpl.arrayBase(base, UserInfo.class));
    }

    public void getFriendApplicationList(OnBase<List<UserInfo>> base) {
        Open_im_sdk.getFriendApplicationList(BaseImpl.arrayBase(base, UserInfo.class));
    }

    public void addFriend(OnBase<String> base, String uid, String reason) {
        Map<String, Object> params = new HashMap<>();
        params.put("uid", uid);
        params.put("reqMessage", reason);
        Open_im_sdk.addFriend(BaseImpl.stringBase(base), JsonUtil.toString(params));
    }

    public void getFriendsInfo(OnBase<List<UserInfo>> base, List<String> uidList) {
        Open_im_sdk.getFriendsInfo(BaseImpl.arrayBase(base, UserInfo.class), JsonUtil.toString(uidList));
    }

    public void setFriendInfo(OnBase<String> base, UserInfo info) {
        Open_im_sdk.setFriendInfo(JsonUtil.toString(info), BaseImpl.stringBase(base));
    }

    public void refuseFriendApplication(OnBase<String> base, String uid) {
        Open_im_sdk.refuseFriendApplication(BaseImpl.stringBase(base), JsonUtil.toString(uid));
    }

    public void acceptFriendApplication(OnBase<String> base, String uid) {
        Open_im_sdk.acceptFriendApplication(BaseImpl.stringBase(base), JsonUtil.toString(uid));
    }

    public void deleteFromFriendList(OnBase<String> base, String uid) {
        Open_im_sdk.deleteFromFriendList(JsonUtil.toString(uid), BaseImpl.stringBase(base));
    }

    public void checkFriend(OnBase<List<UserInfo>> base, List<String> uidList) {
        Open_im_sdk.checkFriend(BaseImpl.arrayBase(base, UserInfo.class), JsonUtil.toString(uidList));
    }

    public void deleteFromBlackList(OnBase<String> base, String uid) {
        Open_im_sdk.deleteFromBlackList(BaseImpl.stringBase(base), JsonUtil.toString(uid));
    }

    public void getBlackList(OnBase<List<UserInfo>> base) {
        Open_im_sdk.getBlackList(BaseImpl.arrayBase(base, UserInfo.class));
    }

    public void addToBlackList(OnBase<String> base, String uid) {
        Open_im_sdk.addToBlackList(BaseImpl.stringBase(base), JsonUtil.toString(uid));
    }

    public void forceSyncFriend() {
        Open_im_sdk.forceSyncFriend();
    }

    public void forceSyncBlackList() {
        Open_im_sdk.forceSyncBlackList();
    }

    public void forceSyncFriendApplication() {
        Open_im_sdk.forceSyncFriendApplication();
    }
}
