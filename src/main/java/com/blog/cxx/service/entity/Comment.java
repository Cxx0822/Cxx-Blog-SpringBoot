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
@ApiModel(value="Comment对象", description="")
public class Comment implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "qq号")
    private String qq;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "头像")
    private String avator;

    @ApiModelProperty(value = "ip地址")
    private String ip;

    @ApiModelProperty(value = "个人网站")
    private String website;

    @ApiModelProperty(value = "博客id")
    private Long blogId;

    @ApiModelProperty(value = "博主是否回复")
    private Integer isAdminComment;

    @ApiModelProperty(value = "是否公开")
    private Boolean isPublished;

    @ApiModelProperty(value = "父评论id")
    private Long parentCommentId;

    @ApiModelProperty(value = "父评论昵称")
    private String parentCommentNickname;

    @ApiModelProperty(value = "创建时间")
      @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
      @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
