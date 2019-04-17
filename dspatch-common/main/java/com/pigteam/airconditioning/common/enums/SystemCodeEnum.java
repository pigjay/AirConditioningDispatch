package com.pigteam.airconditioning.common.enums;

import lombok.Getter;

/**
 * @Author: zhujie
 * @Date: 2018/12/14 14:58
 */
@Getter
public enum SystemCodeEnum {

    SUCCESS("0","success"),
    ERROR("1","error"),
    AUTH_NOLOGIN("1001","未登录"),
    AUTH_NOPERMISSION("1002","没有权限"),
    AUTH_NOT_USER("1003","用户名不存在"),
    AUTH_USER_DISABLE("1004","用户已禁用"),
    AUTH_PASSWORD_ERROR("1005","用户名密码错误"),
    REQUEST_ILLEGAL("1006", "非法请求"),
    SYSTEM_UNKNOWN("1007", "系统异常"),
    AUTH_VCODEERR("1016", "验证码错误，请输入正确的验证码"),
    ;
    private String code;
    private String message;

    SystemCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
