package com.github.fgowiki.api.controller;

import com.github.fgowiki.api.entity.FgoUser;
import com.github.fgowiki.api.service.UserService;
import com.github.fgowiki.core.bean.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：
 *
 * @author 蒋经
 * @version 1.0
 * @since 2018/3/23
 */
@RestController
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/login")
    public ResultBean<FgoUser> login(@RequestBody FgoUser user) {
        return userService.getUser(user);
    }
}
