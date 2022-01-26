package com.blog.cxx.service.service.impl;

import com.blog.cxx.service.entity.Comment;
import com.blog.cxx.service.mapper.CommentMapper;
import com.blog.cxx.service.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Cxx
 * @since 2022-01-26
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
