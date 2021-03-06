package com.search.flayer;

import com.search.flayer.dto.LoginInfo;

/**
 * Loginサービス（インタフェース）
 *
 * @author hitac
 *
 */
public interface LoginService {

    /**
     * 登録
     *
     * @param lm
     * @return
     */
    public int insert(LoginInfo lm);

    /**
     * 検索
     *
     * @param lm
     * @return
     */
    public LoginInfo search(String id);

    /**
     * 更新
     *
     * @param lm
     * @return
     */
    public int update(LoginInfo lm);

    /**
     * 削除
     *
     * @param lm
     * @return
     */
    public int delete(LoginInfo lm);
}
