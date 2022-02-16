package com.blog.cxx.service.mapper;

import com.blog.cxx.service.entity.MenuMeta;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.cxx.service.entity.vo.MenuMetaInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
public interface MenuMetaMapper extends BaseMapper<MenuMeta> {
    /*
    * 根据menu id获取meta信息
    * */
    MenuMetaInfo selectMetaByMenuId(Integer menuId);
}
