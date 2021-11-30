package com.sxrcb.portal.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.sxrcb.portal.common.Result;
import com.sxrcb.portal.common.ResultGenerator;
import com.sxrcb.portal.dto.LoginDto;
import com.sxrcb.portal.entity.User;
import com.sxrcb.portal.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
* 授权Controller
* @date 2021/10/26
* @author Wuqian
*/
@RestController
@RequestMapping("/acc")
public class AccessController {
    @Autowired
    AccessService accessService;

    /**
    * 登录
    * @param loginDto 实体对象
    * @return 结果
    */
    @PostMapping("/login")
    public Result<SaTokenInfo> add(@RequestBody LoginDto loginDto) {
        return ResultGenerator.genSuccessResult(accessService.login(loginDto));
    }

    /**
     * 查看登录状态
     * @param
     * @return 结果
     */
    @PostMapping("/isLogin")
    public Result isLogin() {
        return ResultGenerator.genSuccessResult(StpUtil.isLogin());
    }

    /**
     * 注销
     * @param
     * @return 结果
     */
    @PostMapping("/logout")
    public Result logout() {
        accessService.logout();
        return ResultGenerator.genSuccessResult();
    }


}
