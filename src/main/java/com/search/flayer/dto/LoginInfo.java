package com.search.flayer.dto;

import com.search.flayer.base.BaseDto;

/**
 * ログイン情報
 * @author hitac
 *
 */
public class LoginInfo extends BaseDto {

    /**
     * ユーザーID
     */
    String id;

    /**
     * ユーザー名
     */
    String name;

    /**
     * ロール
     */
    String role;

    /**
     * idを返却する。
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * idをセットする。
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * nameを返却する。
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * nameをセットする。
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * roleを返却する。
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * roleをセットする。
     * @param  role
     */
    public void setRole(String role) {
        this.role = role;
    }
}
