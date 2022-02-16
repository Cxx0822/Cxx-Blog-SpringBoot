package com.blog.cxx.service.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MenuMetaInfo implements Serializable {
    private Integer id;

    private String title;

    private String icon;

    private Short noCache;

    private Short affix;

    private Short breadcrumb;

    private String activeMenu;

    private List<String> roles;
}
