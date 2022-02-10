package com.blog.cxx.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blog.cxx.service.entity.Blog;
import com.blog.cxx.service.entity.BlogType;
import com.blog.cxx.service.entity.Type;
import com.blog.cxx.service.entity.vo.BlogTypeInfo;
import com.blog.cxx.service.mapper.BlogMapper;
import com.blog.cxx.service.mapper.BlogTypeMapper;
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
    private TypeMapper typeMapper;

    @Autowired
    private BlogTypeMapper blogTypeMapper;

    @Override
    public List<Type> query(String columnName, String columnValue) {
        QueryWrapper<Type> typeQueryWrapper = new QueryWrapper<>();
        typeQueryWrapper.eq(columnName, columnValue);

        return typeMapper.selectList(typeQueryWrapper);
    }

    @Override
    public ArrayList<BlogTypeInfo> getBlogTypeAndNumbers() {
        // 获取所有的类别信息
        QueryWrapper<Type> typeQueryWrapper = new QueryWrapper<>();
        List<Type> typeList = typeMapper.selectList(typeQueryWrapper);
        // 博客类别信息数组
        ArrayList<BlogTypeInfo> blogTypeInfoArrayList = new ArrayList<>();

        QueryWrapper<BlogType> blogTypeQueryWrapper = new QueryWrapper<>();

        for (Type type: typeList) {
            blogTypeQueryWrapper.clear();
            blogTypeQueryWrapper.eq("type_id", type.getId());
            // 查询该类别的个数
            Long selectCount = blogTypeMapper.selectCount(blogTypeQueryWrapper);

            BlogTypeInfo blogTypeInfo = new BlogTypeInfo();
            blogTypeInfo.setTypeName(type.getTypeName());
            blogTypeInfo.setTypeNumber(selectCount);
            // 添加类别信息和类别个数
            blogTypeInfoArrayList.add(blogTypeInfo);
        }

        return blogTypeInfoArrayList;
    }
}
