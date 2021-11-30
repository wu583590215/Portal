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

    @Override
    public void save(Role portalRole) {
        Role role = portalRoleMapper.selectByPrimaryKey(portalRole.getRoleNo());
        if (role == null) {
            portalRoleMapper.insert(portalRole);
        }else {
            throw new ServiceException("存在重复的角色编号!");
        }
    }

    @Override
    public void deleteById(String id) {
        portalRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Role portalRole) {
        portalRoleMapper.updateByPrimaryKey(portalRole);
    }

    @Override
    public Role findById(String id) {
        return portalRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> findAll(Role role) {
        return portalRoleMapper.selectAll(role);
    }


}
