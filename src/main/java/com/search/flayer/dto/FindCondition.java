package com.search.flayer.dto;

import java.util.Date;

/**
 * バックエンド（Service、Repository）で検索条件を扱うクラス
 * @author hitac
 *
 */
public class FindCondition {

    private static final long serialVersionUID = 1L;

    private String todoTitle;

    private Boolean finished;

    public String getTodoTitle() {
        return todoTitle;
    }

    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    private Date createdAt;
}
