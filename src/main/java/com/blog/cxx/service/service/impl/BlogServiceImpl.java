package com.blog.cxx.service.service.impl;

import com.blog.cxx.service.entity.Blog;
import com.blog.cxx.service.mapper.BlogMapper;
import com.blog.cxx.service.service.BlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
