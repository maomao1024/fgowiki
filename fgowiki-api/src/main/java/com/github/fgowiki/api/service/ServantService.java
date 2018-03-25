package com.github.fgowiki.api.service;

import com.github.fgowiki.api.dao.ServantDao;
import com.github.fgowiki.api.entity.FgoServant;
import com.github.fgowiki.core.bean.ResultBean;
import com.github.fgowiki.core.dao.BaseDao;
import com.github.fgowiki.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 * @author jiang
 * @create 2017-12-10 19:56
 **/
@Service
public class ServantService extends BaseService<FgoServant,Integer> {

    @Autowired
    private ServantDao dao;

    @Override
    protected BaseDao<FgoServant, Integer> getDao() {
        return dao;
    }

}
