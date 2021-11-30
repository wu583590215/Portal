package com.sxrcb.portal.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.sxrcb.portal.common.ServiceException;
import com.sxrcb.portal.dto.TreeViewDto;
import com.sxrcb.portal.mapper.DepartmentMapper;
import com.sxrcb.portal.entity.Department;
import com.sxrcb.portal.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Wuqian on 2021/10/12.
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentMapper portalDepartmentMapper;

    @Override
    public void save(Department portalDepartment) {
        portalDepartmentMapper.insert(portalDepartment);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteById(String id) {
        int i = portalDepartmentMapper.selectChildCount(id);
        if (i > 0) {
            throw new ServiceException("该机构存在下级机构，无法删除！");
        }
        portalDepartmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Department portalDepartment) {
        portalDepartmentMapper.updateByPrimaryKey(portalDepartment);
    }

    @Override
    public Department findById(String id) {
        return portalDepartmentMapper.selectByPrimaryKey(id);
    }


    /**
     * 获取机构树图
     * @return
     */
    @Override
    public List<TreeViewDto> getOrgTree() {
        List<Department> departments = portalDepartmentMapper.selectAll();
        List<Department> collect = departments.stream().filter(item -> StringUtil.isEmpty(item.getParentDepNo())).collect(Collectors.toList());
        return orgListToTree(collect, departments);
    }

    /**
     * @param topNode 树图顶部节点
     * @param allDeps 所有树图列表
     * @return
     */
    private List<TreeViewDto> orgListToTree(List<Department> topNode, List<Department> allDeps) {
        return topNode.stream().map(item -> {
            TreeViewDto treeViewDto = new TreeViewDto();
            treeViewDto.setKey(item.getDepNo());
            treeViewDto.setTitle(item.getDepName());
            treeViewDto.setSlots(new TreeViewDto.SlotsEntity("apartment"));

            List<Department> childrenListr = allDeps.stream()
                    .filter(childItem -> item.getDepNo().equals(childItem.getParentDepNo())).collect(Collectors.toList());
            if (childrenListr != null && childrenListr.size() > 0) {
                treeViewDto.setSlots(new TreeViewDto.SlotsEntity("bank"));
                treeViewDto.setChildren(this.orgListToTree(childrenListr,allDeps));
            }
            return treeViewDto;
        }).collect(Collectors.toList());
    }


}
