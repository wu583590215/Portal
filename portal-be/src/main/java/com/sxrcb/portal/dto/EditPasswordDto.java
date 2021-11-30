package com.sxrcb.portal.dto;

import lombok.Data;

/**
 * 修改密码dto
 */
@Data
public class EditPasswordDto {
    private String oldPassword;
    private String newPassword;
    private String userNo;
}
