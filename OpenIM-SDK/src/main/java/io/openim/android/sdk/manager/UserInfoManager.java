package io.openim.android.sdk.manager;

import androidx.collection.ArrayMap;

import java.util.List;
import java.util.Map;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnGroupListener;
import io.openim.android.sdk.listener.OnUserListener;
import io.openim.android.sdk.listener._GroupListener;
import io.openim.android.sdk.listener._UserListener;
import io.openim.android.sdk.models.UserInfo;
import io.openim.android.sdk.utils.JsonUtil;
import io.openim.android.sdk.utils.ParamsUtil;
import open_im_sdk.Open_im_sdk;

public class UserInfoManager {
    /**
     * 设置当前用户资料变更监听器
     */
    public void setOnUserListener(OnUserListener listener) {
        Open_im_sdk.setUserListener(new _UserListener(listener));
    }

    /**
     * 根据uid 批量查询用户信息
     *
     * @param uidList 用户id列表
     * @param base    callback List<{@link UserInfo}>
     */
    public void getUsersInfo(OnBase<List<UserInfo>> base, List<String> uidList) {
        Open_im_sdk.getUsersInfo(BaseImpl.arrayBase(base, UserInfo.class), ParamsUtil.buildOperationID(), JsonUtil.toString(uidList));
    }

    /**
     * 修改资料
     *
     * @param nickname    名字
     * @param faceURL     头像
     * @param gender      性别
     * @param phoneNumber 手机号
     * @param birth       出生日期
     * @param email       邮箱
     * @param base        callback String
     */
    public void setSelfInfo(OnBase<String> base, String nickname, String faceURL, int gender, int appMangerLevel, String phoneNumber, long birth, String email, String ex) {
        Map<String, Object> map = new ArrayMap<>();
        map.put("nickname", nickname);
        map.put("faceURL", faceURL);
        map.put("gender", gender);
        map.put("appMangerLevel", appMangerLevel);
        map.put("phoneNumber", phoneNumber);
        map.put("birth", birth);
        map.put("email", email);
        map.put("ex", ex);
        Open_im_sdk.setSelfInfo(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), JsonUtil.toString(map));
    }

    /**
     * 获取当前用户信息
     */
    public void getSelfUserInfo(OnBase<UserInfo> base) {
        Open_im_sdk.getSelfUserInfo(BaseImpl.objectBase(base, UserInfo.class), ParamsUtil.buildOperationID());
    }
}
