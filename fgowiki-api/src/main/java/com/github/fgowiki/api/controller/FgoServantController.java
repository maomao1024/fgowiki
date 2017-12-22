package com.github.fgowiki.api.controller;

import com.github.fgowiki.api.domain.FgoServant;
import com.github.fgowiki.api.service.FgoServantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Order;
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
        //return service.get(userId);
        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Page<FgoServant> getServantList(Integer pageNum, Integer pageSize) {
        Order idOrder = new Order(Sort.Direction.ASC, "id");
        Sort sort = new Sort(idOrder);
        PageRequest pageRequest=new PageRequest(pageNum,pageSize,sort);
        return service.getList(pageRequest);
    }
}
