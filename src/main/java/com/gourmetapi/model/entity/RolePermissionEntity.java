package com.gourmetapi.model.entity;

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
public class RolePermissionEntity implements Serializable {

  private static final long serialVersionUID = -3134772970707551716L;
  @TableId(type = IdType.ASSIGN_ID)
  private Long id;
  private Long roleId;
  private Long permissionId;
  private Date createTime;
  private String creator;
  private Date updateTime;
  private String editor;
  private boolean deleted;

}
