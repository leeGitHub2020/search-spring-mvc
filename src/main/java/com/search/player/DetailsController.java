package com.search.player;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.search.flayer.TodoService;

/**
 * ToDo詳細画面のコントロール
 *
 * @author hitac
 *
 */
@Controller
public class DetailsController {

    @Autowired
    private TodoService todoService;

    /**
     * 初期処理
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

    /**
     * 完了イベント処理
     *
     * @param todoId
     * @param model
     * @return
     */
    @RequestMapping(value = "details/{todoId}", params = "finish", method = RequestMethod.POST)
    public String finish(@PathVariable("todoId") String todoId, Model model) {

        String redirectUrl = StringUtils.EMPTY;

        // サービス呼び出し
        int count = todoService.finish(todoId);

        if (count == 0) {
            // 更新0件の場合
            redirectUrl = "redirect:/details/" + todoId;
        } else {
            // 更新0件以上の場合
            redirectUrl = "redirect:/details/" + todoId;
        }

        // TODO 異常系とメッセージ表示

        return redirectUrl;
    }

    /**
     * 削除イベント処理
     *
     * @param todoId
     * @param model
     * @return
     */
    @RequestMapping(value = "details/{todoId}", params = "delete", method = RequestMethod.POST)
    public String delete(@PathVariable("todoId") String todoId, Model model) {

        String redirectUrl = StringUtils.EMPTY;

        // サービス呼び出し
        int count = todoService.delete(todoId);

        if (count == 0) {
            // 削除0件の場合
            redirectUrl = "redirect:/details/" + todoId;
        } else {
            // 更新0件以上の場合
            redirectUrl = "redirect:/search";
        }

        // TODO 異常系とメッセージ表示

        return redirectUrl;
    }

}
