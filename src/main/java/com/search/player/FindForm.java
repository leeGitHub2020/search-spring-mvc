package com.search.player;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * 検索画面のフォーム
 *
 * @author hitac
 *
 */
public class FindForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 10)
    private String todoTitle;

    private Boolean finished;

    @DateTimeFormat(iso = ISO.DATE)
    @Past
    private Date createdAt;

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
}
