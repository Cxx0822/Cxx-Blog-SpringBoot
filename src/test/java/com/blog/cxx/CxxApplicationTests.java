package com.blog.cxx;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
        // 查询条件
        QueryWrapper<Blog> blogQueryWrapper = new QueryWrapper<>();
        blogQueryWrapper.eq("status", 1).orderByDesc("create_time");
        Page<Blog> page=new Page<>(1,2);//当前页是1，每页2条记录
        System.out.println("cxx");
        //传入要进行的分页以及查询构造条件
        IPage<Blog> userIPage = blogMapper.selectPage(page, blogQueryWrapper);
        System.out.println("cxx2");
        System.out.println("总页数"+userIPage.getPages());//打印总页数
        System.out.println("总记录数数"+userIPage.getTotal());//总记录数
        List<Blog> userList=userIPage.getRecords();//获取当前页的内容，返回的是一个List集合
        userList.forEach(System.out::println);//遍历打印

    }

}
