package com.blog.cxx.service.mapper;

import com.blog.cxx.service.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.cxx.service.entity.vo.PermissionInfo;
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
public interface PermissionMapper extends BaseMapper<Permission> {
    /*
     * 根据角色选择权限
     * */
    List<PermissionInfo> selectPermissionByRoleId(Integer roleId);

    /*
    * 根据资源ID查询权限信息
    * */
    List<PermissionInfo> selectPermissionByResourceId(Integer resourceId);
}
