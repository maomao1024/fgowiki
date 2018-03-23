package com.github.fgowiki.api.controller;

import com.github.fgowiki.api.entity.User;
import com.github.fgowiki.core.bean.ResultBean;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/")
@RestController
@Slf4j
public class LoginController {

	@PostMapping(path = "login")
	public ResultBean<User> login(@RequestBody User user) {
		if ("admin".equals(user.getUsername()) && "123456".equals(user.getPassword())) {
			user.setId("1");
			user.setName("张某某");
			user.setPassword("");
			user.setAvatar("https://raw.githubusercontent.com/taylorchen709/markdown-images/master/vueadmin/user.png");
			return new ResultBean<>(user);
		} else {
			return new ResultBean<>(user, "帐号/密码错误", ResultBean.FAIL);
		}
	}
}
