package com.blog.cxx.service.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.cxx.service.entity.Blog;
import com.blog.cxx.service.mapper.BlogMapper;
import com.blog.cxx.service.result.R;
import com.blog.cxx.service.service.BlogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Cxx
 * @since 2022-01-26
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    BlogMapper blogMapper;

    /*
     * 分页查询公开的博客 按创建时间排序
     * */
    @ApiOperation("查询公开博客信息")
    @GetMapping("/getPublicBlogs")
    public R getPublicBlogs(@RequestParam(defaultValue = "1") Integer currentPage){
        // 参数一是当前页，参数二是每页个数
        IPage<Blog> blogIPage = new Page<>(currentPage, 5);

        // 查询条件
        QueryWrapper<Blog> blogQueryWrapper = new QueryWrapper<>();
        blogQueryWrapper.eq("status", 1).orderByDesc("create_time");

        // 第一个参数为分页参数，第二个参数为查询条件参数
        blogIPage = blogMapper.selectPage(blogIPage, blogQueryWrapper);
        List<Blog> blogList = blogIPage.getRecords();

        return R.ok().data("blogList", blogList);
    }

    /*
     * 创建博客
     * */
    @ApiOperation("创建博客")
    @PostMapping("/create")
    public R create(@RequestBody Blog blog){

        boolean result = blogService.save(blog);
        if (result){
            return R.ok().message("创建成功");
        } else {
            return R.error().message("创建失败");
        }
    }

    /*
    * 查询所有博客
    * */
    @ApiOperation("查询所有博客")
    @GetMapping("/listAll")
    public R listAll(){
        List<Blog> blogList = blogService.list();
        return R.ok().data("blogList", blogList);
    }
}
