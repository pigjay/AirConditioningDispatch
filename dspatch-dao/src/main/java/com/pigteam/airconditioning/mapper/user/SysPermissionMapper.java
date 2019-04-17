package com.pigteam.airconditioning.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pigteam.airconditioning.model.po.user.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @className: SysPermissionMapper
 * @author: zhujie
 * @version:
 * @date: 2019/4/17 14:46
 * @descripton:
 **/
@Mapper
@Repository
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    @Select("select sp.url from sys_permission sp inner join sys_role_permission srp on " +
            "sp.id = srp.permission_id where srp.role_id = #{roleId}")
    Set<String> getPermissionsUrlByRoleId(@Param("roleId") Long roleId);
}
