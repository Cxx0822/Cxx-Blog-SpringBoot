package com.blog.cxx;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.cxx.service.entity.Blog;
import com.blog.cxx.service.mapper.BlogMapper;
import com.blog.cxx.service.service.BlogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CxxApplicationTests {

    @Autowired
    BlogService blogService;

    @Autowired
    BlogMapper blogMapper;

    @Test
    void contextLoads() {
        List<Blog> blogList = blogMapper.selectList(null);
        System.out.println((blogList));

    }

}
