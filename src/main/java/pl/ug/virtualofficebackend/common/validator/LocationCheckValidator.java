package pl.ug.virtualofficebackend.common.validator;

import org.springframework.util.ReflectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class LocationCheckValidator implements ConstraintValidator<LocationCheck, Object> {
    public String x1PositionFieldName;
    public String y1PositionFieldName;
    public String x2PositionFieldName;
    public String y2PositionFieldName;

    @Override
    public void initialize(LocationCheck constraintAnnotation) {
        this.x1PositionFieldName = constraintAnnotation.x1PositionFieldName();
        this.y1PositionFieldName = constraintAnnotation.y1PositionFieldName();
        this.x2PositionFieldName = constraintAnnotation.x2PositionFieldName();
        this.y2PositionFieldName = constraintAnnotation.y2PositionFieldName();
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        /*
         * XDDDDDDD
         */

        try {
            Class<?> clazz = value.getClass();

            Field x1PositionField = ReflectionUtils.findField(clazz, x1PositionFieldName);
            Field y1PositionField = ReflectionUtils.findField(clazz, y1PositionFieldName);
            Field x2PositionField = ReflectionUtils.findField(clazz, x2PositionFieldName);
            Field y2PositionField = ReflectionUtils.findField(clazz, y2PositionFieldName);

            assert x1PositionField != null;
            assert y1PositionField != null;
            assert x2PositionField != null;
            assert y2PositionField != null;

            x1PositionField.setAccessible(true);
            y1PositionField.setAccessible(true);
            x2PositionField.setAccessible(true);
            y2PositionField.setAccessible(true);

            int x1Position = (int) x1PositionField.get(value);
            int y1Position = (int) y1PositionField.get(value);
            int x2Position = (int) x2PositionField.get(value);
            int y2Position = (int) y2PositionField.get(value);

            ConstraintValidatorContext.ConstraintViolationBuilder cvb =
                    context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate());

            if (x1Position >= x2Position || y1Position >= y2Position) {
                cvb.addConstraintViolation();
                return false;
            }

            if (!(x2Position - x1Position == y2Position - y1Position)) {
                cvb.addConstraintViolation();
                return false;
            }

        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
