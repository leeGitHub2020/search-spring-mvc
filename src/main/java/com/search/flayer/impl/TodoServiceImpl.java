package com.search.flayer.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.search.common.DateUtils;
import com.search.flayer.TodoService;
import com.search.flayer.dto.FindCondition;
import com.search.flayer.dto.FindResult;

/**
 * Todoサービスの実現クラス
 *
 * @author hitac
 *
 */
@Service
public class TodoServiceImpl implements TodoService {

    /**
     * 検索条件によりToDoリスト検索を行う
     *
     * @param findCondition
     * @param pageable
     * @return
     */
    @Override
    public List<FindResult> findAllByCondition(FindCondition findCondition, Pageable pageable) {

        // TODO DBの検索動作
        List<FindResult> resultList = new ArrayList<>();

        FindResult result1 = new FindResult();
        result1.setTodoId("1");
        result1.setTodoTitle("タイトル１");
        result1.setCreatedAt(DateUtils.formatStringToDate("2020-04-01", DateUtils.DATE_FORMAT_YMD));
        result1.setFinished(Boolean.FALSE);
        resultList.add(result1);

        FindResult result2 = new FindResult();
        result2.setTodoId("2");
        result2.setTodoTitle("タイトル２");
        result2.setCreatedAt(DateUtils.formatStringToDate("2020-04-02", DateUtils.DATE_FORMAT_YMD));
        result2.setFinished(Boolean.FALSE);
        resultList.add(result2);

        FindResult result3 = new FindResult();
        result3.setTodoId("3");
        result3.setTodoTitle("タイトル３");
        result3.setCreatedAt(DateUtils.formatStringToDate("2020-04-03", DateUtils.DATE_FORMAT_YMD));
        result3.setFinished(Boolean.FALSE);
        resultList.add(result3);

        return resultList;
    }

    /**
     * todoIdによりToDo内容検索を行う
     *
     * @param todoId
     * @return
     */
    @Override
    public FindResult findOne(String todoId) {

        // TODO DBの検索動作
        FindResult result = new FindResult();
        result.setTodoId(todoId);
        result.setTodoTitle("タイトル１");
        result.setCreatedAt(DateUtils.formatStringToDate("2020-04-01", DateUtils.DATE_FORMAT_YMD));
        result.setFinished(Boolean.FALSE);

        return result;
    }

    /**
     * ToDo状態変更
     */
    @Override
    public int finish(String todoId) {
        // TODO 自動生成されたメソッド・スタブ
        return 1;
    }

    /**
     * ToDo削除
     */
    @Override
    public int delete(String todoId) {
        // TODO 自動生成されたメソッド・スタブ
        return 1;
    }


}
