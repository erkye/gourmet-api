package com.gourmetapi.controller.exception;

import lombok.Getter;

/**
 * @author 李发展
 * @date 2020-10-9 - 19:26
 *
 * 自定义异常
 */
@Getter
public class APIException extends RuntimeException {

    private int code;
    private String msg;

    public APIException(){
        this(1001,"接口错误");
    }

    public APIException(String msg){
        this(1001,msg);
    }

    public APIException(int code,String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
