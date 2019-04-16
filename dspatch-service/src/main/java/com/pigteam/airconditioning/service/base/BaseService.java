package com.pigteam.airconditioning.service.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface BaseService<T,S> {

    int insert(T var1);

    int deleteById(Serializable var1);

    int deleteByMap(Map<String, Object> var1);

    int delete(Wrapper<T> var1);

    int deleteBatchIds(Collection<? extends Serializable> var1);

    int updateById(T var1);

    int update(T var1, Wrapper<T> var2);

    T selectById(Serializable var1);

    List<T> selectBatchIds(Collection<? extends Serializable> var1);

    List<T> selectByMap(Map<String, Object> var1);

    T selectOne(Wrapper<T> var1);

    Integer selectCount(Wrapper<T> var1);

    List<T> selectList(Wrapper<T> var1);

    List<Map<String, Object>> selectMaps(Wrapper<T> var1);

    List<Object> selectObjs(Wrapper<T> var1);

    IPage<T> selectPage(IPage<T> var1, Wrapper<T> var2);

    IPage<Map<String, Object>> selectMapsPage(IPage<T> var1, Wrapper<T> var2);
}
