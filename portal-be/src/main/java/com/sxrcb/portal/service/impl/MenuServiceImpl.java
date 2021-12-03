package com.sxrcb.portal.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.sxrcb.portal.dto.MenuRoleEditDto;
import com.sxrcb.portal.dto.TreeViewDto;
import com.sxrcb.portal.entity.Menu;
import com.sxrcb.portal.mapper.MenuMapper;
import com.sxrcb.portal.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Wuqian on 2021/11/18.
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper portalMenuMapper;

    /**
     * 保存
     * @param portalMenu
     */
    @Override
    public void save(Menu portalMenu) {
        portalMenuMapper.insert(portalMenu);
    }

    /**
     * 删除关联表及菜单表
     *
     * @param id
     */
    @Override
    public void deleteById(String id) {
        portalMenuMapper.deleteMenu(id);
        portalMenuMapper.deleteAllMenuRel(id);
    }

    /**
     * 更新
     * @param menu
     */
    @Override
    public void update(Menu menu) {
        portalMenuMapper.updateByPrimaryKey(menu);
    }

    /**
     * 编辑菜单权限
     * @param menuRoleEditDto
     */
    @Override
    public void editMenuRoles(MenuRoleEditDto menuRoleEditDto) {
        String menuNo = menuRoleEditDto.getMenuNo();
        String relativeType = menuRoleEditDto.getRelativeType();
        // 新增的权限插入
        List<String> addList = menuRoleEditDto.getAddList();
        if (addList != null && addList.size() > 0) {
            portalMenuMapper.insertMenuRel(addList, menuNo, relativeType);
        }
        // 删除的进行删除
        List<String> deleteList = menuRoleEditDto.getDeleteList();
        if (deleteList != null && deleteList.size() > 0) {
            portalMenuMapper.deleteMenuRel(deleteList, menuNo, relativeType);
        }
    }

    /**
     * 用主键查询
     * @param id
     * @return
     */
    @Override
    public Menu findById(String id) {
        return portalMenuMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询菜单的权限列表
     * @param menuNo
     * @param roleFlag
     * @return
     */
    @Override
    public List<String> findMenuRoles(String menuNo, String roleFlag) {
        return portalMenuMapper.selectMenuRel(menuNo, roleFlag);
    }

    /**
     * 查询所有菜单
     * @return
     */
    @Override
    public List<Menu> findAll() {
        return portalMenuMapper.selectAll();
    }

    /**
     * 查询菜单树图
     * @return
     */
    @Override
    public List<TreeViewDto> getMenuTree() {
        List<Menu> menus = portalMenuMapper.selectAll();
        List<Menu> collect = menus.stream().filter(item -> StringUtil.isEmpty(item.getParentMenuNo())).collect(Collectors.toList());
        return orgListToTree(collect, menus);
    }

    /**
     * 查询机构树图
     *
     * @param topNode 树图顶部节点
     * @param allDeps 所有树图列表
     * @return
     */
    private List<TreeViewDto> orgListToTree(List<Menu> topNode, List<Menu> allDeps) {
        return topNode.stream().map(item -> {
            TreeViewDto treeViewDto = new TreeViewDto();
            treeViewDto.setKey(item.getMenuNo());
            treeViewDto.setTitle(item.getMenuName());
            treeViewDto.setSlots(new TreeViewDto.SlotsEntity("menu"));

            List<Menu> childrenListr = allDeps.stream()
                    .filter(childItem -> item.getMenuNo().equals(childItem.getParentMenuNo())).collect(Collectors.toList());
            if (childrenListr != null && childrenListr.size() > 0) {
                treeViewDto.setSlots(new TreeViewDto.SlotsEntity("bars"));
                treeViewDto.setChildren(this.orgListToTree(childrenListr, allDeps));
            }
            return treeViewDto;
        }).collect(Collectors.toList());
    }

}
