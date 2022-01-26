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
@TableName("visit_log")
@ApiModel(value = "VisitLog对象", description = "")
public class VisitLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    @ApiModelProperty("访客标识码")
    @TableField("uuid")
    private String uuid;

    @ApiModelProperty("请求接口")
    @TableField("uri")
    private String uri;

    @ApiModelProperty("请求方式")
    @TableField("method")
    private String method;

    @ApiModelProperty("请求参数")
    @TableField("param")
    private String param;

    @ApiModelProperty("访问行为")
    @TableField("behavior")
    private String behavior;

    @ApiModelProperty("访问内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

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

    @ApiModelProperty("请求耗时ms")
    @TableField("times")
    private Integer times;

    @ApiModelProperty("用户代理")
    @TableField("user_agent")
    private String userAgent;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
