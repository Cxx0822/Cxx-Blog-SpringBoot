package com.blog.cxx.service.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Cxx
 * @since 2022-01-25
 */
@Getter
@Setter
@TableName("blog")
@ApiModel(value = "Blog对象", description = "")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    @ApiModelProperty("文章标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("文字描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("文章正文")
    @TableField("content")
    private String content;

    @ApiModelProperty("文章浏览次数")
    @TableField("views")
    private Integer views;

    @ApiModelProperty("文章字数")
    @TableField("words")
    private Integer words;

    @ApiModelProperty("文章类别")
    @TableField("type_id")
    private Long typeId;

    @ApiModelProperty("文章作者id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("文章状态（是否公开）")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
