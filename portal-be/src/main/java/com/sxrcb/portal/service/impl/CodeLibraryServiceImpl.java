package com.sxrcb.portal.service.impl;

import com.sxrcb.portal.mapper.CodeLibraryMapper;
import com.sxrcb.portal.entity.CodeLibrary;
import com.sxrcb.portal.service.CodeLibraryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by Wuqian on 2021/11/03.
 */
@Service
@Transactional
public class CodeLibraryServiceImpl implements CodeLibraryService {
    @Resource
    private CodeLibraryMapper portalCodeLibraryMapper;

    /**
     * 查询代码
     *
     * @param codeType
     * @return
     */
    @Override
    public Map<String, List<CodeLibrary>> findByCodeType(List<String> codeType) {
        List<CodeLibrary> codeLibraries = portalCodeLibraryMapper.selectAll(codeType);
        return codeLibraries.stream()
                .collect(Collectors.groupingBy(CodeLibrary::getCodeType));

    }

}
