package com.sxrcb.portal.mapper;

import com.sxrcb.portal.entity.Department;
import java.util.List;

/**
 * 岗位管理mapper
 * @author wuqian
 */
public interface DepartmentMapper {

    int deleteByPrimaryKey(String depNo);

    int insert(Department record);

    Department selectByPrimaryKey(String depNo);

    int selectChildCount(String depNo);

    List<Department> selectAll();

    int updateByPrimaryKey(Department record);
}