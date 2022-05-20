package io.openim.android.sdk.models;

/**
 * 部门信息
 */
public class DeptInfo {
    private String departmentID;
    private String faceURL;
    private String name;
    private String parentID;
    private int order;
    private int departmentType;
    private long createTime;
    private int subDepartmentNum;
    private int memberNum;
    private String ex;
    private String attachedInfo;

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getFaceURL() {
        return faceURL;
    }

    public void setFaceURL(String faceURL) {
        this.faceURL = faceURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(int departmentType) {
        this.departmentType = departmentType;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getSubDepartmentNum() {
        return subDepartmentNum;
    }

    public void setSubDepartmentNum(int subDepartmentNum) {
        this.subDepartmentNum = subDepartmentNum;
    }

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getAttachedInfo() {
        return attachedInfo;
    }

    public void setAttachedInfo(String attachedInfo) {
        this.attachedInfo = attachedInfo;
    }
}
