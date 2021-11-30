package com.sxrcb.portal.service;
import com.sxrcb.portal.dto.MenuEditDto;
import com.sxrcb.portal.dto.TreeViewDto;
import com.sxrcb.portal.entity.Menu;
import java.util.List;



/**
 * Created by Wuqian on 2021/11/18.
 */
public interface MenuService {
    void save(Menu model);
    void deleteById(String id);
    void update(Menu model);
    MenuEditDto findById(String id);
    List<Menu> findAll();
    List<TreeViewDto> getMenuTree();
 }
