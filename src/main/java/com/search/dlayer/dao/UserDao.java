package com.search.dlayer.dao;

import java.util.List;
import com.search.dlayer.entity.User;

/**
 * ユーザDao（インタフェース）
 *
 * @author hitac
 *
 */
public interface UserDao {

    /**
     * 登録
     *
     * @param user
     * @return
     */
    public int insert(User user);

    /**
     * 検索
     *
     * @param id
     * @return
     */
    public List<User> search(String id);

    /**
     * 更新
     *
     * @param user
     * @return
     */
    public int update(User user);

    /**
     * 削除
     *
     * @param user
     * @return
     */
    public int delete(User user);
}
