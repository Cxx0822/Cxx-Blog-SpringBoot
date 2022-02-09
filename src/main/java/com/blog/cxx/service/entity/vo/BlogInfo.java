package com.blog.cxx.service.entity.vo;

import com.blog.cxx.service.entity.Type;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

// 返回给前端的数据
public class BlogInfo implements Serializable {
    private Long id;

    private String title;

    private String description;

    private String content;

    private Integer views;

    private Integer words;

    private String username;

    private String typeName;

    private Integer status;

    private Date createTime;

    private Date updateTime;
}
