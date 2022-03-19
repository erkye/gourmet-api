package com.gourmetapi.service;

import com.gourmetapi.model.entity.FileUploadRecordEntity;

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
    FileUploadRecordEntity insertOne(FileUploadRecordEntity record);

    /**
     * 修改
     * @param record
     * @return
     */
    FileUploadRecordEntity updateOne(FileUploadRecordEntity record);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    FileUploadRecordEntity selectById(long id);

    /**
     * 根据id修改状态
     * @param id
     * @param status
     * @return
     */
    FileUploadRecordEntity updateStatus(long id, String status);
}
