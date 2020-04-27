package test;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.validate.Validator4;

/**
 * バリデーションテスト用コントロール
 *
 * @author hitac
 *
 */
@Controller
public class Validation4Controller {

    @Autowired
    Validator4 validator4;

    @InitBinder
    public void validatorBinder(WebDataBinder binder) {
        binder.addValidators(validator4);
    }

    @InitBinder
    public void dateBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @ModelAttribute("radios")
    public Map<String, String> radioList() {
        return Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
            {
                put("A", "当日");
                put("B", "期間指定");
            }
        });
    }

    @RequestMapping(value = "test/validation4", method = RequestMethod.GET)
    public String index(ValidationForm4 form, Model model) {
        return "test/validation4";
    }

    @RequestMapping(value = "test/validation4", method = RequestMethod.POST)
    public String confirm(@Validated ValidationForm4 form, BindingResult bindingResult,
            Model model) {
        // 入力チェックエラーがある場合は入力画面に戻る
        if (bindingResult.hasErrors()) {
            return "test/validation4";
        }
        // 入力チェックエラーがない場合は確認画面に遷移する
        model.addAttribute("validationForm4", form);
        // ラジオボタンの表示名を設定
        model.addAttribute("selectedPeriod", radioList().get(form.getPeriod()));
        return "test/validation4";
    }
}
