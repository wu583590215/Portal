package com.sxrcb.portal.common;

import com.sxrcb.portal.entity.Department;

import java.util.List;

public interface Mapper<T> {
    int deleteByPrimaryKey(Object key);

    int insert(T record);

    T selectByPrimaryKey(Object key);

    List<T> selectAll();

    int updateByPrimaryKey(T record);
}
