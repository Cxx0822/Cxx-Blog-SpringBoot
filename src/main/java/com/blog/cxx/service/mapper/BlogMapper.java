package com.blog.cxx.service.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blog.cxx.service.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.cxx.service.entity.vo.BlogInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Cxx
 * @since 2022-01-26
 */
@Mapper
@Repository
public interface BlogMapper extends BaseMapper<Blog> {
    /*
     * 查询所有博客
     * 加上分页参数，需要放在第一个参数位置，下同
     * */
    IPage<BlogInfo> getAllBlogInfo(IPage<BlogInfo> blogInfoIPage);

    /*
     * 查询所有公开博客
     * */
    IPage<BlogInfo> getPublicBlogInfo(IPage<BlogInfo> blogInfoIPage);

    /*
     * 根据用户查询所有博客
     * */
    IPage<BlogInfo> getAllBlogInfoByUsername(IPage<BlogInfo> blogInfoIPage, String username);

    /*
     * 根据用户查询所有公开博客
     * */
    IPage<BlogInfo> getPublicBlogInfoByUsername(IPage<BlogInfo> blogInfoIPage, String username);

    /*
     * 根据用户和类别查询所有博客
     * */
    IPage<BlogInfo> getAllBlogInfoByUsernameAndTypeName(IPage<BlogInfo> blogInfoIPage, String username, String typeName);

    /*
     * 根据用户和类别查询所有公开博客
     * */
    IPage<BlogInfo> getPublicBlogInfoByUsernameAndTypeName(IPage<BlogInfo> blogInfoIPage, String username, String typeName);

    /*
    * 根据id查询博客信息
    * */
    BlogInfo getBlogInfoById(Integer blogId);
}
