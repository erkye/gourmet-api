package com.gourmetapi.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 账号表
 *
 * @author none
 * @since 2022/3/11 3:45 PM
 */
@Data
@Builder
@TableName("base_account")
public class AccountEntity implements Serializable {

  private static final long serialVersionUID = 3533038345982822312L;
  /**
   * 账号ID
   */
  @TableId(type = IdType.ASSIGN_ID)
  private Long id;
  /** 用户ID */
  private Long userId;
  /** 登录账号,如手机号等 */
  private String openCode;
  private String category;
  private Date createTime;
  private String creator;
  private Date updateTime;
  private String editor;
  private boolean deleted;
}
