package com.sxrcb.portal.service;
import com.sxrcb.portal.dto.TreeViewDto;
import com.sxrcb.portal.entity.Department;

import java.util.List;


/**
 * Created by Wuqian on 2021/10/12.
 */
public interface DepartmentService  {
    void save(Department model);
    void deleteById(String id);
    void update(Department model);
    Department findById(String id);
    List<TreeViewDto> getOrgTree();
}
