package com.search.player;

import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.search.flayer.TodoService;
import com.search.flayer.dto.FindCondition;
import com.search.flayer.dto.FindResult;

/**
 * 検索画面のコントロール処理
 *
 * @author hitac
 *
 */
@Controller
public class FindController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private Mapper mapper;

    /**
     * 検索画面のコントロール処理
     *
     * @param form
     * @param bindingResult
     * @param pageable
     * @param model
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String find(@Validated FindForm form, BindingResult bindingResult,
            @PageableDefault Pageable pageable, Model model) {

        // バリデーションの結果
        if (bindingResult.hasErrors()) {
            return "search";
        }

        // 検索条件
        FindCondition findCondition = mapper.map(form, FindCondition.class);
        // サービス検索呼び出し
        List<FindResult> findList = todoService.findAllByCondition(findCondition, pageable);

        // 検索内容をモデルに設定
        if (findList != null && findList.size() > 0) {
            model.addAttribute("page", new PageImpl<FindResult>(findList, pageable, findList.size()));
        } else {
            model.addAttribute("page", null);
        }

        return "search";
    }

}
