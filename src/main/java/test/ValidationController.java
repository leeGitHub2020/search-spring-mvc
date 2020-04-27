package test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * バリデーションテスト用コントロール
 *
 * @author hitac
 *
 */
@Controller
public class ValidationController {


    /**
     * 初期表示
     * @param bindingResult
     * @param model
     * @return
     */
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String find(Model model) {

//        model.addAttribute("validationForm1", new ValidationForm1());
//        model.addAttribute("validationForm2", new ValidationForm2());
        model.addAttribute("validationForm3", new ValidationForm3());

        return "test/validationTest";
    }


//    /**
//     * バリデーションテスト１
//     *
//     * @param form
//     * @param bindingResult
//     * @param pageable
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "test/validationTest/form1", method = RequestMethod.POST)
//    public String find(@Validated ValidationForm1 form, BindingResult bindingResult, Model model) {
//
//        // バリデーションの結果
//        if (bindingResult.hasErrors()) {
//            return "test/validationTest";
//        }
//
//        return "test/validationTest";
//    }

//    /**
//     * バリデーションテスト２
//     *
//     * @param form
//     * @param bindingResult
//     * @param pageable
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "test/validationTest/form2", method = RequestMethod.POST)
//    public String find(@Validated ValidationForm2 form, BindingResult bindingResult, Model model) {
//
//        // バリデーションの結果
//        if (bindingResult.hasErrors()) {
//            return "test/validationTest";
//        }
//
//        return "test/validationTest";
//    }

    /**
     * バリデーションテスト３
     *
     * @param form
     * @param bindingResult
     * @param pageable
     * @param model
     * @return
     */
    @RequestMapping(value = "test/validationTest/form3", method = RequestMethod.POST)
    public String find(@Validated ValidationForm3 form, BindingResult bindingResult, Model model) {

        // バリデーションの結果
        if (bindingResult.hasErrors()) {
            return "test/validationTest";
        }

        return "test/validationTest";
    }

}
