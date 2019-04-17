package com.pigteam.airconditioning.config.shiro.config;

import com.pigteam.airconditioning.model.po.user.CurrentUser;
import com.pigteam.airconditioning.service.user.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义权限匹配和账号密码匹配
 *
 * @author zzq
 */
public class CustomAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return new SimpleAuthorizationInfo();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String loginName = (String) token.getPrincipal();
        CurrentUser currentUser = sysUserService.getCurrentUserByUsername(loginName);

        if (currentUser == null) {
            throw new UnknownAccountException();
        }

        if (currentUser.getSysUser().getDeleteStatus()) {
            throw new LockedAccountException();
        }


        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                currentUser,
                currentUser.getSysUser().getPassword(),
                ByteSource.Util.bytes(currentUser.slat()),
                getName()
        );

        return authenticationInfo;
    }

}
