package com.sxrcb.portal.mapper;

import com.sxrcb.portal.entity.Role;
import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(String roleNo);

    int insert(Role record);

    Role selectByPrimaryKey(String roleNo);

    List<Role> selectAll(Role role);

    int updateByPrimaryKey(Role record);
}