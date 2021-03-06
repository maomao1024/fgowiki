package com.github.fgowiki.api.service;

import com.github.fgowiki.api.dao.UserDao;
import com.github.fgowiki.api.entity.FgoUser;
import com.github.fgowiki.core.dao.BaseDao;
import com.github.fgowiki.core.service.BaseService;
import com.github.fgowiki.exception.CheckedException;
import com.github.fgowiki.utils.RequestUtils;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @author jiang
 * @create 2018-03-25 18:19
 **/
@Service
public class UserService extends BaseService<FgoUser, Integer> {
    @Autowired
    private UserDao dao;

    @Override
    protected BaseDao<FgoUser, Integer> getDao() {
        return dao;
    }

    public FgoUser getUser(FgoUser user) {
        if (user == null || Strings.isNullOrEmpty(user.getUsername()) || Strings.isNullOrEmpty(user.getPassword())) {
            throw new CheckedException("帐号/密码不能为空");
        }
        user = dao.getUserByusernameAndPassword(user.getUsername(), user.getPassword());
        if (user == null) {
            throw new CheckedException("帐号/密码错误");
        } else {
            user.setLoginIp(RequestUtils.getIpAddr());
            user.setLoginTime(new Timestamp(System.currentTimeMillis()));
            dao.saveAndFlush(user);
            return user;
        }
    }

}
