package test;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class ValidationForm3 implements Serializable {

    @DateTimeFormat(iso = ISO.DATE)
    // setter, getterは省略
    @NotNull(message = "開始日付は空ですので、もう一度入力してください")
    private Date dateFrom;

    @DateTimeFormat(iso = ISO.DATE)
    @NotNull(message = "終了日付は空ですので、もう一度入力してください")
    private Date dateTo;

    private boolean validDate;

    @AssertTrue(message = "入力されている日付範囲が不正です")
    public boolean isValidDate() {
        if (dateFrom == null)
            return true;
        if (dateTo == null)
            return true;
        if (dateFrom.compareTo(dateTo) <= 0)
            return true;
        return false;
    }

    /**
     * dateFromを返却する。
     *
     * @return dateFrom
     */
    public Date getDateFrom() {
        return dateFrom;
    }

    /**
     * dateFromをセットする。
     *
     * @param dateFrom
     */
    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    /**
     * dateToを返却する。
     *
     * @return dateTo
     */
    public Date getDateTo() {
        return dateTo;
    }

    /**
     * dateToをセットする。
     *
     * @param dateTo
     */
    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    /**
     * validDateをセットする。
     *
     * @param validDate
     */
    public void setValidDate(boolean validDate) {
        this.validDate = validDate;
    }

}
