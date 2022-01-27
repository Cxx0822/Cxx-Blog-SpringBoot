package com.blog.cxx.service.mapper;

import com.blog.cxx.service.entity.Type;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Cxx
 * @since 2022-01-26
 */
@Mapper
@Repository
public interface TypeMapper extends BaseMapper<Type> {

}
