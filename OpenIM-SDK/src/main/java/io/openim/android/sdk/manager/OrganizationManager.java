package io.openim.android.sdk.manager;

import java.util.List;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnOrganizationListener;
import io.openim.android.sdk.listener._OrganizationListener;
import io.openim.android.sdk.models.DeptInfo;
import io.openim.android.sdk.models.DeptMemberAndSubDept;
import io.openim.android.sdk.models.DeptMemberInfo;
import io.openim.android.sdk.models.UserInDept;
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
}
