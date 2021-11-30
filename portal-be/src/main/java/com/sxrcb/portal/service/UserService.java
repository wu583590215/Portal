package com.sxrcb.portal.service;
import com.sxrcb.portal.dto.EditPasswordDto;
import com.sxrcb.portal.dto.UserRoleEditDto;
import com.sxrcb.portal.entity.User;

import java.util.List;


/**
 * Created by Wuqian on 2021/10/26.
 */
public interface UserService  {
    void editPassword(EditPasswordDto editPasswordDto);
    void save(User model);
    void deleteById(String id);
    void resetPassword(String id);
    void update(User model);
    User findById(String id);
    List<User> findAll();
    List<String> posList(String userNo);
    List<String> roleList(String userNo);
    void editUserPosition(UserRoleEditDto editUserPosition);
    void editUserRole(UserRoleEditDto editUserPosition);
}
