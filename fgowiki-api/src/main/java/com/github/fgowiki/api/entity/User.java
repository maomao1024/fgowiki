package com.github.fgowiki.api.entity;

import lombok.Data;

/**
 * 功能描述：
 *
 * @author 蒋经
 * @version 1.0
 * @since 2018/3/23
 */
@Data
public class User {
	String id;
	String username;
	String password;
	String avatar;
	String name;
}
