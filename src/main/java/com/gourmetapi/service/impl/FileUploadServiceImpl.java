package com.gourmetapi.service.impl;

import com.gourmetapi.dao.FileUploadRecordMapper;
import com.gourmetapi.pojo.entity.FileUploadRecord;
import com.gourmetapi.service.FileUploadService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 文件上传记录service
 *
 * @author lfz
 * @since 2022/3/19 2:27 PM
 */
@Service
@Slf4j
@AllArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {

    private final FileUploadRecordMapper fileUploadRecordMapper;

    @Override
    public FileUploadRecord insertOne(FileUploadRecord record) {
        fileUploadRecordMapper.insert(record);
        return selectById(record.getId());
    }

    @Override
    public FileUploadRecord updateOne(FileUploadRecord record) {
        fileUploadRecordMapper.updateById(record);
        return selectById(record.getId());
    }

    @Override
    public FileUploadRecord selectById(long id) {
        return fileUploadRecordMapper.selectById(id);
    }

    @Override
    public FileUploadRecord updateStatus(long id, String status) {
        FileUploadRecord fileUploadRecord = selectById(id);
        fileUploadRecord.setStatus(status);
        return updateOne(fileUploadRecord);
    }

}