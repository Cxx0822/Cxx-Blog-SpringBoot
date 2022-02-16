package com.blog.cxx.service.mapper;

import com.blog.cxx.service.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.cxx.service.entity.vo.RoleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Cxx
 * @since 2022-02-10
 */
@Mapper
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    /*
    * 获取所有角色信息
    * */
    List<RoleInfo> getAllRoles();


    /*
    * 根据用户ID查询角色信息
    * */
    List<Role> selectRolesByUserId(Integer userId);

    /*
     * 选择某个menu的角色权限
     * */
    List<String> selectRolesByMenuId(Integer metaId);

    /*
     * 根据permission获取能访问的角色信息
     * */
    List<String> getRoleNameByPermissionName(String permissionName);
}
