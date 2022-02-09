package com.blog.cxx.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blog.cxx.service.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.cxx.service.entity.vo.BlogInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Cxx
 * @since 2022-01-26
 */
public interface BlogService extends IService<Blog> {
    /*
    * 根据用户名查询博客
    * */
    IPage<BlogInfo> getBlogByUsername(IPage<BlogInfo> page, String username, Boolean isPublic);

    /*
     * 根据用户名和类别查询博客
     * */
    IPage<BlogInfo> getBlogByUsernameAndTypeName(IPage<BlogInfo> page, String username, String typeName, Boolean isPublic);
}
