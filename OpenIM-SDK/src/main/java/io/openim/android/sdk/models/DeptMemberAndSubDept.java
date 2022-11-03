package io.openim.android.sdk.models;

import java.util.List;

public class DeptMemberAndSubDept {
    private List<DeptInfo> departmentList;
    private List<DeptMemberInfo> departmentMemberList;
    private List<DeptInfo> parentDepartmentList;

    public List<DeptInfo> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<DeptInfo> departmentList) {
        this.departmentList = departmentList;
    }

    public List<DeptMemberInfo> getDepartmentMemberList() {
        return departmentMemberList;
    }

    public void setDepartmentMemberList(List<DeptMemberInfo> departmentMemberList) {
        this.departmentMemberList = departmentMemberList;
    }

    public List<DeptInfo> getParentDepartmentList() {
        return parentDepartmentList;
    }

    public void setParentDepartmentList(List<DeptInfo> parentDepartmentList) {
        this.parentDepartmentList = parentDepartmentList;
    }
}
