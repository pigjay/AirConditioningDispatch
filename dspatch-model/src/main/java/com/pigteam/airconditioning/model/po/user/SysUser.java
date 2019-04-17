package com.pigteam.airconditioning.model.po.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.pigteam.airconditioning.model.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * @className: SysUser
 * @author: zhujie
 * @version:
 * @date: 2019/4/17 14:15
 * @descripton:
 **/
@Data
public class SysUser extends BaseEntity<SysUser> {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String nickname;

    private Date createTime;

    private Date updateTime;

    private Boolean deleteStatus;

    private String salt;
}
