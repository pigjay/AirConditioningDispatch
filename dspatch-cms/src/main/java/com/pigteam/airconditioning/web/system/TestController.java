package com.pigteam.airconditioning.web.system;

import com.pigteam.airconditioning.common.web.Result;
import com.pigteam.airconditioning.model.po.user.SysRole;
import com.pigteam.airconditioning.model.po.user.SysUser;
import com.pigteam.airconditioning.service.user.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author zhujie
 * date: 2019-06-26 10:52
 * desc:
 */
@RestController
public class TestController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/test")
    public Result test(){
        SysUser sysUser = new SysUser();
        sysUser.setUsername("111");
        sysUser.setUpdateTime(new Date());
        sysUser.setSalt("111");
        sysUser.setPassword("1212");
        sysUser.setDeleteStatus(false);
        sysUser.setUsername("1212");
        sysUser.setCreateTime(new Date());
        sysUser.setNickname("1212");
        SysRole sysRole = new SysRole();
        sysUserService.save1(sysUser,sysRole);
        return Result.success();
    }
}
