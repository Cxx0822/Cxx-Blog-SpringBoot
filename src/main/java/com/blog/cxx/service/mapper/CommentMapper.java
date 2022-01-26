package com.blog.cxx.service.mapper;

import com.blog.cxx.service.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Cxx
 * @since 2022-01-25
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
