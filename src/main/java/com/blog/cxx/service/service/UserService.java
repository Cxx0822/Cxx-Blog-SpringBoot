package com.blog.cxx.service.service;

import com.blog.cxx.service.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
