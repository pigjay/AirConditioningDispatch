package com.pigteam.airconditioning.config.shiro.filter;

import com.pigteam.airconditioning.common.utils.AuthResponseUtil;
import com.pigteam.airconditioning.model.po.user.CurrentUser;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限 拦截策略
 */
public class PermissionFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        Subject subject  = this.getSubject(servletRequest,servletResponse);
        String requestUrl = getPathWithinApplication(servletRequest);
        if (!subject.isAuthenticated()){
            AuthResponseUtil.returnNotLogin((HttpServletResponse) servletResponse);
            return false;
        }
        CurrentUser currentUser = (CurrentUser) subject.getPrincipal();
        if (currentUser.getPermissions() == null){
            AuthResponseUtil.returnUrlForbidden((HttpServletResponse) servletResponse);
            return false;
        }
        if (currentUser.getPermissions().contains(requestUrl)){
            return true;
        }
        AuthResponseUtil.returnUrlForbidden((HttpServletResponse) servletResponse);
        return false;
    }

}