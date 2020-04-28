package com.search.flayer;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.search.flayer.dto.FindCondition;
import com.search.flayer.dto.FindResult;

/**
 * Todoサービスインタフェース
 *
 * @author hitac
 *
 */
public interface TodoService {

    /**
     * 検索条件によりToDoリスト検索を行う
     *
     * @param findCondition
     * @param pageable
     * @return
     */
    public List<FindResult> findAllByCondition(FindCondition findCondition, Pageable pageable);

    /**
     * todoIdによりTodo内容検索を行う
     *
     * @param todoId
     * @return
     */
    public FindResult findOne(String todoId);


    /**
     * ToDo状態変更
     *
     * @param todoId
     * @return
     */
    public int finish(String todoId);

    /**
     * ToDo削除
     *
     * @param todoId
     * @return
     */
    public int delete(String todoId);
}
