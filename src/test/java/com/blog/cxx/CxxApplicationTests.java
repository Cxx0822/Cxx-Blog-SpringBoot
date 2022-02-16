package com.blog.cxx;

import com.blog.cxx.service.entity.vo.UserInfo;
import com.blog.cxx.service.mapper.BlogMapper;
import com.blog.cxx.service.mapper.TypeMapper;
import com.blog.cxx.service.mapper.UserMapper;
import com.blog.cxx.service.service.BlogService;
import com.blog.cxx.service.service.TypeService;
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

    @Autowired
    TypeService typeService;

    @Autowired
    TypeMapper typeMapper;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        List<UserInfo> userInfoList = userMapper.getAllUsers();
        System.out.println(userInfoList);
    }

}
