package io.openim.android.sdk.models;

/**
 * 部门信息
 */
public class DeptInfo {
    /**
     * 部门id
     */
    private String departmentID;
    /**
     * 头像
     */
    private String faceURL;
    /**
     * 名称
     */
    private String name;
    /**
     * 上一级id
     */
    private String parentID;
    /**
     * 排序
     */
    private int order;
    /**
     * 部门类型
     */
    private int departmentType;
    /**
     * 创建时间
     */
    private long createTime;
    /**
     * 子部门数量
     */
    private int subDepartmentNum;
    /**
     * 成员数量
     */
    private int memberNum;
    /**
     * 附加字段
     */
    private String ex;
    /**
     * 附加信息
     */
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
