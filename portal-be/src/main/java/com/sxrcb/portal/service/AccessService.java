package com.sxrcb.portal.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.sxrcb.portal.dto.LoginDto;
import com.sxrcb.portal.entity.CodeLibrary;

import java.util.List;
import java.util.Map;


/**
 * Created by Wuqian on 2021/11/03.
 */
public interface AccessService {

    /**
     * 登录
     * @param loginDto
     */
    SaTokenInfo login(LoginDto loginDto);

    /**
     * 注销
     */
    void logout();
}
