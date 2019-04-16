package com.pigteam.airconditioning.service.base.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pigteam.airconditioning.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhujie
 * @Date: 2018/11/16 18:29
 */
public class BaseServiceImpl<T, S extends BaseMapper<T>> implements BaseService<T, S> {

    @Autowired
    private S baseDao;

    @Override
    public int insert(T var1) {
        return baseDao.insert(var1);
    }

    @Override
    public int deleteById(Serializable var1) {
        return baseDao.deleteById(var1);
    }

    @Override
    public int deleteByMap(Map<String, Object> var1) {
        return baseDao.deleteByMap(var1);
    }

    @Override
    public int delete(Wrapper<T> var1) {
        return baseDao.delete(var1);
    }

    @Override
    public int deleteBatchIds(Collection<? extends Serializable> var1) {
        return baseDao.deleteBatchIds(var1);
    }

    @Override
    public int updateById(T var1) {
        return baseDao.updateById(var1);
    }

    @Override
    public int update(T var1, Wrapper<T> var2) {
        return baseDao.update(var1, var2);
    }

    @Override
    public T selectById(Serializable var1) {
        return baseDao.selectById(var1);
    }

    @Override
    public List<T> selectBatchIds(Collection<? extends Serializable> var1) {
        return baseDao.selectBatchIds(var1);
    }

    @Override
    public List<T> selectByMap(Map<String, Object> var1) {
        return baseDao.selectByMap(var1);
    }

    @Override
    public T selectOne(Wrapper<T> var1) {
        return baseDao.selectOne(var1);
    }

    @Override
    public Integer selectCount(Wrapper<T> var1) {
        return baseDao.selectCount(var1);
    }

    @Override
    public List<T> selectList(Wrapper<T> var1) {
        return baseDao.selectList(var1);
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<T> var1) {
        return baseDao.selectMaps(var1);
    }

    @Override
    public List<Object> selectObjs(Wrapper<T> var1) {
        return baseDao.selectObjs(var1);
    }

    @Override
    public IPage<T> selectPage(IPage<T> var1, Wrapper<T> var2) {
        return baseDao.selectPage(var1, var2);
    }

    @Override
    public IPage<Map<String, Object>> selectMapsPage(IPage<T> var1, Wrapper<T> var2) {
        return baseDao.selectMapsPage(var1, var2);
    }
}
