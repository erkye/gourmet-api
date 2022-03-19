package com.gourmetapi.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件记录上传
 *
 * @author lfz
 * @since 2022/3/19 10:34 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("base_file_upload_record")
public class FileUploadRecord implements Serializable {

    private static final long serialVersionUID = 2603989395273017194L;
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    /** 用户id */
    private Long userId;
    /** 源文件名称 */
    private String originFileName;
    /** 文件类型 */
    private String fileType;
    /** 新文件名称 */
    private String freshFileName;
    /** 新文件保存路径 */
    private String freshFilePath;
    /** 状态 EnumFileUploadStatus */
    private String status;
    /** 上传url */
    private String url;
    /** 文件大小 */
    private Long fileSize;

    private Date createTime;
    private Date updateTime;
}
