package com.sxrcb.portal.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class CodeLibrary {
    @JSONField(serialize = false)
    private String codeType;

    private String codeNo;

    private String codeName;

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCodeNo() {
        return codeNo;
    }

    public void setCodeNo(String codeNo) {
        this.codeNo = codeNo;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
}