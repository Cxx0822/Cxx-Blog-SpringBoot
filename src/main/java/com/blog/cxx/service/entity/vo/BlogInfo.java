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

public class BlogInfo implements Serializable {
    private Long id;

    private String title;

    private String description;

    private String content;

    private Date createTime;

    private Date updateTime;

    private Integer views;

    private Integer words;

    private Long typeId;

    private Long userId;

    private Integer status;

    private Type type;
}
