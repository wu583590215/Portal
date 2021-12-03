package com.sxrcb.portal.service;
import com.sxrcb.portal.entity.Role;

import java.util.List;


/**
 * Created by Wuqian on 2021/10/12.
 */
public interface RoleService  {

    /**
     * 保存
     * @param model 实体对象
     */
    void save(Role model);

    /**
     * 用主键删除
     * @param id 主键
     */
    void deleteById(String id);

    /**
     * 更新
     * @param model 实体对象
     */
    void update(Role model);

    /**
     * 通过主键查询
     * @param id
     * @return
     */
    Role findById(String id);

    /**
     * 查询所有
     * @return
     */
    List<Role> findAll(Role role);
}
