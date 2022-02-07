package com.blog.cxx.service.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.cxx.service.entity.Blog;
import com.blog.cxx.service.entity.Type;
import com.blog.cxx.service.entity.vo.BlogInfo;
import com.blog.cxx.service.entity.vo.BlogTypeInfo;
import com.blog.cxx.service.mapper.BlogMapper;
import com.blog.cxx.service.mapper.TypeMapper;
import com.blog.cxx.service.result.R;
import com.blog.cxx.service.service.BlogService;
import com.blog.cxx.service.service.TypeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 前端控制器
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

    @Autowired
    TypeService typeService;

    @Autowired
    TypeMapper typeMapper;

    private final QueryWrapper<Blog> blogQueryWrapper = new QueryWrapper<>();

    /*
     * 分页查询公开的博客 按创建时间排序
     * */
    @ApiOperation("查询公开博客信息")
    @GetMapping("/getPublicBlogs")
    public R getPublicBlogs(@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1")  Integer currentPage) {
        // 参数一是当前页，参数二是每页个数
        IPage<Blog> blogIPage = new Page<>(currentPage, pageSize);

        // 查询条件
        blogQueryWrapper.clear();
        blogQueryWrapper.eq("status", 1).orderByDesc("create_time");

        // 第一个参数为分页参数，第二个参数为查询条件参数
        blogIPage = blogMapper.selectPage(blogIPage, blogQueryWrapper);

        return R.ok().data("blogPage", blogIPage);
    }

    /*
     * 分页 分类查询公开的博客 按创建时间排序
     * */
    @ApiOperation("分类查询公开博客信息")
    @GetMapping("/getPublicBlogsByTypeName")
    public R getPublicBlogsByTypeName(@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam String typeName) {
        // 每页个数
        Integer pageSize = 10;
        List<BlogInfo> blogInfoList = blogService.getBlogInfoByTypeName(currentPage, pageSize, typeName);

        if (blogInfoList.size() == 0) {
            return R.error().message("查询失败，未查询到博客信息");
        } else {
            return R.ok().data("blogInfoList", blogInfoList);
        }
    }

    /*
     * 查询博客类别及每类的个数
     * */
    @ApiOperation("查询博客类别及每类的个数")
    @GetMapping("/getBlogTypeAndNumbers")
    public R getBlogTypeAndNumbers() {
        QueryWrapper<Blog> blogQueryWrapper = new QueryWrapper<>();

        List<Type> typeList = typeService.list();
        // 博客类别信息数组
        ArrayList<BlogTypeInfo> blogTypeInfoArrayList = new ArrayList<>();

        for (Type type: typeList) {
            blogQueryWrapper.clear();
            blogQueryWrapper.eq("type_id", type.getId());
            Long selectCount = blogMapper.selectCount(blogQueryWrapper);

            BlogTypeInfo blogTypeInfo = new BlogTypeInfo();
            blogTypeInfo.setTypeName(type.getTypeName());
            blogTypeInfo.setTypeNumber(selectCount);

            blogTypeInfoArrayList.add(blogTypeInfo);
        }

        return R.ok().data("typeCountInfoList", blogTypeInfoArrayList);
    }

    /*
     * 创建博客
     * */
    @ApiOperation("创建博客")
    @PostMapping("/create")
    public R create(@RequestBody Blog blog) {
        boolean result = blogService.save(blog);
        if (result) {
            return R.ok().message("创建成功");
        } else {
            return R.error().message("创建失败");
        }
    }

    /*
     * 更新博客
     * */
    @ApiOperation("更新博客")
    @PostMapping("/update")
    public R update(@RequestBody Blog blog, @RequestParam Integer blogId) {
        blogQueryWrapper.clear();
        blogQueryWrapper.eq("id", blogId);
        boolean result = blogService.update(blog, blogQueryWrapper);
        if (result) {
            return R.ok().message("更新成功");
        } else {
            return R.error().message("更新失败");
        }
    }

    /*
    * 查看某个公开博客详情
    * */
    @ApiOperation("查询某个公开博客")
    @GetMapping("/getPublicBlog/{id}")
    public R getBlogById(@PathVariable(name="id") Integer blogId){
        Blog blog = blogService.getById(blogId);
        if (blog.getStatus() != 1) {
            return R.error().message("该博客未公开");
        }else {
            return R.ok().data("blog", blog);
        }
    }
    /*
     * 查询所有博客
     * */
    @ApiOperation("查询所有博客")
    @GetMapping("/listAll")
    public R listAll() {
        List<Blog> blogList = blogService.list();
        return R.ok().data("blogList", blogList);
    }

    /*
    * 分页查询所有博客 包括未公开
    * */
    @ApiOperation("分页查询所有博客")
    @GetMapping("/listAllByPage")
    public R listAllByPage(@RequestParam(defaultValue = "1") Integer currentPage,@RequestParam(defaultValue = "10") Integer pageSize){
        IPage<Blog> blogIPage = new Page<>(currentPage, pageSize);

        // 查询条件
        blogQueryWrapper.clear();
        blogQueryWrapper.orderByDesc("create_time");

        blogIPage = blogMapper.selectPage(blogIPage, blogQueryWrapper);
        List<Blog> blogList = blogIPage.getRecords();

        return R.ok().data("blogList", blogList);
    }
}
