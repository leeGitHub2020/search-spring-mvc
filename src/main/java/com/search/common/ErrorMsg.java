package com.search.common;

import java.io.Serializable;

/**
 * エラー情報
 *
 * @author hitac
 *
 */
public class ErrorMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * エラーID
     */
    private String errorId;
    /**
     * エラーメッセージ内容
     */
    private String message;

    /**
     * errorIdを返却する。
     *
     * @return errorId
     */
    public String getErrorId() {
        return errorId;
    }

    /**
     * errorIdをセットする。
     *
     * @param errorId
     */
    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    /**
     * messageを返却する。
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * messageをセットする。
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
