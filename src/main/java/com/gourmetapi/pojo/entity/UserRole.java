package com.gourmetapi.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户-角色表
 *
 * @author none
 * @since 2022/3/11 3:45 PM
 */
@Data
@Builder
@TableName("base_user_role")
public class UserRole implements Serializable {

  private static final long serialVersionUID = -8386586711516559877L;
  @TableId(type = IdType.ASSIGN_ID)
  private long id;
  private long userId;
  private long roleId;
  private Date createTime;
  private String creator;
  private Date updateTime;
  private String editor;
  private boolean deleted;

}
