package com.search.flayer.impl;

import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.search.dlayer.dao.UserDao;
import com.search.dlayer.entity.User;
import com.search.flayer.LoginService;
import com.search.flayer.dto.LoginInfo;

/**
 * Loginサービス
 *
 * @author hitac
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

    /**
     * ユーザDao
     */
    @Autowired
    private UserDao userDao;

    /**
     * Dozerマープ
     */
    @Autowired
    private Mapper mapper;


    @Override
    public int insert(LoginInfo lm) {

        User user = mapper.map(lm, User.class);
        return userDao.insert(user);
    }

    @Override
    public LoginInfo search(String id) {

        List<User> result = userDao.search(id);
        if(result.size() == 0) {
            return null;
        }
        LoginInfo loginInfo = mapper.map(result.get(0), LoginInfo.class);
        return loginInfo;
    }

    @Override
    public int update(LoginInfo lm) {

        User user = mapper.map(lm, User.class);
        return userDao.update(user);
    }

    @Override
    public int delete(LoginInfo lm) {

        User user = mapper.map(lm, User.class);
        return userDao.delete(user);
    }
}
