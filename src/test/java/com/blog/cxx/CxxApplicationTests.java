package com.blog.cxx;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.cxx.service.entity.Blog;
import com.blog.cxx.service.entity.vo.BlogInfo;
import com.blog.cxx.service.mapper.BlogMapper;
import com.blog.cxx.service.service.BlogService;
import io.swagger.models.auth.In;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CxxApplicationTests {

    @Autowired
    BlogService blogService;

    @Autowired
    BlogMapper blogMapper;

    @Test
    void contextLoads() {
        Page<Blog> blogPage = blogMapper.selectPage(new Page<>(1, 2), null);
        blogPage.getRecords().forEach(System.out::println);
    }

}
