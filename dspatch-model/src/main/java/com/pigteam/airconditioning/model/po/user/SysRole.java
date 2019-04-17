package com.pigteam.airconditioning.model.po.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.pigteam.airconditioning.model.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * @className: SysRole
 * @author: zhujie
 * @version:
 * @date: 2019/4/17 14:17
 * @descripton:
 **/
@Data
public class SysRole extends BaseEntity<SysRole> {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String roleName;

    private Date createTime;

    private Date updateTime;

    private Boolean deleteStatus;

}
