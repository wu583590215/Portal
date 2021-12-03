package com.sxrcb.portal.service.impl;

import com.sxrcb.portal.common.ServiceException;
import com.sxrcb.portal.mapper.RoleMapper;
import com.sxrcb.portal.entity.Role;
import com.sxrcb.portal.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;



/**
 * Created by Wuqian on 2021/10/12.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper portalRoleMapper;

    /**
     * 保存
     * @param portalRole
     */
    @Override
    public void save(Role portalRole) {
        Role role = portalRoleMapper.selectByPrimaryKey(portalRole.getRoleNo());
        if (role == null) {
            portalRoleMapper.insert(portalRole);
        }else {
            throw new ServiceException("存在重复的角色编号!");
        }
    }

    /**
     * 通过主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(String id) {
        portalRoleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新
     * @param portalRole
     */
    @Override
    public void update(Role portalRole) {
        portalRoleMapper.updateByPrimaryKey(portalRole);
    }

    /**
     * 通过主键查询
     * @param id
     * @return
     */
    @Override
    public Role findById(String id) {
        return portalRoleMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     * @param role
     * @return
     */
    @Override
    public List<Role> findAll(Role role) {
        return portalRoleMapper.selectAll(role);
    }


}
