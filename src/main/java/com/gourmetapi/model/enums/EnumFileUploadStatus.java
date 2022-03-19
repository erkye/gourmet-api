package com.gourmetapi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文件上传状态枚举值
 *
 * @author lfz
 * @since 2022/3/19 10:44 AM
 */
@AllArgsConstructor
@Getter
public enum EnumFileUploadStatus {

    UPLOADING("001","上传中"),
    SUCCESS("002","上传成功"),
    FAIL("003","上传失败");


    /** code值 */
    private String code;

    /** 描述 */
    private String desc;

}
