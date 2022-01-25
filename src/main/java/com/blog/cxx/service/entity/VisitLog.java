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
@ApiModel(value="VisitLog对象", description="")
public class VisitLog implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "访客标识码")
    private String uuid;

    @ApiModelProperty(value = "请求接口")
    private String uri;

    @ApiModelProperty(value = "请求方式")
    private String method;

    @ApiModelProperty(value = "请求参数")
    private String param;

    @ApiModelProperty(value = "访问行为")
    private String behavior;

    @ApiModelProperty(value = "访问内容")
    private String content;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "ip")
    private String ip;

    @ApiModelProperty(value = "ip来源")
    private String ipSource;

    @ApiModelProperty(value = "操作系统")
    private String os;

    @ApiModelProperty(value = "浏览器")
    private String browser;

    @ApiModelProperty(value = "请求耗时ms")
    private Integer times;

    @ApiModelProperty(value = "用户代理")
    private String userAgent;

    @ApiModelProperty(value = "创建时间")
      @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
      @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
