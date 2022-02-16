package com.blog.cxx.service.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RoleInfo implements Serializable {
    private Integer id;

    private String roleName;

    private String roleDescription;

    private List<MenuInfo> routes;

    private List<PermissionInfo> permissionList;
}
