package com.github.fgowiki.api.service;

import com.github.fgowiki.api.dao.ConfigDao;
import com.github.fgowiki.api.entity.SysConfig;
import com.github.fgowiki.core.dao.BaseDao;
import com.github.fgowiki.core.service.BaseService;
import javafx.beans.binding.When;
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

	@Cacheable(value = "config")
	public SysConfig getSysConfig(String configName) {
		SysConfig sysConfig = new SysConfig();
		switch (configName) {
			case "token_expiration":
				sysConfig.setValue("7200000");
				break;
			case "token_secret_key":
				sysConfig.setValue("fgowiki");
				break;
		}
		return sysConfig;
		//return dao.getSysConfig(configName);
	}
}
