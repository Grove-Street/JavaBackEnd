package pl.ug.virtualofficebackend.common.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {LocationCheckValidator.class})
public @interface LocationCheck {

    String message() default "{LocationCheck.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Name of the field containing x1 Position.
     *
     * @return name
     */
    String x1PositionFieldName();

    /**
     * Name of the field containing y1 Position.
     *
     * @return name
     */
    String y1PositionFieldName();

    /**
     * Name of the field containing x2 Position.
     *
     * @return name
     */
    String x2PositionFieldName();

    /**
     * Name of the field containing y2 Position.
     *
     * @return name
     */
    String y2PositionFieldName();

    @Target({TYPE, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    public @interface List {
        LocationCheck[] value();
    }
}