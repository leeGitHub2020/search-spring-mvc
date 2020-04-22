package com.search.flayer;

import org.springframework.data.domain.Pageable;
import com.search.flayer.dto.FindCondition;
import com.search.flayer.dto.FindResult;

/**
 * Todoサービスインタフェース
 * @author hitac
 *
 */
public interface TodoService {
   public FindResult findAllByCondition(FindCondition findCondition, Pageable pageable);
}
