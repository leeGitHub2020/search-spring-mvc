package com.search.player;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * ToDo検索画面のフォーム
 *
 * @author hitac
 *
 */
public class FindForm implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ToDoタイトル
     */
    @Size(max = 10)
    private String todoTitle;

    /**
     * ToDoタイトル
     */
    private Boolean finished;

    /**
     * 登録日付
     */
    @DateTimeFormat(iso = ISO.DATE)
    @Past
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
