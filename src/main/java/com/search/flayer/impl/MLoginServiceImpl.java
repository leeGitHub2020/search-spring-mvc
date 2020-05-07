package com.search.flayer.impl;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.search.dlayer.dao.MUserDao;
import com.search.dlayer.entity.MUser;
import com.search.flayer.MLoginService;
import com.search.flayer.base.AbstractBLogic;
import com.search.flayer.dto.LoginInfo;

/**
 * Loginサービス
 *
 * @author hitac
 *
 */
@Service
public class MLoginServiceImpl extends AbstractBLogic<LoginInfo, LoginInfo>
        implements MLoginService {

    /**
     * ログ
     */
    Logger logger = Logger.getLogger(MLoginServiceImpl.class);

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
    protected void preExecute(LoginInfo input) {
        logger.info("トランザクションが開始しました");
    }

    @Override
    protected LoginInfo doExecute(LoginInfo input) {

        // 更新1
        LoginInfo loginInfo1 = new LoginInfo();
        loginInfo1.setId(input.getId());
        loginInfo1.setName(input.getName());
        this.update(loginInfo1);

        // 更新2
        LoginInfo loginInfo2 = new LoginInfo();
        loginInfo2.setId(input.getId()+"Trans");
        loginInfo2.setName(input.getName()+"Trans");
        this.insert(loginInfo2);

        return null;
    }

    @Override
    protected void afterExecute(LoginInfo input) {
        logger.info("トランザクションが終了しました");
    }


    @Override
    public int insert(LoginInfo lm) {

        MUser muser = mapper.map(lm, MUser.class);
        return muserDao.insert(muser);
    }

    @Override
    public LoginInfo search(String id) {

        List<MUser> result = muserDao.search(id);
        if (result.size() == 0) {
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
