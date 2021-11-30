package com.sxrcb.portal.service.impl;

import com.sxrcb.portal.common.ServiceException;
import com.sxrcb.portal.mapper.PositionMapper;
import com.sxrcb.portal.entity.Position;
import com.sxrcb.portal.service.PositionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;



/**
 * Created by Wuqian on 2021/10/12.
 */
@Service
@Transactional
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionMapper portalPositionMapper;

    @Override
    public void save(Position portalPosition) {
        Position position = portalPositionMapper.selectByPrimaryKey(portalPosition.getPositionNo());
        if (position == null) {
            portalPositionMapper.insert(portalPosition);
        }else {
            throw new ServiceException("存在重复的岗位编号！");
        }
    }

    @Override
    public void deleteById(String id) {
        portalPositionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Position portalPosition) {
        portalPositionMapper.updateByPrimaryKey(portalPosition);
    }

    @Override
    public Position findById(String id) {
        return portalPositionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Position> findAll(Position position) {
        return portalPositionMapper.selectAll(position);
    }


}
