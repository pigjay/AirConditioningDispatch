package com.pigteam.airconditioning.model.po.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @className: CurrentUser
 * @author: zhujie
 * @version:
 * @date: 2019/4/17 14:30
 * @descripton:
 **/
@Data
public class CurrentUser implements Serializable {

    private static final long serialVersionUID = -7043260562449436078L;

    private SysUser sysUser;

    private Set<String> roleName;

    private Set<String> permissions;

    public String slat() {
        return sysUser.getUsername() + sysUser.getSalt();
    }

}
