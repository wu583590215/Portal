package com.sxrcb.portal.mapper;

import com.sxrcb.portal.entity.Position;

import java.util.List;

/**
 * 岗位查询mapper
 * @author wuqian
 */
public interface PositionMapper {
    int deleteByPrimaryKey(String positionNo);

    int insert(Position record);

    Position selectByPrimaryKey(String positionNo);

    List<Position> selectAll(Position position);

    int updateByPrimaryKey(Position record);
}