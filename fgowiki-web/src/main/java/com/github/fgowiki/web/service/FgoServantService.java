package com.github.fgowiki.web.service;

import com.github.fgowiki.core.dao.BaseMapper;
import com.github.fgowiki.core.service.BaseService;
import com.github.fgowiki.web.dao.FgoServantMapper;
import com.github.fgowiki.web.domain.FgoServant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author jiang
 * @create 2017-12-10 19:56
 **/
@Service
public class FgoServantService extends BaseService<FgoServant>{

    @Autowired
    private FgoServantMapper mapper;

    @Override
    public BaseMapper<FgoServant> getMapper() {
        return mapper;
    }

    @Override
    public List<FgoServant> getNoPage(Map<String, Object> params) {
        return mapper.selectAll();
    }
}
