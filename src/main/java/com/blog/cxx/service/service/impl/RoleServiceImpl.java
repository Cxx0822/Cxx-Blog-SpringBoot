package com.blog.cxx.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.blog.cxx.service.entity.Role;
import com.blog.cxx.service.mapper.RoleMapper;
import com.blog.cxx.service.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Cxx
 * @since 2022-02-10
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> query(String columnName, String columnValue) {
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        roleQueryWrapper.eq(columnName, columnValue);

        return roleMapper.selectList(roleQueryWrapper);
    }

    @Override
    public Boolean delete(String columnName, String columnValue) {
        // 删除角色
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        roleQueryWrapper.eq(columnName, columnValue);
        Role role = roleMapper.selectOne(roleQueryWrapper);
        int deleteRole = roleMapper.delete(roleQueryWrapper);


        if (deleteRole != 0 ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer update(Role role) {
        UpdateWrapper<Role> roleUpdateWrapper = new UpdateWrapper<>();
        roleUpdateWrapper.eq("role_name", role.getRoleName());

        return roleMapper.update(role, roleUpdateWrapper);
    }

}
