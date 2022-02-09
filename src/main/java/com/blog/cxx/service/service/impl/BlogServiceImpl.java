package com.blog.cxx.service.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.cxx.service.entity.Blog;
import com.blog.cxx.service.entity.vo.BlogInfo;
import com.blog.cxx.service.mapper.BlogMapper;
import com.blog.cxx.service.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Cxx
 * @since 2022-01-26
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
    @Autowired
    BlogMapper blogMapper;

    /*
    * 根据用户名获取博客信息
    * */
    @Override
    public IPage<BlogInfo> getBlogByUsername(IPage<BlogInfo> page, String username, Boolean isPublic) {
        IPage<BlogInfo> blogInfoIPage;
        if (isPublic) {
            blogInfoIPage = blogMapper.getPublicBlogInfoByUsername(page, username);
        } else {
            blogInfoIPage = blogMapper.getAllBlogInfoByUsername(page, username);
        }
        return blogInfoIPage;
    }

    /*
     * 根据用户名和类别获取博客信息
     * */
    @Override
    public IPage<BlogInfo> getBlogByUsernameAndTypeName(IPage<BlogInfo> page, String username, String typeName, Boolean isPublic) {
        IPage<BlogInfo> blogInfoIPage;
        if (isPublic) {
            blogInfoIPage = blogMapper.getPublicBlogInfoByUsernameAndTypeName(page, username, typeName);
        } else {
            blogInfoIPage = blogMapper.getAllBlogInfoByUsernameAndTypeName(page, username, typeName);
        }
        return blogInfoIPage;
    }
}
