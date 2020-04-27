package test.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

@Target(java.lang.annotation.ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ItemExistsValidator.class}) // Validatorの実装クラスを指定
@ReportAsSingleViolation
public @interface ItemExists {

    String message() default "商品コードが存在しません";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target(java.lang.annotation.ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public static @interface List {
        ItemExists[] value();
    }

}
