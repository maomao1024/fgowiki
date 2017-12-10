package com.github.fgowiki.web.controller;

import com.github.fgowiki.web.domain.FgoServant;
import com.github.fgowiki.web.service.FgoServantService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiang
 * @create 2017-12-10 19:49
 **/
@RestController
@RequestMapping("/api/servant")
public class FgoServantController {

    @Autowired
    private FgoServantService service;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public FgoServant getServant(@PathVariable("userId") String userId) {
        return service.get(userId);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public PageInfo<FgoServant> getServantList(Integer pageNum, Integer pageSize) {
        return service.getList(pageNum, pageSize, null);
    }
}
