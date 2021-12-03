package com.sxrcb.portal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxrcb.portal.common.Result;
import com.sxrcb.portal.common.ResultGenerator;
import com.sxrcb.portal.dto.MenuRoleEditDto;
import com.sxrcb.portal.dto.TreeViewDto;
import com.sxrcb.portal.entity.Menu;
import com.sxrcb.portal.service.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
* Menu控制层代码
* @date 2021/11/18
* @author Wuqian
*/
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;

    /**
    * 新增记录
    * @param menu 实体对象
    * @return 结果
    */
    @PostMapping("/add")
    public Result add(@RequestBody Menu menu) {
        menuService.save(menu);
        return ResultGenerator.genSuccessResult();
    }

    /**
    * 删除记录
    * @param id 主键
    * @return 结果
    */
    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        menuService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    /**
    * 更新记录
    * @param menu 实体对象
    * @return 结果
    */
    @PostMapping("/update")
    public Result update(@RequestBody Menu menu) {
        menuService.update(menu);
        return ResultGenerator.genSuccessResult();
    }


    /**
     * 查询菜单的权限
     * @param menuNo 菜单编号
     * @param roleFlag 权限标识
     * @return
     */
    @PostMapping("/roles")
    public Result findRoles(@RequestParam String menuNo,@RequestParam String roleFlag) {
        return ResultGenerator.genSuccessResult(menuService.findMenuRoles(menuNo, roleFlag));
    }

    /**
     * 修改菜单权限
     * @param menuRoleEditDto 修改
     * @return
     */
    @PostMapping("/editRoles")
    public Result editRoles(@RequestBody MenuRoleEditDto menuRoleEditDto) {
        menuService.editMenuRoles(menuRoleEditDto);
        return ResultGenerator.genSuccessResult();
    }

    /**
    * 通过主键查询记录
    * @param id 主键
    * @return 结果
    */
    @PostMapping("/detail")
    public Result<Menu> detail(@RequestParam String id) {
        Menu menu = menuService.findById(id);
        return ResultGenerator.genSuccessResult(menu);
    }


    /**
    * 分页查询记录，默认查询所有
    * @param page 页码
    * @param size 每页记录数
    * @return
    */
    @PostMapping("/list")
    public Result<PageInfo<Menu>> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Menu> list = menuService.findAll();
        PageInfo<Menu> pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    /**
     * 查询菜单树图
     * @return
     */
    @PostMapping("/getMenuTree")
    public Result<List<TreeViewDto>> getMenuTree() {
        return ResultGenerator.genSuccessResult(menuService.getMenuTree());
    }


}
