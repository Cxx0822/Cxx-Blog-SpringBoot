package com.blog.cxx.service.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MenuInfo implements Serializable {
    private Integer id;

    private String path;

    private String name;

    private String component;

    private String redirect;

    private Short hidden;

    private Short alwaysShow;

    private Integer parentId;

    private MenuMetaInfo meta;

    private List<MenuInfo> children;
}
