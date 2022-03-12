package com.gourmetapi.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限表
 *
 * @author none
 * @since 2022/3/11 3:45 PM
 */
@Data
@Builder
@TableName("base_permission")
public class Permission implements Serializable {

  private static final long serialVersionUID = -7592975062124977084L;
  @TableId(type = IdType.AUTO)
  private long id;
  private long parentId;
  private String code;
  private String name;
  private String intro;
  private String category;
  private long uri;
  private Date createTime;
  private String creator;
  private Date updateTime;
  private String editor;
  private boolean deleted;


}
