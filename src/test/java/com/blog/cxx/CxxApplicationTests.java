package com.blog.cxx;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.cxx.service.entity.Blog;
import com.blog.cxx.service.entity.Type;
import com.blog.cxx.service.entity.vo.BlogInfo;
import com.blog.cxx.service.mapper.BlogMapper;
import com.blog.cxx.service.mapper.TypeMapper;
import com.blog.cxx.service.service.BlogService;
import com.blog.cxx.service.service.TypeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class CxxApplicationTests {

    @Autowired
    BlogService blogService;

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    TypeService typeService;

    @Autowired
    TypeMapper typeMapper;

    @Test
    void contextLoads() {
        QueryWrapper<Blog> blogQueryWrapper = new QueryWrapper<>();
        BlogInfo blogInfo = blogMapper.getBlogInfoById(1);
        System.out.println((blogInfo));
    }

}
