package com.blog.cxx.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blog.cxx.service.entity.Blog;
import com.blog.cxx.service.entity.Type;
import com.blog.cxx.service.entity.vo.BlogTypeInfo;
import com.blog.cxx.service.mapper.BlogMapper;
import com.blog.cxx.service.mapper.TypeMapper;
import com.blog.cxx.service.service.TypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Cxx
 * @since 2022-01-26
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {
    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogMapper blogMapper;

    private final QueryWrapper<Blog> blogQueryWrapper = new QueryWrapper<>();

    @Override
    public ArrayList<BlogTypeInfo> getBlogTypeAndNumbers() {
        // 获取所有的类别信息
        List<Type> typeList = typeService.list();
        // 博客类别信息数组
        ArrayList<BlogTypeInfo> blogTypeInfoArrayList = new ArrayList<>();

        for (Type type: typeList) {
            blogQueryWrapper.clear();
            blogQueryWrapper.eq("type_id", type.getId());
            // 查询该类别的个数
            Long selectCount = blogMapper.selectCount(blogQueryWrapper);

            BlogTypeInfo blogTypeInfo = new BlogTypeInfo();
            blogTypeInfo.setTypeName(type.getTypeName());
            blogTypeInfo.setTypeNumber(selectCount);
            // 添加类别信息和类别个数
            blogTypeInfoArrayList.add(blogTypeInfo);
        }

        return blogTypeInfoArrayList;
    }
}
