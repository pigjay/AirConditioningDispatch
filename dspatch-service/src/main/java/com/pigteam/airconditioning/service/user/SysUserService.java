package com.pigteam.airconditioning.service.user;

import com.pigteam.airconditioning.mapper.user.SysUserMapper;
import com.pigteam.airconditioning.model.po.user.CurrentUser;
import com.pigteam.airconditioning.model.po.user.SysUser;
import com.pigteam.airconditioning.service.base.BaseService;

/**
 * @className: SysUserService
 * @author: zhujie
 * @version:
 * @date: 2019/4/17 14:48
 * @descripton:
 **/
public interface SysUserService extends BaseService<SysUser, SysUserMapper> {

    /**
     * 获取登陆账号信息
     * @param loginName
     * @return
     */
    CurrentUser getCurrentUserByUsername(String loginName);
}
