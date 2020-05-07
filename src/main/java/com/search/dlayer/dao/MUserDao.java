package com.search.dlayer.dao;

import java.util.List;
import com.search.dlayer.entity.MUser;

/**
 * ユーザDao（インタフェース）
 *
 * @author hitac
 *
 */
public interface MUserDao {

    /**
     * 登録
     *
     * @param muser
     * @return
     */
    public int insert(MUser muser);

    /**
     * 検索
     *
     * @param id
     * @return
     */
    public List<MUser> search(String id);

    /**
     * 更新
     *
     * @param muser
     * @return
     */
    public int update(MUser muser);

    /**
     * 削除
     *
     * @param muser
     * @return
     */
    public int delete(MUser muser);
}
