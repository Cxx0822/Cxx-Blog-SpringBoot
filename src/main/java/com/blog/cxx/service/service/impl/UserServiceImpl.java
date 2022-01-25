package com.blog.cxx.service.service.impl;

import com.blog.cxx.service.entity.User;
import com.blog.cxx.service.mapper.UserMapper;
import com.blog.cxx.service.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Cxx
 * @since 2022-01-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
