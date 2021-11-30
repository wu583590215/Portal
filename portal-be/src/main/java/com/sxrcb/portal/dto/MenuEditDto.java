package com.sxrcb.portal.dto;

import lombok.Data;

import java.util.List;

@Data
public class MenuEditDto {
    private String menuNo;
    private String menuName;
    private String router;
    private String icon;
    private String parentMenuNo;
    private List<String> positions;
    private List<String> roles;
}
