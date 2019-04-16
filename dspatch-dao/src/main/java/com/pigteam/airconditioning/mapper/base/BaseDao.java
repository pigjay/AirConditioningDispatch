package com.pigteam.airconditioning.mapper.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BaseDao<T> extends BaseMapper<T> {
}
