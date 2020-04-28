package com.search.dlayer.entity;

/**
 * ユーザー情報
 *
 * @author hitac
 *
 */
public class User {
    /**
     * ユーザーID
     */
    String id;

    /**
     * ユーザー名
     */
    String name;

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
}
