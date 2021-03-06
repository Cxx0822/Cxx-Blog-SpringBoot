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
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Cxx
 * @since 2022-01-26
 */
@Data
@Accessors(chain = true)
@TableName("visitor")
@ApiModel(value = "Visitor对象", description = "")
public class Visitor implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("访客标识码")
    @TableField("uuid")
    private String uuid;

    @ApiModelProperty("ip")
    @TableField("ip")
    private String ip;

    @ApiModelProperty("ip来源")
    @TableField("ip_source")
    private String ipSource;

    @ApiModelProperty("操作系统")
    @TableField("os")
    private String os;

    @ApiModelProperty("浏览器")
    @TableField("browser")
    private String browser;

    @ApiModelProperty("访问页数统计")
    @TableField("pv")
    private Integer pv;

    @ApiModelProperty("用户代理")
    @TableField("user_agent")
    private String userAgent;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
