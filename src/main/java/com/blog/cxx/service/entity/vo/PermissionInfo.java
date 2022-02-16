package com.blog.cxx.service.entity.vo;

import com.blog.cxx.service.entity.Operation;
import com.blog.cxx.service.entity.Resource;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PermissionInfo implements Serializable {
    private Integer id;

    private String permissionName;

    private String permissionDescription;

    private Integer resourceId;

    private Integer operationId;

    private Operation operation;

    private Resource resource;
}
