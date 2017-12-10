package com.github.fgowiki.core.dao;


import java.util.List;

/**
 * @author jiang
 * @create 2017-12-10 21:27
 **/
public interface BaseMapper<T> {

    int insert(T record);

    List<T> selectAll();

    T get(String userId);

}
