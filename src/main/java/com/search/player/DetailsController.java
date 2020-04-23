package com.search.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.search.flayer.TodoService;

/**
 * 検索詳細画面のコントロール処理
 *
 * @author hitac
 *
 */
@Controller
public class DetailsController {

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
    @RequestMapping(value = "details/{todoId}", method = RequestMethod.GET)
    public String details(@PathVariable("todoId") String todoId, Model model) {

        model.addAttribute("todo", todoService.findOne(todoId));

        return "details";
    }

}
