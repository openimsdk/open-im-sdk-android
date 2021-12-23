package io.openim.android.sdk.manager;

import androidx.collection.ArrayMap;

import java.util.List;
import java.util.Map;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.models.UserInfo;
import io.openim.android.sdk.utils.JsonUtil;
import open_im_sdk.Open_im_sdk;

public class UserInfoManager {
    /**
     * 根据uid 批量查询用户信息
     *
     * @param uidList 用户id列表
     * @param base    callback List<{@link UserInfo}>
     */
    public void getUsersInfo(OnBase<List<UserInfo>> base, List<String> uidList) {
        Open_im_sdk.getUsersInfo(JsonUtil.toString(uidList), BaseImpl.arrayBase(base, UserInfo.class));
    }

    /**
     * 修改资料
     *
     * @param name   名字
     * @param icon   头像
     * @param gender 性别
     * @param mobile 手机号
     * @param birth  出生日期
     * @param email  邮箱
     * @param base   callback String
     */
    public void setSelfInfo(OnBase<String> base, String name, String icon, int gender, String mobile, String birth, String email) {
        Map<String, Object> map = new ArrayMap<>();
        map.put("name", name);
        map.put("icon", icon);
        map.put("gender", gender);
        map.put("mobile", mobile);
        map.put("birth", birth);
        map.put("email", email);
        Open_im_sdk.setSelfInfo(JsonUtil.toString(map), BaseImpl.stringBase(base));
    }

    public void forceSyncLoginUerInfo() {
        Open_im_sdk.forceSyncLoginUerInfo();
    }
}
