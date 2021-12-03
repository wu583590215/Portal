package com.sxrcb.portal.service;

import com.sxrcb.portal.dto.MenuRoleEditDto;
import com.sxrcb.portal.dto.TreeViewDto;
import com.sxrcb.portal.entity.Menu;

import java.util.List;


/**
 * Created by Wuqian on 2021/11/18.
 */
public interface MenuService {
    /**
     * 保存
     * @param model 实体对象
     */
    void save(Menu model);

    /**
     * 用主键删除
     * @param id 主键
     */
    void deleteById(String id);

    /**
     * 更新
     * @param model 实体对象
     */
    void update(Menu model);

    /**
     * 更新菜单权限
     * @param menuRoleEditDto
     */
    void editMenuRoles(MenuRoleEditDto menuRoleEditDto);

    /**
     * 通过主键查询
     * @param id
     * @return
     */
    Menu findById(String id);

    /**
     * 查询所有
     * @return
     */
    List<Menu> findAll();

    /**
     * 获取菜单树图
     * @return
     */
    List<TreeViewDto> getMenuTree();

    /**
     * 获取菜单权限
     * @param menuNo
     * @param roleFlag
     * @return
     */
    List<String> findMenuRoles(String menuNo, String roleFlag);
}
