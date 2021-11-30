package com.sxrcb.portal.entity;

public class Department {
    private String depNo;

    private String depName;

    private String parentDepNo;

    public String getDepNo() {
        return depNo;
    }

    public void setDepNo(String depNo) {
        this.depNo = depNo;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getParentDepNo() {
        return parentDepNo;
    }

    public void setParentDepNo(String parentDepNo) {
        this.parentDepNo = parentDepNo;
    }
}