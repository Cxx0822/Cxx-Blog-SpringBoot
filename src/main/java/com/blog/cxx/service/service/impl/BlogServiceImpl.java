package com.blog.cxx.service.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.cxx.service.entity.Blog;
import com.blog.cxx.service.entity.vo.BlogInfo;
import com.blog.cxx.service.mapper.BlogMapper;
import com.blog.cxx.service.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    @Override
    public IPage<BlogInfo> getBlogInfoByTypeName(Integer currentPage, Integer pageSize, String typeName) {
        // 根据类别查询出所有博客
        List<BlogInfo> list = blogMapper.getBlogInfoByTypeName(typeName);

        if (list.size() == 0) {
            return null;
        }

        // 分类查询到的博客
        // 定义Page类
        IPage<BlogInfo> blogInfoPage = new Page<>();

        // 查询到的博客数
        int size = list.size();

        // 求出最大页数，防止currentPage越界
        pageSize = Math.min(pageSize, size);
        int maxPage = size % pageSize == 0 ? size / pageSize : size / pageSize + 1;

        currentPage = Math.min(currentPage, maxPage);

        // 当前页第一条数据的下标
        int curIdx = currentPage > 1 ? (currentPage - 1) * pageSize : 0;

        List<BlogInfo> pageList = new ArrayList<>();
        // 将当前页的数据放进pageList
        for (int i = 0; i < pageSize && curIdx + i < size; i++) {
            pageList.add(list.get(curIdx + i));
        }

        blogInfoPage.setCurrent(currentPage).setSize(pageSize).setTotal(list.size()).setRecords(pageList);

        return blogInfoPage;
    }
}
