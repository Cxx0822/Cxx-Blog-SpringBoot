package com.blog.cxx.service.service;

import com.blog.cxx.service.entity.Type;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.cxx.service.entity.vo.BlogTypeInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Cxx
 * @since 2022-01-26
 */
public interface TypeService extends IService<Type> {
    List<Type> query(String columnName, String columnValue);

    ArrayList<BlogTypeInfo> getBlogTypeAndNumbers();
}
