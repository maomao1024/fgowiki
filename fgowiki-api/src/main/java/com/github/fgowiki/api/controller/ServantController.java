package com.github.fgowiki.api.controller;

import com.github.fgowiki.api.entity.FgoServant;
import com.github.fgowiki.api.service.ServantService;
import com.github.fgowiki.core.bean.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jiang
 * @create 2017-12-10 19:49
 **/
@RestController
@RequestMapping("/servant")
public class ServantController {

    @Autowired
    private ServantService service;

    @GetMapping(value = "/{servantId}")
    public ResultBean<FgoServant> getServant(@PathVariable("servantId") Integer servantId) {
        return new ResultBean<>(service.get(servantId));
    }

    @GetMapping(value = "/")
    public ResultBean<List<FgoServant>> getServantList(Integer pageNum, Integer pageSize) {
	    Page<FgoServant> page = service.getList(pageNum, pageSize);
	    ResultBean<List<FgoServant>> result = new ResultBean<>(page.getContent());
	    result.setPageNum(page.getNumber());
	    result.setToatlSize(page.getTotalElements());
	    return result;
    }
}
