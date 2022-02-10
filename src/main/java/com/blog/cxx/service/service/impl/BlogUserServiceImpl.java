package com.blog.cxx.service.service.impl;

import com.blog.cxx.service.entity.BlogUser;
import com.blog.cxx.service.mapper.BlogUserMapper;
import com.blog.cxx.service.service.BlogUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Cxx
 * @since 2022-02-09
 */
@Service
public class BlogUserServiceImpl extends ServiceImpl<BlogUserMapper, BlogUser> implements BlogUserService {

}
