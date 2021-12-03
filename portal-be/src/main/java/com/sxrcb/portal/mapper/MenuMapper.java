package com.sxrcb.portal.mapper;

import com.sxrcb.portal.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单查询mapper
 * @author wuqian
 */
public interface MenuMapper {
    int deleteMenu(String menuNo);

    int deleteAllMenuRel(String menuNo);

    int deleteMenuRel(@Param("deleteList") List<String> deleteList,
                      @Param("menuNo") String menuNo,
                      @Param("relativeType") String relativeType
    );

    List<String> selectMenuRel(@Param("menuNo") String menuNo,
                               @Param("relativeType") String relativeType);

    int insert(Menu record);

    int insertMenuRel(@Param("noList") List<String> noList,
                      @Param("menuNo") String menuNo,
                      @Param("type") String type);

    Menu selectByPrimaryKey(String menuNo);

    List<Menu> selectAll();

    int updateByPrimaryKey(Menu record);
}