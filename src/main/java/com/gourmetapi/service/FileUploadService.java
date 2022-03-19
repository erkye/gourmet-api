package com.gourmetapi.service;

import com.gourmetapi.pojo.entity.FileUploadRecord;

/**
 * 文件上传service
 *
 * @author lfz
 * @since 2022/3/19 11:33 AM
 */
public interface FileUploadService {


    /**
     * 添加
     * @param record
     * @return
     */
    FileUploadRecord insertOne(FileUploadRecord record);

    /**
     * 修改
     * @param record
     * @return
     */
    FileUploadRecord updateOne(FileUploadRecord record);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    FileUploadRecord selectById(long id);

    /**
     * 根据id修改状态
     * @param id
     * @param status
     * @return
     */
    FileUploadRecord updateStatus(long id,String status);
}
