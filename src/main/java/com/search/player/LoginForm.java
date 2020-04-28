package com.search.player;

public class LoginForm {

    /**
     * ID
     */
    private String id;

    /**
     * ユーザー名
     */
    private String name;

    /**
     * 操作種別
     */
    private String todo;

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
     * todoを返却する。
     *
     * @return todo
     */
    public String getTodo() {
        return todo;
    }

    /**
     * todoをセットする。
     *
     * @param todo
     */
    public void setTodo(String todo) {
        this.todo = todo;
    }
}
