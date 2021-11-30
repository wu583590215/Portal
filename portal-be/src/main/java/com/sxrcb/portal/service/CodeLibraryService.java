package com.sxrcb.portal.service;
import com.sxrcb.portal.entity.CodeLibrary;
import java.util.List;
import java.util.Map;


/**
 * Created by Wuqian on 2021/11/03.
 */
public interface CodeLibraryService {
    /**
     * 查询代码
     * @param codeType
     * @return
     */
    Map<String, List<CodeLibrary>> findByCodeType(List<String> codeType);
 }
