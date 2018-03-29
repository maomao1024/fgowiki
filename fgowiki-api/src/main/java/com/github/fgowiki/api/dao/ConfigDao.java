package com.github.fgowiki.api.dao;

import com.github.fgowiki.api.entity.SysConfig;
import com.github.fgowiki.core.dao.BaseDao;
import org.springframework.data.jpa.repository.Query;

/**
 * @author jiang
 * @create 2018-03-26 19:33
 **/
public interface ConfigDao extends BaseDao<SysConfig, Integer> {

    @Query("select t.value from SysConfig  t where t.name=?1 and t.yxbz=1")
    String getSysConfig(String configName);
}
