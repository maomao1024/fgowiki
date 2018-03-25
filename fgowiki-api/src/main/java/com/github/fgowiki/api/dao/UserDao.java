package com.github.fgowiki.api.dao;

import com.github.fgowiki.api.entity.FgoUser;
import com.github.fgowiki.core.dao.BaseDao;
import org.springframework.data.jpa.repository.Query;

/**
 * @author jiang
 * @create 2018-03-25 18:20
 **/
public interface UserDao extends BaseDao<FgoUser, Integer> {

    @Query(value = "select t from FgoUser t WHERE t.username=?1 and t.password=?2 ")
    FgoUser getUserByusernameAndPassword(String username, String password);
}
