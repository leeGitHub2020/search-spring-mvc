package test;

import java.io.Serializable;
import java.util.List;

public class ValidationForm5 implements Serializable {

    private List<ValidationForm5Child> validationForm5ChildList;

    /**
     * validationForm5ChildListを返却する。
     *
     * @return validationForm5ChildList
     */
    public List<ValidationForm5Child> getValidationForm5ChildList() {
        return validationForm5ChildList;
    }

    /**
     * validationForm5ChildListをセットする。
     *
     * @param validationForm5ChildList
     */
    public void setValidationForm5ChildList(List<ValidationForm5Child> validationForm5ChildList) {
        this.validationForm5ChildList = validationForm5ChildList;
    }


}
