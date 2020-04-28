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
import com.search.player.base.BaseController;
import com.search.player.check.SearchCheck;

/**
 * ToDo検索画面のコントロール
 *
 * @author hitac
 *
 */
@Controller
public class FindController extends BaseController {

    /**
     * ToDo検索処理のサービス
     */
    @Autowired
    private TodoService todoService;

    /**
     * Dozerマープ
     */
    @Autowired
    private Mapper mapper;

    /**
     * バリデーション
     */
    @Autowired
    private SearchCheck searchCheck;


    // /**
    // * バリデーションビンダ
    // *
    // * @param binder
    // */
    // @InitBinder
    // public void validatorBinder(WebDataBinder binder) {
    // binder.addValidators(searchCheck);
    // }

    /**
     * ToDo検索コントロール
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

        // 送還チェック
        searchCheck.validate(form, bindingResult);
        if (bindingResult.hasErrors()) {
            if(bindingResult.getGlobalErrorCount()>0) {
                model.addAttribute("searchError", bindingResult.getGlobalError().getDefaultMessage());
            }

            return "search";
        }

        // 検索条件
        FindCondition findCondition = mapper.map(form, FindCondition.class);
        // サービス検索呼び出し
        List<FindResult> findList = todoService.findAllByCondition(findCondition, pageable);

        // 検索内容をモデルに設定
        if (findList != null && findList.size() > 0) {
            model.addAttribute("page",
                    new PageImpl<FindResult>(findList, pageable, findList.size()));
        } else {
            model.addAttribute("page", null);
        }

        return "search";
    }

}
