package com.search.player;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.search.flayer.TodoService;
import com.search.flayer.dto.FindCondition;

/**
 * 検索画面のコントロール処理
 *
 * @author hitac
 *
 */
@Controller
@RequestMapping("/todos")
public class FindController {

    @Autowired
    private Mapper mapper;

    @Autowired
    private TodoService todoService;

    /**
     * 検索画面のコントロール処理
     *
     * @param form
     * @param bindingResult
     * @param pageable
     * @param model
     * @return
     */
    @GetMapping
    public String find(@Validated FindForm form, BindingResult bindingResult,
            @PageableDefault Pageable pageable, Model model) {

        // バリデーションの結果
        if (bindingResult.hasErrors()) {
            return "todos/list";
        }

        FindCondition findCondition = mapper.map(form, FindCondition.class);
        model.addAttribute("page", todoService.findAllByCondition(findCondition, pageable));

        return "todos/list";
    }

}
