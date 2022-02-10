package com.blog.cxx.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blog.cxx.service.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.cxx.service.entity.Type;
import com.blog.cxx.service.entity.User;
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
    // 查询
    List<Blog> query(String columnName, String columnValue);

    /*
    * 根据用户名查询博客
    * */
    IPage<BlogInfo> getBlogByUsername(IPage<BlogInfo> page, String username, Boolean isPublic);

    /*
     * 根据用户名和类别查询博客
     * */
    IPage<BlogInfo> getBlogByUsernameAndTypeName(IPage<BlogInfo> page, String username, String typeName, Boolean isPublic);

    /*
    * 分配博客类别信息
    * */
    Boolean setBlogType(Blog blog, Type type);

    /*
     * 分配博客作者信息
     * */
    Boolean setBlogUser(Blog blog, User user);

    /*
    * 删除博客及其关系表中的数据
    * */
    Boolean deleteByName(String blogName);
}
