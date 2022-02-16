package com.blog.cxx.service.service;

import com.blog.cxx.service.entity.RolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Cxx
 * @since 2022-02-16
 */
public interface RolePermissionService extends IService<RolePermission> {
    Integer delete(String columnName, String columnValue);
}
