package com.sxrcb.portal.controller;

import com.sxrcb.portal.common.Result;
import com.sxrcb.portal.common.ResultGenerator;
import com.sxrcb.portal.service.CodeLibraryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
* CodeLibrary控制层代码
* @date 2021/11/03
* @author Wuqian
*/
@RestController
@RequestMapping("/code")
public class CodeLibraryController {
    @Resource
    private CodeLibraryService codeLibraryService;


    /**
    * 获取码值信息
    * @param codeType 主键
    * @return 结果
    */
    @PostMapping("/getLibrary")
    public Result getCodeLibrary(@RequestBody List<String> codeType) {
        return ResultGenerator.genSuccessResult(codeLibraryService.findByCodeType(codeType));
    }

}
