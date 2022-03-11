package com.gourmetapi.exception;

import lombok.Getter;

/**
 * 自定义接口错误返回体格式
 * @author none
 * @date 2020-10-9 - 19:26
 *
 * 自定义异常
 */
@Getter
public class ApiException extends RuntimeException {

    private int code;
    private String msg;

    public ApiException(){
        this(1001,"接口错误");
    }

    public ApiException(String msg){
        this(1001,msg);
    }

    public ApiException(int code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
