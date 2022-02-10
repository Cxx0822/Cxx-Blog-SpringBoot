package com.blog.cxx.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blog.cxx.service.entity.*;
import com.blog.cxx.service.entity.vo.BlogInfo;
import com.blog.cxx.service.mapper.BlogMapper;
import com.blog.cxx.service.mapper.BlogTypeMapper;
import com.blog.cxx.service.mapper.BlogUserMapper;
import com.blog.cxx.service.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    BlogTypeMapper blogTypeMapper;

    @Autowired
    BlogUserMapper blogUserMapper;

    @Override
    public List<Blog> query(String columnName, String columnValue) {
        QueryWrapper<Blog> blogQueryWrapper = new QueryWrapper<>();
        blogQueryWrapper.eq(columnName, columnValue);

        return blogMapper.selectList(blogQueryWrapper);
    }

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

    /*
    * 分配博客类别信息
    * */
    @Override
    public Boolean setBlogType(Blog blog, Type type) {
        // 获取当前博客在 博客-类别信息表 中的状态
        UpdateWrapper<BlogType> blogTypeUpdateWrapper = new UpdateWrapper<>();
        blogTypeUpdateWrapper.eq("blog_id", blog.getId());

        BlogType blogType = blogTypeMapper.selectOne(blogTypeUpdateWrapper);

        // 如果不存在 则新建
        int insert = 0, update = 0;
        if (blogType == null) {
            BlogType newBlogType = new BlogType();
            newBlogType.setBlogId(blog.getId());
            newBlogType.setTypeId(type.getId());
            insert = blogTypeMapper.insert(newBlogType);
        } else {
            // 否则更新类别信息
            blogType.setTypeId(type.getId());
            update = blogTypeMapper.update(blogType, blogTypeUpdateWrapper);
        }

        if (insert != 0 || update != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean setBlogUser(Blog blog, User user) {
        // 获取当前博客在 博客-用户信息表 中的状态
        UpdateWrapper<BlogUser> blogUserUpdateWrapper = new UpdateWrapper<>();
        blogUserUpdateWrapper.eq("blog_id", blog.getId());

        BlogUser blogUser = blogUserMapper.selectOne(blogUserUpdateWrapper);

        // 如果不存在 则新建
        int insert = 0, update = 0;
        if (blogUser == null) {
            BlogUser newBlogUser = new BlogUser();
            newBlogUser.setBlogId(blog.getId());
            newBlogUser.setUserId(user.getId());
            insert = blogUserMapper.insert(newBlogUser);
        } else {
            // 否则更新类别信息
            blogUser.setUserId(user.getId());
            update = blogUserMapper.update(blogUser, blogUserUpdateWrapper);
        }

        if (insert != 0 || update != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteByName(String blogName) {
        // 删除博客
        QueryWrapper<Blog> blogQueryWrapper = new QueryWrapper<>();
        blogQueryWrapper.eq("title", blogName);
        Blog blog = blogMapper.selectOne(blogQueryWrapper);

        int deleteBlog = blogMapper.delete(blogQueryWrapper);

        // 删除类别信息
        int deleteType = 0;
        QueryWrapper<BlogType> blogTypeQueryWrapper = new QueryWrapper<>();
        blogTypeQueryWrapper.eq("blog_id", blog.getId());
        BlogType blogType = blogTypeMapper.selectOne(blogTypeQueryWrapper);
        if(blogType != null) {
            deleteType = blogTypeMapper.delete(blogTypeQueryWrapper);
        }

        // 删除用户信息
        int deleteUser = 0;
        QueryWrapper<BlogUser> blogUserQueryWrapper = new QueryWrapper<>();
        blogTypeQueryWrapper.eq("blog_id", blog.getId());
        BlogUser blogUser = blogUserMapper.selectOne(blogUserQueryWrapper);
        if(blogUser != null) {
            deleteUser = blogUserMapper.delete(blogUserQueryWrapper);
        }

        if (deleteBlog != 0 || deleteType != 0 || deleteUser != 0) {
            return true;
        } else {
            return false;
        }
    }
}
