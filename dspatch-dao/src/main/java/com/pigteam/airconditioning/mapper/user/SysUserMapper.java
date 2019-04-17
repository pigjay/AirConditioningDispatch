package com.pigteam.airconditioning.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pigteam.airconditioning.model.po.user.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @className: SysUserMapper
 * @author: zhujie
 * @version:
 * @date: 2019/4/17 14:39
 * @descripton:
 **/
@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

    @Select("select * from sys_user where username = #{loginName} ")
    SysUser findOneByLoginName(@Param("loginName") String loginName);

}
