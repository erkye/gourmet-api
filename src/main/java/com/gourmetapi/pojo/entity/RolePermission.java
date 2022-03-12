package com.gourmetapi.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色-权限表
 *
 * @author none
 * @since 2022/3/11 3:45 PM
 */
@Data
@Builder
@TableName("base_role_permission")
public class RolePermission implements Serializable {

  private static final long serialVersionUID = -3134772970707551716L;
  @TableId(type = IdType.AUTO)
  private long id;
  private long roleId;
  private long permissionId;
  private Date createTime;
  private String creator;
  private Date updateTime;
  private String editor;
  private boolean deleted;

}
