package com.gourmetapi.pojo.result;

import lombok.Getter;

/**
 * @author 李发展
 * @date 2020-10-9 - 19:35
 *
 * 响应码枚举类
 */
@Getter
public enum ResultCode {

    SUCCESS(1000, "操作成功"),
    FAILED(1001, "响应失败"),
    VALIDATE_FAILED(1002, "参数校验失败"),
    PERMISSIONS_INSUFFICIENT(1003,"权限不足"),
    AUTH_INVALID(1004,"认证信息失效"),
    ERROR(5000, "未知错误");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
