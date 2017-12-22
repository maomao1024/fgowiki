package com.github.fgowiki.core.dao;


import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * @author jiang
 * @create 2017-12-10 21:27
 **/
@NoRepositoryBean
public interface BaseDao<T,ID extends Serializable> extends PagingAndSortingRepository<T,ID> {

}
