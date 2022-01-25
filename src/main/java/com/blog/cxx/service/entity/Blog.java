package com.blog.cxx.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Cxx
 * @since 2022-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Blog对象", description="")
public class Blog implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "文字描述")
    private String description;

    @ApiModelProperty(value = "文章正文")
    private String content;

    @ApiModelProperty(value = "文章浏览次数")
    private Integer views;

    @ApiModelProperty(value = "文章字数")
    private Integer words;

    @ApiModelProperty(value = "文章类别")
    private Long typeId;

    @ApiModelProperty(value = "文章作者id")
    private Long userId;

    @ApiModelProperty(value = "文章状态")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
      @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
      @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
