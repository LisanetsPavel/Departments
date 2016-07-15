package com.aimprosoft.util;

import com.aimprosoft.exception.ValidationException;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AnnotationsConfigurer;
import net.sf.oval.context.FieldContext;
import net.sf.oval.context.OValContext;
import net.sf.oval.integration.spring.BeanInjectingCheckInitializationListener;
import net.sf.oval.integration.spring.SpringCheckInitializationListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 11.07.16.
 */
@Component
public class CustomValidator {

    private AnnotationsConfigurer myConfigurer = new AnnotationsConfigurer();
    private Validator validator;

    public void validate(Object obj) throws ValidationException {

        myConfigurer.addCheckInitializationListener(SpringCheckInitializationListener.INSTANCE);
        validator = new Validator(myConfigurer);

        List<ConstraintViolation> violations = validator.validate(obj);
        if (violations.size() > 0) {
            Map<String, String> errorMap = new HashMap<>();
            for (ConstraintViolation violation : violations) {
                OValContext context = violation.getContext();
                if (context instanceof FieldContext) {
                    Field field = ((FieldContext) context).getField();
                    String filedName = field.getName();
                    String errorMessage = violation.getMessage();
                    errorMap.put(filedName, errorMessage);
                }
            }
            throw new ValidationException(errorMap);
        }
    }
}
