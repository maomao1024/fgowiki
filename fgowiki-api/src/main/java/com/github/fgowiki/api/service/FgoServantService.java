package com.github.fgowiki.api.service;

import com.github.fgowiki.api.core.BaseDao;
import com.github.fgowiki.api.core.BaseService;
import com.github.fgowiki.api.dao.FgoServantDao;
import com.github.fgowiki.api.domain.FgoServant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author jiang
 * @create 2017-12-10 19:56
 **/
@Service
public class FgoServantService extends BaseService<FgoServant,Integer> {

    @Autowired
    private FgoServantDao dao;

    @Override
    protected BaseDao<FgoServant, Integer> getDao() {
        return dao;
    }
}
