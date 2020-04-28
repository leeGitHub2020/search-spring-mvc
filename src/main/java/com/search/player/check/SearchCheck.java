package com.search.player.check;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.search.common.DateUtils;
import com.search.player.FindForm;

/**
 * 検索のバリデーション
 *
 * @author hitac
 *
 */
@Component
public class SearchCheck implements Validator {

    // 検索開始年月日
    private static final String SEARCH_DATE_START = "2020-01-01";

    @Override
    public boolean supports(Class<?> clazz) {
        return FindForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        FindForm findForm = (FindForm) target;

        // ToDoタイトル取得
        String todoTitle = findForm.getTodoTitle();
        // 登録日付取得
        Date createdAt = findForm.getCreatedAt();

        if (createdAt != null && StringUtils.isNotEmpty(todoTitle)) {

            // 日付フォーマット
            String fcreateDate = DateUtils.formatDateToString(createdAt, DateUtils.DATE_FORMAT_YMD);

            // 2020年以降の検索について、接頭詞は"2020"からチェック。
            if (fcreateDate.compareTo(SEARCH_DATE_START) > 0) {
                if (!todoTitle.startsWith("2020")) {
                    errors.reject("e.fg.01",
                            "2020年以降の登録済みのToDo内容について、ToDoタイトルの接頭詞は必ず「2020」で利用してください。");
                }
            }
        }

    }

}
