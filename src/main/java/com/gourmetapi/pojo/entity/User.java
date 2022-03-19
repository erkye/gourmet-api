package com.gourmetapi.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 *
 * @author none
 * @since 2022/3/11 3:45 PM
 */
@Data
@Builder
@TableName("base_user")
public class User implements Serializable {

  private static final long serialVersionUID = -5063610786512520995L;
  @TableId(type = IdType.ASSIGN_ID)
  private Long id;
  private Long state;
  private String name;
  private String headImgUrl;
  private String mobile;
  private String salt;
  private String password;
  private Date createTime;
  private String creator;
  private Date updateTime;
  private String editor;
  private boolean deleted;

}
