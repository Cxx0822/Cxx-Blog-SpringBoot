package com.blog.cxx.service.mapper;

import com.blog.cxx.service.entity.Resource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.cxx.service.entity.vo.ResourceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Cxx
 * @since 2022-02-16
 */
@Mapper
@Repository
public interface ResourceMapper extends BaseMapper<Resource> {
    /*
    * 根据资源ID获取资源信息
    * */
    Resource selectResourceByResourceId(Integer resourceId);

    /*
    * 查询所有资源
    * */
    List<ResourceInfo> getAllResources();
}
