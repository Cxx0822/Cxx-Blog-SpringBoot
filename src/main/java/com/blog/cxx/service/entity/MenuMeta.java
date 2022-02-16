package com.blog.cxx.service.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Cxx
 * @since 2022-02-16
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("menu_meta")
@ApiModel(value = "MenuMeta对象", description = "")
public class MenuMeta implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("menu_id")
    private Integer menuId;

    @TableField("title")
    private String title;

    @TableField("icon")
    private String icon;

    @TableField("no_cache")
    private Integer noCache;

    @TableField("affix")
    private Integer affix;

    @TableField("breadcrumb")
    private Integer breadcrumb;

    @TableField("active_menu")
    private String activeMenu;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
