package com.gourmetapi.domain.result;

import lombok.Getter;

/**
 * @author 李发展
 * @date 2020-10-9 - 19:33
 *
 * 自定义响应体
 */
@Getter
public class ResultVO<T> {

    /**
     * 状态码，比如1000代表响应成功
     */
    private int code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String msg;
    /**
     * 响应的具体数据
     */
    private T data;

    public ResultVO(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}
