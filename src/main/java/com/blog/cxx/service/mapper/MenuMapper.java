package com.blog.cxx.service.mapper;

import com.blog.cxx.service.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.cxx.service.entity.vo.MenuInfo;
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
public interface MenuMapper extends BaseMapper<Menu> {
    /*
    * 获取所有路由信息
    * */
    List<MenuInfo> getAllMenus();

    /*
     * 根据parent_id查询路由信息
     * */
    List<MenuInfo> selectAllMenusByParentId(Integer parentId);

    /*
     * 根据角色选择menu
     * */
    List<MenuInfo> selectMenuByRoleId(Integer roleId);
}
