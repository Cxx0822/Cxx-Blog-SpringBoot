package com.blog.cxx.service.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

// 博客类别信息  类别+博客数量
public class BlogTypeInfo implements Serializable {
    private String typeName;

    private Long typeNumber;
}
