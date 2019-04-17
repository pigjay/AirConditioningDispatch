package com.pigteam.airconditioning.config.shiro.filter;

import com.pigteam.airconditioning.common.utils.AuthResponseUtil;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: zhujie
 * @Date: 2018/11/30 10:01
 */
public class AuthenticatingFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        AuthResponseUtil.returnNotLogin((HttpServletResponse) response);
        return false;
    }
}
