package com.blog.cxx.service.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blog.cxx.service.entity.Type;
import com.blog.cxx.service.mapper.TypeMapper;
import com.blog.cxx.service.result.R;
import com.blog.cxx.service.service.TypeService;
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
@RequestMapping("/type")
public class TypeController {
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
}
