package com.github.fgowiki.api.controller;

import com.github.fgowiki.api.entity.FgoServant;
import com.github.fgowiki.api.service.FgoServantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiang
 * @create 2017-12-10 19:49
 **/
@RestController
@RequestMapping("/servant")
public class FgoServantController {

    @Autowired
    private FgoServantService service;

    @RequestMapping(value = "/{servant}", method = RequestMethod.GET)
    public FgoServant getServant(@PathVariable("servant") Integer userId) {
        return service.get(userId);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Page<FgoServant> getServantList(Integer pageNum, Integer pageSize) {
        return service.getList(pageNum, pageSize);
    }
}
