package com.pigteam.airconditioning.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pigteam.airconditioning.model.po.user.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @className: SysRoleMapper
 * @author: zhujie
 * @version:
 * @date: 2019/4/17 14:43
 * @descripton:
 **/
@Mapper
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

    @Select("select * from sys_role sr inner join sys_user_role sur on sr.id = sur.role_id where sur.user_id = #{userId}")
    SysRole findOneByUserId(@Param("userId") Long userId);
}
