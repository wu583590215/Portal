package com.sxrcb.portal.mapper;

import com.sxrcb.portal.entity.CodeLibrary;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 码值表查询
 * @author wuqian
 */
public interface CodeLibraryMapper {
    List<CodeLibrary> selectAll(List<String> codeType);
}