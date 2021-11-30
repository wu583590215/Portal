package com.sxrcb.portal.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.sxrcb.portal.dto.MenuEditDto;
import com.sxrcb.portal.dto.TreeViewDto;
import com.sxrcb.portal.entity.Department;
import com.sxrcb.portal.mapper.MenuMapper;
import com.sxrcb.portal.entity.Menu;
import com.sxrcb.portal.service.MenuService;
import org.springframework.beans.BeanUtils;
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

    @Override
    public void save(Menu portalMenu) {
        portalMenuMapper.insert(portalMenu);
    }

    @Override
    public void deleteById(String id) {
        portalMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Menu portalMenu) {
        portalMenuMapper.updateByPrimaryKey(portalMenu);
    }

    @Override
    public MenuEditDto findById(String id) {
        Menu menu = portalMenuMapper.selectByPrimaryKey(id);
        MenuEditDto dto = new MenuEditDto();
        BeanUtils.copyProperties(menu, dto);
        return null;
    }

    @Override
    public List<Menu> findAll() {
        return portalMenuMapper.selectAll();
    }

    @Override
    public List<TreeViewDto> getMenuTree() {
        List<Menu> menus = portalMenuMapper.selectAll();
        List<Menu> collect = menus.stream().filter(item -> StringUtil.isEmpty(item.getParentMenuNo())).collect(Collectors.toList());
        return orgListToTree(collect, menus);
    }


    /**
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
                treeViewDto.setChildren(this.orgListToTree(childrenListr,allDeps));
            }
            return treeViewDto;
        }).collect(Collectors.toList());
    }

}
