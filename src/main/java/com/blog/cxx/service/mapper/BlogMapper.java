package com.blog.cxx.service.mapper;

import com.blog.cxx.service.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.cxx.service.entity.vo.BlogInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    * 根据分类类别查询博客
    * */
    List<BlogInfo> getBlogInfoByTypeName(String typeName);
}
