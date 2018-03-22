package com.github.fgowiki.core.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author jiang
 * @create 2017-12-10 21:27
 **/
@NoRepositoryBean
public interface BaseDao<T,ID extends Serializable> extends JpaRepository<T,ID> {

}
