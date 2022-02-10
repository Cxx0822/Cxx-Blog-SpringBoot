package com.blog.cxx.service.service;

import com.blog.cxx.service.entity.Role;
import com.blog.cxx.service.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Cxx
 * @since 2022-01-26
 */
public interface UserService extends IService<User> {
    // 查询
    List<User> query(String columnName, String columnValue);

    // 注册用户
    Integer create(User user);

    // 删除用户及其角色信息
    Boolean delete(String columnName, String columnValue);

    Integer update(User user, User dbUser);

    String login(User user);

    // 获取单个用户的角色信息
    HashMap<String, Object> getRoleInfo(String username);


    // 分配用户角色
    Boolean assignUserRole(User user, Role role);
}
