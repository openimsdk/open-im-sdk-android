package io.openim.android.sdk.models;

public class UserInDept {
    DeptInfo department;
    DeptMemberInfo member;

    public DeptInfo getDepartment() {
        return department;
    }

    public void setDepartment(DeptInfo department) {
        this.department = department;
    }

    public DeptMemberInfo getMember() {
        return member;
    }

    public void setMember(DeptMemberInfo member) {
        this.member = member;
    }
}
