package com.github.fgowiki.core.service;

import com.github.fgowiki.core.bean.ResultBean;
import com.github.fgowiki.core.dao.BaseDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 功能描述：
 *
 * @author 蒋经
 * @version 1.0
 * @since 2017/12/22
 */
@EnableCaching
public abstract class BaseService<T, ID extends Serializable> {

	private static final int DEFAULT_PAGE_SIZE = 10;

	abstract protected BaseDao<T, ID> getDao();

	/**
	 * 获取分页数据 默认按id正序排序
	 *
	 * @param pageNum  当眼页
	 * @param pageSize 分页大小
	 * @return
	 */
	public Page<T> getList(Integer pageNum, Integer pageSize) {
		LinkedHashMap<String, Sort.Direction> sorts = new LinkedHashMap<>();
		sorts.put("id", Sort.Direction.ASC);
		return getList(pageNum, pageSize, sorts);
	}

	/**
	 * 获取分页数据
	 *
	 * @param pageNum  当前页
	 * @param pageSize 分页大小
	 * @param sorts    排序字段 key为排序的字段，value为排序方式，取值为Sort.Direction枚举
	 * @return 分页数据
	 * @see Sort.Direction
	 */
	public Page<T> getList(Integer pageNum, Integer pageSize, LinkedHashMap<String, Sort.Direction> sorts) {
		Sort sort = null;
		if (sorts != null && sorts.size() > 0) {
			List<Sort.Order> orderList = new ArrayList<>();
			sorts.forEach((direction, property) -> orderList.add(new Sort.Order(property, direction)));
			sort = new Sort(orderList);
		}
		PageRequest pageRequest = new PageRequest((pageNum == null || pageNum < 0) ? 0 : pageNum, (pageSize == null || pageSize < 0) ? DEFAULT_PAGE_SIZE : pageSize, sort);
		return getDao().findAll(pageRequest);
	}

	/**
	 * 根据id获取记录
	 *
	 * @param id
	 * @return
	 */
	public T get(ID id) {
		return getDao().findOne(id);
	}
}
