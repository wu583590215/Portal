package com.sxrcb.portal.mapper;

import com.sxrcb.portal.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int updatePassword(@Param("userNo") String userNo, @Param("password") String password);

    int deleteByPrimaryKey(String userNo);

    int resetPassword(String userNo, String password);

    int insert(User record);

    User selectByPrimaryKey(String userNo);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    List<String> selectUserPositions(String userNo);

    List<String> selectRoles(String userNo);

    int insertPositions(@Param("posList") List<String> posList, @Param("userNo") String userNo);

    int deletePositions(@Param("posList") List<String> posList, @Param("userNo") String userNo);

    int deleteAllPositions(@Param("userNo") String userNo);

    int insertRoles(@Param("roleList") List<String> roleList, @Param("userNo") String userNo);

    int deleteRoles(@Param("roleList") List<String> roleList, @Param("userNo") String userNo);

    int deleteAllRoles(@Param("userNo") String userNo);


}