package test;

import java.io.Serializable;
import test.annotation.ZipCode;

public class ValidationForm1 implements Serializable {

    @ZipCode
    private String zipCode;

    /**
     * zipCodeを返却する。
     *
     * @return zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * zipCodeをセットする。
     *
     * @param zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
