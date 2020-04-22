package com.search.flayer.impl;

import org.springframework.data.domain.Pageable;
import com.search.flayer.TodoService;
import com.search.flayer.dto.FindCondition;
import com.search.flayer.dto.FindResult;

/**
 * Todoサービスの実現クラス
 * @author hitac
 *
 */
public class TodoServiceImpl implements TodoService{

    @Override
    public FindResult findAllByCondition(FindCondition findCondition, Pageable pageable) {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

}
