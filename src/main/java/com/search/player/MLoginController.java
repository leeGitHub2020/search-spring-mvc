package com.search.player;

import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.search.flayer.MLoginService;
import com.search.flayer.dto.LoginInfo;
import com.search.player.base.BaseController;

/**
 * ログインコントロール
 *
 * @author hitac
 *
 */
@Controller
public class MLoginController extends BaseController {

    /**
     * ログ
     */
    Logger logger = Logger.getLogger(MLoginController.class);


    /**
     * 操作種別：登録
     */
    private static final String SAVE = "1";

    /**
     * 操作種別：検索
     */
    private static final String SEARCH = "2";

    /**
     * 操作種別；更新
     */
    private static final String UPDATE = "3";

    /**
     * 操作種別；削除
     */
    private static final String DELETE = "4";

    /**
     * 操作種別；トランザクション
     */
    private static final String TRANSACTION = "5";

    /**
     * ログインサービス
     */
    @Autowired
    private MLoginService mloginService;

    /**
     * Dozerマープ
     */
    @Autowired
    private Mapper mapper;


    @Autowired
    MessageSource message;

    /**
     * モデル初期化
     *
     * @return
     */
    @ModelAttribute("mlogin")
    public MLoginForm init() {
        return new MLoginForm();
    }

    /**
     * 初期表示
     *
     * @return
     */
    @RequestMapping(value = "mlogin", method = RequestMethod.GET)
    public String loginGet() {
        return "mlogin";
    }

    @RequestMapping(value = "mlogin",method = RequestMethod.POST)
    public ModelAndView loginPost(@ModelAttribute("mlogin") MLoginForm mloginForm) {

        // モデル取得
        ModelAndView mv = new ModelAndView("mlogin");

        // 操作種別を取得する
        String todo = mloginForm.getTodo();
        if (StringUtils.isEmpty(todo)) {
            mv.addObject("msg", message.getMessage("mlogin.msg.01", null, Locale.getDefault()));
        } else if (SAVE.equals(todo)) {
            // 登録情報取得
            LoginInfo loginInfo = mapper.map(mloginForm, LoginInfo.class);
            // サービス呼び出し
            int count = mloginService.insert(loginInfo);
            if (count > 0) {
                mv.addObject("msg", "ユーザー情報を登録しました。");
            } else {
                mv.addObject("msg", "ユーザー情報の登録が失敗しました。");
            }
        } else if (SEARCH.equals(todo)) {
            // サービス呼び出し
            LoginInfo loginInfo = mloginService.search(mloginForm.getId());
            if (loginInfo == null) {
                mv.addObject("msg", "検索内容が見つかりませんでした。");
            } else {
                mloginForm.setName(loginInfo.getName());
            }
        } else if (UPDATE.equals(todo)) {
            // 更新情報取得
            LoginInfo loginInfo = mapper.map(mloginForm, LoginInfo.class);
            // サービス呼び出し
            int count = mloginService.update(loginInfo);
            if (count > 0) {
                mv.addObject("msg", "ユーザー情報を更新しました。");
            } else {
                mv.addObject("msg", "ユーザー情報の更新が失敗しました。");
            }
        } else if (DELETE.equals(todo)) {
            // 削除情報取得
            LoginInfo loginInfo = mapper.map(mloginForm, LoginInfo.class);
            // サービス呼び出し
            int count = mloginService.delete(loginInfo);
            if (count > 0) {
                mv.addObject("msg", "ユーザー情報を削除しました。");
            } else {
                mv.addObject("msg", "ユーザー情報の削除が失敗しました。");
            }
        } else if (TRANSACTION.equals(todo)) {

            // 削除情報取得
            LoginInfo input = mapper.map(mloginForm, LoginInfo.class);

            try {
                mloginService.execute(input);
                mv.addObject("msg", "ネム更新がしました。");
            } catch (Exception e) {
                logger.error("", e);
                mv.addObject("msg", "トランザクションがが失敗しました。");
            }
        }
        return mv;
    }

}
