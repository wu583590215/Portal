package com.sxrcb.portal.service;
import com.sxrcb.portal.entity.Position;

import java.util.List;


/**
 * Created by Wuqian on 2021/10/12.
 */
public interface PositionService  {
    void save(Position model);
    void deleteById(String id);
    void update(Position model);
    Position findById(String id);
    List<Position> findAll(Position position);
}
