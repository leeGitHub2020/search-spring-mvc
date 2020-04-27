package test;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import test.annotation.ItemExists;

public class ValidationForm2 implements Serializable {

    @NotNull
    @ItemExists
    private String itemCode;

    /**
     * itemCodeを返却する。
     * @return itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * itemCodeをセットする。
     * @param  itemCode
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

}
