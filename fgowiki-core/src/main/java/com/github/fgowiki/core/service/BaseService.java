package com.github.fgowiki.core.service;

import com.github.fgowiki.core.dao.BaseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author jiang
 * @create 2017-12-10 21:18
 **/
public abstract class BaseService<T> {
    /**
     * 默认分页大小
     */
    private static final int DEFAULT_SIZE = 10;

    public PageInfo<T> getList(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        pageNum = pageNum == null || pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize == null || pageSize < 1 ? DEFAULT_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<T>(this.getNoPage(params));
    }

    public T get(String id) {
        return this.getMapper().get(id);
    }

    protected abstract BaseMapper<T> getMapper();

    public abstract List<T> getNoPage(Map<String, Object> params);
}
