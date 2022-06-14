package io.openim.android.sdk.manager;

import androidx.collection.ArrayMap;

import java.util.List;
import java.util.Map;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnOrganizationListener;
import io.openim.android.sdk.listener._OrganizationListener;
import io.openim.android.sdk.models.DeptInfo;
import io.openim.android.sdk.models.DeptMemberAndSubDept;
import io.openim.android.sdk.models.DeptMemberInfo;
import io.openim.android.sdk.models.OrganizationSearchResult;
import io.openim.android.sdk.models.UserInDept;
import io.openim.android.sdk.utils.JsonUtil;
import io.openim.android.sdk.utils.ParamsUtil;
import open_im_sdk.Open_im_sdk;

public class OrganizationManager {
    /**
     * 设置组织架构信息更新回调
     */
    public void setOnOrganizationListener(OnOrganizationListener listener) {
        Open_im_sdk.setOrganizationListener(new _OrganizationListener(listener));
    }

    /**
     * 获取部门子部门
     *
     * @param departmentID 部门id
     * @param offset       开始index
     * @param count        查询总数
     * @param base         callback List<{@link DeptInfo}>
     */
    public void getSubDepartment(OnBase<List<DeptInfo>> base, String departmentID, long offset, long count) {
        Open_im_sdk.getSubDepartment(BaseImpl.arrayBase(base, DeptInfo.class), ParamsUtil.buildOperationID(), departmentID, offset, count);
    }

    /**
     * 获取部门成员
     *
     * @param departmentID 部门id
     * @param offset       开始index
     * @param count        查询总数
     * @param base         callback List<{@link DeptMemberInfo}>
     */
    public void getDepartmentMember(OnBase<List<DeptMemberInfo>> base, String departmentID, long offset, long count) {
        Open_im_sdk.getDepartmentMember(BaseImpl.arrayBase(base, DeptMemberInfo.class), ParamsUtil.buildOperationID(), departmentID, offset, count);
    }

    /**
     * 获取用户的当前部门
     *
     * @param userID 用户id
     */
    public void getUserInDepartment(OnBase<List<UserInDept>> base, String userID) {
        Open_im_sdk.getUserInDepartment(BaseImpl.arrayBase(base, UserInDept.class), ParamsUtil.buildOperationID(), userID);
    }

    /**
     * 获取部门子部门跟成员
     *
     * @param departmentID 部门id
     */
    public void getDepartmentMemberAndSubDepartment(OnBase<List<DeptMemberAndSubDept>> base, String departmentID) {
        Open_im_sdk.getDepartmentMemberAndSubDepartment(BaseImpl.arrayBase(base, DeptMemberAndSubDept.class), ParamsUtil.buildOperationID(), departmentID);
    }

    /**
     * 获取当前部门信息
     *
     * @param departmentID 部门id
     */
    public void getDepartmentInfo(OnBase<DeptInfo> base, String departmentID) {
        Open_im_sdk.getDepartmentInfo(BaseImpl.objectBase(base, DeptInfo.class), ParamsUtil.buildOperationID(), departmentID);
    }


    /**
     * 搜索部门信息
     * 条件为or关系，至少保证一个条件为true
     *
     * @param keyWord             关键字
     * @param isSearchUserName    用户名
     * @param isSearchEnglishName 英文名
     * @param isSearchPosition    职位
     * @param isSearchUserID      用户id
     * @param isSearchMobile      手机号
     * @param isSearchEmail       邮箱
     * @param isSearchTelephone   座机
     * @param offset              分页开始位置
     * @param count               每页数量
     */
    public void searchOrganization(OnBase<OrganizationSearchResult> base, String keyWord, boolean isSearchUserName, boolean isSearchEnglishName, boolean isSearchPosition, boolean isSearchUserID, boolean isSearchMobile, boolean isSearchEmail, boolean isSearchTelephone, long offset, long count) {
        Map<String, Object> map = new ArrayMap<>();
        map.put("keyWord", keyWord);
        map.put("isSearchUserName", isSearchUserName);
        map.put("isSearchEnglishName", isSearchEnglishName);
        map.put("isSearchPosition", isSearchPosition);
        map.put("isSearchUserID", isSearchUserID);
        map.put("isSearchMobile", isSearchMobile);
        map.put("isSearchEmail", isSearchEmail);
        map.put("isSearchTelephone", isSearchTelephone);
        Open_im_sdk.searchOrganization(BaseImpl.objectBase(base, OrganizationSearchResult.class), ParamsUtil.buildOperationID(), JsonUtil.toString(map), offset, count);
    }

}
