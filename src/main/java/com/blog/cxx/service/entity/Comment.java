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
@TableName("comment")
@ApiModel(value = "Comment对象", description = "")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("昵称")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty("qq号")
    @TableField("qq")
    private String qq;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("评论内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("头像")
    @TableField("avator")
    private String avator;

    @ApiModelProperty("ip地址")
    @TableField("ip")
    private String ip;

    @ApiModelProperty("个人网站")
    @TableField("website")
    private String website;

    @ApiModelProperty("博客id")
    @TableField("blog_id")
    private Long blogId;

    @ApiModelProperty("博主是否回复")
    @TableField("is_admin_comment")
    private Integer isAdminComment;

    @ApiModelProperty("是否公开")
    @TableField("is_published")
    private Boolean isPublished;

    @ApiModelProperty("父评论id")
    @TableField("parent_comment_id")
    private Long parentCommentId;

    @ApiModelProperty("父评论昵称")
    @TableField("parent_comment_nickname")
    private String parentCommentNickname;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
