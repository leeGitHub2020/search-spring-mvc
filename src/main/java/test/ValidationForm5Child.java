package test;

import java.io.Serializable;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import test.annotation.NotSelected;
import test.annotation.Selected;

public class ValidationForm5Child implements Serializable {

    private String item; // 商品が入力された場合は@ItemExistsでマスタ存在チェック

    @NotNull(groups = Selected.class, message = "数量を入力してください")
    @Digits(integer = 3, fraction = 0, groups = Selected.class, message = "数量は３桁で入力してください")
    @Null(groups = NotSelected.class, message = "数量を入力しないでください")
    private Integer qty; // 入力対象行は@NotNullと@Digits、入力対象外行は@Null

    @NotNull(groups = Selected.class, message = "単価を入力してください")
    @Digits(integer = 3, fraction = 0, groups = Selected.class, message = "単価は３桁で入力してください")
    @Null(groups = NotSelected.class, message = "単価を入力しないでください")
    private Integer price; // 入力対象行は@NotNullと@Digits、入力対象外行は@Null

    /**
     * itemを返却する。
     *
     * @return item
     */
    public String getItem() {
        return item;
    }

    /**
     * itemをセットする。
     *
     * @param item
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * qtyを返却する。
     *
     * @return qty
     */
    public Integer getQty() {
        return qty;
    }

    /**
     * qtyをセットする。
     *
     * @param qty
     */
    public void setQty(Integer qty) {
        this.qty = qty;
    }

    /**
     * priceを返却する。
     *
     * @return price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * priceをセットする。
     *
     * @param price
     */
    public void setPrice(Integer price) {
        this.price = price;
    }


}
