package com.gourmetapi.controller.exception;

import com.gourmetapi.pojo.result.ResultCode;
import com.gourmetapi.pojo.result.ResultVo;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author none
 * @date 2020-10-9 - 19:30
 *
 * 全局异常处理
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * 处理自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(ApiException.class)
    public ResultVo<String> apiExceptionHandler(ApiException e) {
        // 注意哦，这里传递的响应码枚举
        return new ResultVo<>(ResultCode.FAILED, e.getMsg());
    }

    /**
     * 处理校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVo<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 注意哦，这里传递的响应码枚举
        return new ResultVo<>(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }
}
