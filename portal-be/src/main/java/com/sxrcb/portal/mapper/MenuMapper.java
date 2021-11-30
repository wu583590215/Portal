package com.sxrcb.portal.mapper;

import com.sxrcb.portal.entity.Menu;
import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(String menuNo);

    int insert(Menu record);

    Menu selectByPrimaryKey(String menuNo);

    List<Menu> selectAll();

    int updateByPrimaryKey(Menu record);
}