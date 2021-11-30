package com.sxrcb.portal.controller;
import com.sxrcb.portal.common.Result;
import com.sxrcb.portal.common.ResultGenerator;
import com.sxrcb.portal.entity.Position;
import com.sxrcb.portal.entity.Role;
import com.sxrcb.portal.service.PositionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
* Position控制层代码
* @date 2021/10/12
* @author Wuqian
*/
@RestController
@RequestMapping("/position")
public class PositionController {
    @Resource
    private PositionService positionService;

    /**
    * 新增记录
    * @param position 实体对象
    * @return 结果
    */
    @PostMapping("/add")
    public Result add(@RequestBody Position position) {
        positionService.save(position);
        return ResultGenerator.genSuccessResult();
    }

    /**
    * 删除记录
    * @param id 主键
    * @return 结果
    */
    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        positionService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    /**
    * 更新记录
    * @param position 实体对象
    * @return 结果
    */
    @PostMapping("/update")
    public Result update(@RequestBody Position position) {
        positionService.update(position);
        return ResultGenerator.genSuccessResult();
    }

    /**
    * 通过主键查询记录
    * @param id 主键
    * @return 结果
    */
    @PostMapping("/detail")
    public Result<Position> detail(@RequestParam String id) {
        Position position = positionService.findById(id);
        return ResultGenerator.genSuccessResult(position);
    }


    /**
    * 分页查询记录，默认查询所有
    * @param page 页码
    * @param size 每页记录数
    * @return
    */
    @PostMapping("/list")
    public Result<PageInfo<Position>> list(@RequestBody(required = false) Position position,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Position> list = positionService.findAll(position);
        PageInfo<Position> pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
