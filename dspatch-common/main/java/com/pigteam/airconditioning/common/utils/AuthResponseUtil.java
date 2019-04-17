package com.pigteam.airconditioning.common.utils;

import com.alibaba.fastjson.JSON;
import com.pigteam.airconditioning.common.enums.SystemCodeEnum;
import com.pigteam.airconditioning.common.web.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthResponseUtil {

    public static void returnNotLogin(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().write(JSON.toJSONString(Result.fail(SystemCodeEnum.AUTH_NOLOGIN)));
    }

    public static void returnUrlForbidden(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().write(JSON.toJSONString(Result.fail(SystemCodeEnum.AUTH_NOPERMISSION)));
    }

}
