package com.github.fgowiki.api.service;

import com.github.fgowiki.api.dao.ConfigDao;
import com.github.fgowiki.api.entity.SysConfig;
import com.github.fgowiki.core.dao.BaseDao;
import com.github.fgowiki.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author jiang
 * @create 2018-03-26 19:33
 **/
@Service
public class ConfigService extends BaseService<SysConfig, Integer> {

    @Autowired
    private ConfigDao dao;

    @Override
    protected BaseDao<SysConfig, Integer> getDao() {
        return dao;
    }

    @Cacheable(value = "servant")
    public SysConfig getSysConfig(String configName) {
        return dao.getSysConfig(configName);
    }
}
