package com.sxrcb.portal.service;
import com.sxrcb.portal.entity.Role;

import java.util.List;


/**
 * Created by Wuqian on 2021/10/12.
 */
public interface RoleService  {
    void save(Role model);
    void deleteById(String id);
    void update(Role model);
    Role findById(String id);
    List<Role> findAll(Role role);
}
