package com.blog.cxx.service.mapper;

import com.blog.cxx.service.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.cxx.service.entity.vo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public interface UserMapper extends BaseMapper<User> {
    List<UserInfo> getAllUsers();
}
