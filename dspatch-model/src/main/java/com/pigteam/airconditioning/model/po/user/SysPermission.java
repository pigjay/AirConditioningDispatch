package com.pigteam.airconditioning.model.po.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.pigteam.airconditioning.model.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * @className: SysPermission
 * @author: zhujie
 * @version:
 * @date: 2019/4/17 14:20
 * @descripton:
 **/
@Data
public class SysPermission extends BaseEntity<SysPermission> {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long parentId;

    private String permission;

    private String name;

    private Short type;

    private String url;

    private String icon;

    private Integer sort;

    private Date createTime;

    private Date updateTime;

    private Boolean openStatus;
}
