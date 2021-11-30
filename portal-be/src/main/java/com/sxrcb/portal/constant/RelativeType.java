package com.sxrcb.portal.constant;


/**
 * 菜单关联类型
 * @author wuqian
 */
public enum RelativeType {
    _01("01","菜单角色"),
    _02("02","菜单岗位");

    private String code;
    private String name;

    RelativeType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getNameByCode(String code) {
        for (RelativeType value : values()) {
            if (value.getCode().equals(code)) {
                return value.getName();
             }
        }
        return null;
    }
}
