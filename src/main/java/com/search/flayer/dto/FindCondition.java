package com.search.flayer.dto;

import java.util.Date;

/**
 * Todo内容検索条件
 *
 * @author hitac
 *
 */
public class FindCondition {

    private static final long serialVersionUID = 1L;

    /**
     * Todoタイトル
     */
    private String todoTitle;

    /**
     * 状態
     */
    private Boolean finished;

    /**
     * 登録日付
     */
    private Date createdAt;

    /**
     * todoTitleを返却する。
     *
     * @return todoTitle
     */
    public String getTodoTitle() {
        return todoTitle;
    }

    /**
     * todoTitleをセットする。
     *
     * @param todoTitle
     */
    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    /**
     * finishedを返却する。
     *
     * @return finished
     */
    public Boolean getFinished() {
        return finished;
    }

    /**
     * finishedをセットする。
     *
     * @param finished
     */
    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    /**
     * createdAtを返却する。
     *
     * @return createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * createdAtをセットする。
     *
     * @param createdAt
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * serialversionuidを返却する。
     *
     * @return serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }



}
