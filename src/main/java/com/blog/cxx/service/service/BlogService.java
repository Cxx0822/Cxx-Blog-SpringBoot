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
    * 通过分类类别查询公开的博客信息
    * */
    IPage<BlogInfo> getBlogInfoByTypeName(Integer currentPage, Integer pageSize, String typeName);
}
