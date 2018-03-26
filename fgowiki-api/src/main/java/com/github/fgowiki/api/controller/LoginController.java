package com.github.fgowiki.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.fgowiki.api.entity.FgoUser;
import com.github.fgowiki.api.service.UserService;
import com.github.fgowiki.core.bean.ResultBean;
import com.github.fgowiki.exception.UnloginException;
import com.github.fgowiki.utils.TokenUtils;
import com.google.common.base.Strings;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.log.LogOutputStream;

import java.text.SimpleDateFormat;

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
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String, String> template;

    @PostMapping(path = "/login")
    public ResultBean<JSONObject> login(@RequestBody FgoUser user) throws Exception {
        user = userService.getUser(user);
        String tokenKey = "userToken" + user.getUid();
        String token = template.opsForValue().get(tokenKey);
        if (Strings.isNullOrEmpty(token)) {
            token = TokenUtils.generateToken(user);
            template.opsForValue().set(tokenKey, token);
        }
        Claims claims;
        try {
            claims = TokenUtils.parse(token);
        } catch (Exception e) {
            template.delete(tokenKey);
            throw new UnloginException("请重新登录");
        }
        if (claims.getExpiration().getTime() > System.currentTimeMillis()) {
            template.delete(tokenKey);
            throw new UnloginException("请重新登录");
        }
        JSONObject obj = new JSONObject();
        obj.put("token", token);
        obj.put("username", user.getUsername());
        obj.put("expiration", claims.getExpiration().getTime());
        return new ResultBean<>(obj);
    }

}
