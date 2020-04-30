package com.search.flayer.impl;

import java.util.List;
import javax.annotation.Resource;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.search.dlayer.dao.MUserDao;
import com.search.dlayer.entity.MUser;
import com.search.flayer.MLoginService;
import com.search.flayer.dto.LoginInfo;

/**
 * Loginサービス
 *
 * @author hitac
 *
 */
@Service
public class MLoginServiceImpl implements MLoginService {

    /**
     * ユーザDao
     */
    @Resource
    private MUserDao muserDao;

    /**
     * Dozerマープ
     */
    @Autowired
    private Mapper mapper;


    @Override
    public int insert(LoginInfo lm) {

        MUser muser = mapper.map(lm, MUser.class);
        return muserDao.insert(muser);
    }

    @Override
    public LoginInfo search(String id) {

        List<MUser> result = muserDao.search(id);
        if(result.size() == 0) {
            return null;
        }
        LoginInfo loginInfo = mapper.map(result.get(0), LoginInfo.class);
        return loginInfo;
    }

    @Override
    public int update(LoginInfo lm) {

        MUser muser = mapper.map(lm, MUser.class);
        return muserDao.update(muser);
    }

    @Override
    public int delete(LoginInfo lm) {

        MUser muser = mapper.map(lm, MUser.class);
        return muserDao.delete(muser);
    }
}
