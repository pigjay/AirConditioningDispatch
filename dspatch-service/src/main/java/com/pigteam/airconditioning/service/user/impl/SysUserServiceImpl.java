package com.pigteam.airconditioning.service.user.impl;

import com.pigteam.airconditioning.mapper.user.SysPermissionMapper;
import com.pigteam.airconditioning.mapper.user.SysRoleMapper;
import com.pigteam.airconditioning.mapper.user.SysUserMapper;
import com.pigteam.airconditioning.model.po.user.CurrentUser;
import com.pigteam.airconditioning.model.po.user.SysRole;
import com.pigteam.airconditioning.model.po.user.SysUser;
import com.pigteam.airconditioning.service.base.impl.BaseServiceImpl;
import com.pigteam.airconditioning.service.user.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @className: SysUserServiceImpl
 * @author: zhujie
 * @version:
 * @date: 2019/4/17 14:50
 * @descripton:
 **/
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, SysUserMapper> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public CurrentUser getCurrentUserByUsername(String loginName) {
        CurrentUser currentUser = new CurrentUser();
        SysUser sysUser = sysUserMapper.findOneByLoginName(loginName);
        if (sysUser == null) {
            return null;
        }
        currentUser.setSysUser(sysUser);
        SysRole sysRole = sysRoleMapper.findOneByUserId(sysUser.getId());
        if (sysRole == null || sysRole.getDeleteStatus()){
            sysUser.setDeleteStatus(true);
            return currentUser;
        }
        Set<String> permissionUrl = sysPermissionMapper.getPermissionsUrlByRoleId(sysRole.getId());
        permissionUrl.remove("");
        permissionUrl.remove(null);

        currentUser.setPermissions(permissionUrl);

        return currentUser;
    }
}
