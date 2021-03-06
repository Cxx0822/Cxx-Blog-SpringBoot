package com.blog.cxx.service.service;

import com.blog.cxx.service.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Cxx
 * @since 2022-02-10
 */
public interface RoleService extends IService<Role> {
    // 查询
    List<Role> query(String columnName, String columnValue);

    Boolean delete(String columnName, String columnValue);

    Integer update(Role role);

    // 分配角色权限
    Boolean assignRoleMenu(Integer roleId, List<Integer> menuList);

    // 分配角色资源
    Boolean assignRolePermission(Integer roleId, List<Integer> permissionList);
}
