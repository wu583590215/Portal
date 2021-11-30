package com.sxrcb.portal.mapper;

import com.sxrcb.portal.entity.CodeLibrary;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodeLibraryMapper {
    List<CodeLibrary> selectAll(List<String> codeType);
}