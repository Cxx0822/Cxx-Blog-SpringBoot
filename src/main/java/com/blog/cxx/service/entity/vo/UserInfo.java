package com.blog.cxx.service.entity.vo;

import com.blog.cxx.service.entity.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserInfo implements Serializable {
    private Integer id;

    private String username;

    private String nickname;

    private String avatar;

    private String email;

    private Integer status;

    private List<Role> roleList;
}
