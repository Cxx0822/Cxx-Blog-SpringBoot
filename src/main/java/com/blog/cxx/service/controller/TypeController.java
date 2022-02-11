package com.blog.cxx.service.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.cxx.service.entity.Type;
import com.blog.cxx.service.entity.vo.BlogTypeInfo;
import com.blog.cxx.service.mapper.BlogMapper;
import com.blog.cxx.service.mapper.TypeMapper;
import com.blog.cxx.service.result.R;
import com.blog.cxx.service.service.BlogService;
import com.blog.cxx.service.service.TypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
@RequestMapping("/type")
public class TypeController {
    @Autowired
    BlogService blogService;

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    TypeService typeService;

    @Autowired
    TypeMapper typeMapper;


    private final QueryWrapper<Type> typeQueryWrapper = new QueryWrapper<>();

    @ApiOperation("查询所有分类")
    @GetMapping("/listAll")
    public R listAll(){
        List<Type> typeList = typeService.list();
        return R.ok().data("typeList", typeList);
    }

    @ApiOperation("分页查询所有类别")
    @GetMapping("/getAllTypeInfo")
    public R getAllTypeInfo(@RequestParam(defaultValue = "1") Integer currentPage,
                            @RequestParam(defaultValue = "10") Integer pageSize){
        Page<Type> typePage = new Page<>(currentPage, pageSize);
        QueryWrapper<Type> typeQueryWrapper = new QueryWrapper<>();

        IPage<Type> typeIPage = typeMapper.selectPage(typePage, typeQueryWrapper);

        return R.ok().data("typeIPage", typeIPage);
    }

    /*
     * 查询博客类别及每类的个数
     * */
    @ApiOperation("查询博客类别及每类的个数")
    @GetMapping("/getBlogTypeAndNumbers")
    public R getBlogTypeAndNumbers() {
        // TODO:根据用户名区分！
        ArrayList<BlogTypeInfo> blogTypeInfoArrayList = typeService.getBlogTypeAndNumbers();

        return R.ok().data("typeCountInfoList", blogTypeInfoArrayList);
    }

    @ApiOperation("增加分类")
    @PostMapping("/create")
    public R create(@RequestBody Type type){
        typeQueryWrapper.clear();
        typeQueryWrapper.eq("type_name", type.getTypeName());
        List<Type> typeList = typeMapper.selectList(typeQueryWrapper);

        if (typeList.size() == 0){
            boolean result = typeService.save(type);
            if (result){
                return R.ok().message("增加成功");
            } else {
                return R.error().message("增加失败");
            }
        } else {
            return R.error().message("增加失败，已经存在该分类");
        }
    }

    /*
     * 根据id更新分类信息
     * */
    @ApiOperation("根据id更新分类")
    @PostMapping("/updateById")
    public R updateById(@RequestBody Type type, @RequestParam Integer typeId) {
        typeQueryWrapper.clear();
        typeQueryWrapper.eq("id", typeId);
        boolean result = typeService.update(type, typeQueryWrapper);
        if (result) {
            return R.ok().message("更新成功");
        } else {
            return R.error().message("更新失败");
        }
    }

    /*
     * 根据名称更新分类信息
     * */
    @ApiOperation("根据名称更新分类")
    @PostMapping("/updateByName")
    public R updateByName(@RequestBody Type type, @RequestParam String typeName) {
        typeQueryWrapper.clear();
        typeQueryWrapper.eq("type_name", typeName);
        boolean result = typeService.update(type, typeQueryWrapper);
        if (result) {
            return R.ok().message("更新成功");
        } else {
            return R.error().message("更新失败");
        }
    }

    @ApiOperation("根据id删除分类")
    @DeleteMapping("/deleteById")
    public R deleteById(@RequestParam Integer id){
        typeQueryWrapper.clear();
        typeQueryWrapper.eq("id", id);
        int delete = typeMapper.delete(typeQueryWrapper);
        if (delete != 0) {
            return R.ok().message("删除成功");
        } else {
            return R.error().message("删除失败");
        }
    }

    @ApiOperation("根据名称删除分类")
    @DeleteMapping("/deleteByName")
    public R deleteByName(@RequestParam String typeName){
        typeQueryWrapper.clear();
        typeQueryWrapper.eq("type_name", typeName);
        int delete = typeMapper.delete(typeQueryWrapper);
        if (delete != 0) {
            return R.ok().message("删除成功");
        } else {
            return R.error().message("删除失败");
        }
    }
}
