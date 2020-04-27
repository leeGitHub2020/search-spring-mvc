package test.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ItemExistsValidator implements ConstraintValidator<ItemExists, String> {

    @Override
    public void initialize(ItemExists annotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        // テストのため、常にfalse
        return false;
    }

}
