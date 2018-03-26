package com.github.fgowiki.api.controller;

import com.github.fgowiki.core.bean.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * 功能描述：
 *
 * @author 蒋经
 * @version 1.0
 * @since 2018/3/23
 */
@RequestMapping("/cache")
@RestController
@Slf4j
public class CacheController {


	@Autowired
	private CacheManager cacheManager;

	/**
	 * 得到所有的cache
	 *
	 * @return
	 */
	@GetMapping("/names")
	public Collection<String> index() {
		return cacheManager.getCacheNames();
	}

	/**
	 * 清空某个cache
	 *
	 * @param name
	 * @return
	 */
	@PostMapping("/clear")
	public Boolean clear(@RequestParam String name) {
		log.info("clear cache : {}", name);
		cacheManager.getCache(name).clear();
		return true;
	}

	/**
	 * 清空所有cache
	 *
	 * @return
	 */
	@PostMapping("/clearAll")
	public Boolean clearAll() {
		log.info("clear all cache ...");
		Collection<String> cacheNames = cacheManager.getCacheNames();
		for (String name : cacheNames) {
			log.info("clear cache : {}", name);
			cacheManager.getCache(name).clear();
		}
		return true;
	}

}
