package com.sxrcb.portal.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.sxrcb.portal.common.ServiceException;
import com.sxrcb.portal.constant.UserStatus;
import com.sxrcb.portal.dto.EditPasswordDto;
import com.sxrcb.portal.dto.UserRoleEditDto;
import com.sxrcb.portal.dto.UserInfoDto;
import com.sxrcb.portal.entity.User;
import com.sxrcb.portal.mapper.UserMapper;
import com.sxrcb.portal.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;



/**
 * Created by Wuqian on 2021/10/26.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper portalUserMapper;

    private static final String DEFAULT_PASSWORD = "123456";

    /**
     * 修改密码
     * @param editPasswordDto
     */
    @Override
    public void editPassword(EditPasswordDto editPasswordDto) {
        UserInfoDto userInfo = (UserInfoDto) StpUtil.getTokenSession().get("userInfo");
        String localPassword = this.findById(userInfo.getUserNo()).getPassword();
        if (!localPassword.equals(editPasswordDto.getOldPassword())) {
            throw new ServiceException("原密码输入不正确");
        }else {
            portalUserMapper.updatePassword(userInfo.getUserNo(), editPasswordDto.getNewPassword());
        }
    }

    /**
     * 新增用户
     * @param portalUser
     */
    @Override
    public void save(User portalUser) {
        portalUser.setStatus(UserStatus._01.getCode());
        portalUser.setPassword(DigestUtils.md5DigestAsHex(DEFAULT_PASSWORD.getBytes()));
        portalUserMapper.insert(portalUser);
    }

    @Override
    public void deleteById(String id) {
        portalUserMapper.deleteByPrimaryKey(id);
        portalUserMapper.deleteAllPositions(id);
        portalUserMapper.deleteAllRoles(id);
    }

    /**
     * 重置密码
     * @param id
     */
    @Override
    public void resetPassword(String id) {
        portalUserMapper.resetPassword(id,DigestUtils.md5DigestAsHex(DEFAULT_PASSWORD.getBytes()));
    }

    @Override
    public void update(User portalUser) {
        portalUserMapper.updateByPrimaryKey(portalUser);
    }

    @Override
    public User findById(String id) {
        return portalUserMapper.selectByPrimaryKey(id);
    }


    /**
     * 获取用户角色
     * @param userNo
     * @return
     */
    @Override
    public List<String> roleList(String userNo) {
        return portalUserMapper.selectRoles(userNo);
    }

    /**
     * 获取用户岗位列表
     * @param userNo
     * @return
     */
    @Override
    public List<String> posList(String userNo) {
        return portalUserMapper.selectUserPositions(userNo);
    }

    /**
     * 编辑用户的岗位
     * @param editUserPosition
     */
    @Override
    public void editUserPosition(UserRoleEditDto editUserPosition) {
        List<String> addList = editUserPosition.getAddList();
        if (addList != null && addList.size() > 0) {
            portalUserMapper.insertPositions(addList, editUserPosition.getUserNo());
        }

        List<String> deleteList = editUserPosition.getDeleteList();
        if (deleteList != null && deleteList.size() > 0) {
            portalUserMapper.deletePositions(deleteList, editUserPosition.getUserNo());
        }

    }

    /**
     * 编辑用户的岗位
     * @param editUserPosition
     */
    @Override
    public void editUserRole(UserRoleEditDto editUserPosition) {
        List<String> addList = editUserPosition.getAddList();
        if (addList != null && addList.size() > 0) {
            portalUserMapper.insertRoles(addList, editUserPosition.getUserNo());
        }

        List<String> deleteList = editUserPosition.getDeleteList();
        if (deleteList != null && deleteList.size() > 0) {
            portalUserMapper.deleteRoles(deleteList, editUserPosition.getUserNo());
        }

    }

    @Override
    public List<User> findAll() {
        return portalUserMapper.selectAll();
    }




}
