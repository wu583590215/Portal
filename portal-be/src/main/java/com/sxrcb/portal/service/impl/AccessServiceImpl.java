package com.sxrcb.portal.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.sxrcb.portal.common.ServiceException;
import com.sxrcb.portal.constant.UserStatus;
import com.sxrcb.portal.dto.LoginDto;
import com.sxrcb.portal.dto.UserInfoDto;
import com.sxrcb.portal.entity.User;
import com.sxrcb.portal.service.AccessService;
import com.sxrcb.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccessServiceImpl implements AccessService {
    @Autowired
    UserService userService;

    /**
     * 登录
     * @param loginDto
     */
    @Override
    public SaTokenInfo login(LoginDto loginDto) {
        String password = loginDto.getPassword();
        String userNo = loginDto.getUserNo();
        User user = userService.findById(userNo);
        if (user == null) {
            throw new ServiceException("登录失败！用户名错误");
        }else if(!UserStatus._01.getCode().equals(user.getStatus())) {
            throw new ServiceException("登录失败！用户状态异常，请联系系统管理员");
        }else if (!user.getPassword().equals(password)) {
            throw new ServiceException("登录失败！密码错误");
        }else {
            // 登录成功
            StpUtil.login(userNo);
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();

            // 存入缓存
            UserInfoDto userInfoDto = new UserInfoDto();
            userInfoDto.setDepName(user.getDepName());
            userInfoDto.setDepNo(user.getDepNo());
            userInfoDto.setUserNo(user.getUserNo());
            userInfoDto.setUserName(user.getUserName());
            userInfoDto.setPosList(userService.posList(userNo));
            userInfoDto.setRoleList(userService.roleList(userNo));
            StpUtil.getTokenSession().set("userInfo", userInfoDto);
            return tokenInfo;
        }
    }

    /**
     * 注销
     */
    @Override
    public void logout() {
        // 注销并清楚缓存
        StpUtil.logout();
    }


}
