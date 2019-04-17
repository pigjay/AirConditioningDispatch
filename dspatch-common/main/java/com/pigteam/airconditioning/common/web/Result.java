package com.pigteam.airconditioning.common.web;

import com.pigteam.airconditioning.common.enums.SystemCodeEnum;
import lombok.Data;

/**
 * @Author: zhujie
 * @Date: 2018/11/19 15:48
 */
@Data
public class Result {

    private String code;

    private String message;

    private Object data;

    private Result(SystemCodeEnum systemCodeEnum) {
        this.code = systemCodeEnum.getCode();
        this.message = systemCodeEnum.getMessage();
    }

    public static Result success() {
        Result result = new Result(SystemCodeEnum.SUCCESS);
        result.setData(null);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result(SystemCodeEnum.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result fail() {
        Result result = new Result(SystemCodeEnum.ERROR);
        result.setData(null);
        return result;
    }

    public static Result fail(SystemCodeEnum systemCodeEnum) {
        Result result = new Result(systemCodeEnum);
        result.setData(null);
        return result;
    }
}
