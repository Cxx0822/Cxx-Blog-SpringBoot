package com.blog.cxx.service.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.cxx.service.entity.Blog;
import com.blog.cxx.service.entity.vo.BlogInfo;
import com.blog.cxx.service.mapper.BlogMapper;
import com.blog.cxx.service.mapper.TypeMapper;
import com.blog.cxx.service.result.R;
import com.blog.cxx.service.service.BlogService;
import com.blog.cxx.service.service.TypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * 查询所有博客
     * */
    @ApiOperation("查询所有博客")
    @GetMapping("/listAll")
    public R listAll() {
        List<Blog> blogList = blogService.list();
        return R.ok().data("blogList", blogList);
    }

    /*
     * 分页 根据用户名查询博客
     * */
    @ApiOperation("根据用户名查询博客")
    @GetMapping("/getBlogByUsername")
    public R getBlogByUsername(@RequestParam String username,
                               @RequestParam Boolean isPublic,
                               @RequestParam(defaultValue = "1") Integer currentPage,
                               @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<BlogInfo> blogInfoPage = new Page<>(currentPage, pageSize);
        IPage<BlogInfo> blogIPage = blogService.getBlogByUsername(blogInfoPage, username, isPublic);

        return R.ok().data("blogIPage", blogIPage);
    }

    /*
     * 分页 根据用户名和类别查询博客
     * */
    @ApiOperation("根据用户名和类别查询博客")
    @GetMapping("/getBlogByUsernameAndType")
    public R getBlogByUsernameAndType(@RequestParam String username,
                                      @RequestParam String typeName,
                                      @RequestParam Boolean isPublic,
                                      @RequestParam(defaultValue = "1") Integer currentPage,
                                      @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<BlogInfo> blogInfoPage = new Page<>(currentPage, pageSize);
        IPage<BlogInfo> blogIPage = blogService.getBlogByUsernameAndTypeName(blogInfoPage, username, typeName, isPublic);

        return R.ok().data("blogIPage", blogIPage);
    }

    /*
     * 查询某个公开博客详情
     * */
    @ApiOperation("查询某个公开博客")
    @GetMapping("/getPublicBlog/{id}")
    public R getBlogById(@PathVariable(name = "id") Integer blogId) {
        BlogInfo blogInfo = blogMapper.getBlogInfoById(blogId);
        if (blogInfo == null) {
            return R.error().message("查询失败，没有该博客信息");
        } else {
            if (blogInfo.getStatus() != 1) {
                return R.error().message("该博客未公开");
            } else {
                return R.ok().data("blogInfo", blogInfo);
            }
        }
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
     * 根据id更新博客
     * */
    @ApiOperation("根据id更新博客")
    @PostMapping("/updateById")
    public R updateById(@RequestBody Blog blog, @RequestParam Integer blogId) {
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
     * 根据名称更新博客
     * */
    @ApiOperation("根据名称更新博客")
    @PostMapping("/updateByName")
    public R updateByName(@RequestBody Blog blog, @RequestParam String title) {
        blogQueryWrapper.clear();
        blogQueryWrapper.eq("title", title);
        boolean result = blogService.update(blog, blogQueryWrapper);
        if (result) {
            return R.ok().message("更新成功");
        } else {
            return R.error().message("更新失败");
        }
    }

    /*
     * 根据id删除博客
     * */
    @ApiOperation("根据id删除博客")
    @DeleteMapping("/deleteById")
    public R deleteById(@RequestParam Integer blogId) {
        blogQueryWrapper.clear();
        blogQueryWrapper.eq("id", blogId);
        int delete = blogMapper.delete(blogQueryWrapper);
        if (delete != 0) {
            return R.ok().message("删除成功");
        } else {
            return R.error().message("删除失败");
        }
    }

    /*
     * 根据名称删除博客
     * */
    @ApiOperation("根据名称删除博客")
    @DeleteMapping("/deleteByName")
    public R deleteByName(@RequestParam String title) {
        blogQueryWrapper.clear();
        blogQueryWrapper.eq("title", title);
        int delete = blogMapper.delete(blogQueryWrapper);
        if (delete != 0) {
            return R.ok().message("删除成功");
        } else {
            return R.error().message("删除失败");
        }
    }
}
