package test;

import java.io.Serializable;
import java.util.Date;

public class ValidationForm4 implements Serializable {

    private String period;

    private Date dueDate;

    /**
     * periodを返却する。
     *
     * @return period
     */
    public String getPeriod() {
        return period;
    }

    /**
     * periodをセットする。
     *
     * @param period
     */
    public void setPeriod(String period) {
        this.period = period;
    }

    /**
     * dueDateを返却する。
     *
     * @return dueDate
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * dueDateをセットする。
     *
     * @param dueDate
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

}
