package com.sxrcb.portal.service;
import com.sxrcb.portal.dto.TreeViewDto;
import com.sxrcb.portal.entity.Department;

import java.util.List;


/**
 * Created by Wuqian on 2021/10/12.
 */
public interface DepartmentService  {
    /**
     * 保存
     * @param model 实体对象
     */
    void save(Department model);

    /**
     * 用主键删除
     * @param id 主键
     */
    void deleteById(String id);

    /**
     * 更新
     * @param model 实体对象
     */
    void update(Department model);

    /**
     * 通过主键查询
     * @param id
     * @return 实体对象
     */
    Department findById(String id);

    /**
     * 获取机构树图
     * @return
     */
    List<TreeViewDto> getOrgTree();
}
