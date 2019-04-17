package com.pigteam.airconditioning.common.exception;

import com.pigteam.airconditioning.common.enums.SystemCodeEnum;
import lombok.Getter;

/**
 * 参数错误异常
 *
 * @Author: zhujie
 * @Date: 2018/11/30 17:36
 */
@Getter
public class ParamException extends RuntimeException {

    private SystemCodeEnum codeEnum;

    public ParamException(SystemCodeEnum codeEnum) {
        super(codeEnum.getMessage());
        this.codeEnum = codeEnum;
    }
}
