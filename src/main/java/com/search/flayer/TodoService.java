package com.search.flayer;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.search.flayer.dto.FindCondition;
import com.search.flayer.dto.FindResult;

/**
 * Todoサービスインタフェース
 *
 * @author hitac
 *
 */
@Service
public interface TodoService {

    /**
     * 検索条件により検索を行う
     *
     * @param findCondition
     * @param pageable
     * @return
     */
    public List<FindResult> findAllByCondition(FindCondition findCondition, Pageable pageable);

    /**
     * todoIdにより検索を行う
     *
     * @param todoId
     * @return
     */
    public FindResult findOne(String todoId);


}
