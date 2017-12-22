package com.github.fgowiki.api.core;

import com.github.fgowiki.api.core.BaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

/**
 * 功能描述：
 *
 * @author 蒋经
 * @version 1.0
 * @since 2017/12/22
 */
public abstract class BaseService <T,ID extends Serializable> {

    abstract protected BaseDao<T,ID> getDao();

    public Page<T> getList(Pageable pageable) {
        return getDao().findAll(pageable);
    }
}
