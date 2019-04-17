package com.pigteam.airconditioning.common.exception;

import com.pigteam.airconditioning.common.enums.SystemCodeEnum;
import com.pigteam.airconditioning.common.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: zhujie
 * @Date: 2018/11/30 17:45
 */
@ControllerAdvice
@Slf4j
public class ParamExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ParamException.class)
    public Result paramException(ParamException e) {
        log.info("程序异常：" + e.getMessage(), e);
        return Result.fail(e.getCodeEnum());
    }

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result exception(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();

        for (FieldError error : fieldErrors) {
            log.error("参数检验：{}", error.getDefaultMessage());
        }
        return Result.fail(SystemCodeEnum.REQUEST_ILLEGAL);
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result systemException(Exception e) {
        log.info("系统异常：" + e.getMessage(), e);
        return Result.fail(SystemCodeEnum.SYSTEM_UNKNOWN);
    }
}
