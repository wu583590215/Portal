package com.sxrcb.portal.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserRoleEditDto {
    private List<String> addList;
    private List<String> deleteList;
    private String userNo;
}
