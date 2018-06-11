package com.me.code.project.common.utils;

import com.me.code.project.common.exceptions.BaseException;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author zhull
 * @date 2018/6/11
 * <P>参数校验工具</P>
 */
@Slf4j
public class ValidateUtil {

    private static Validator validator;

    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    public static <T> void validate(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> violations = validator.validate(object, groups);
        for (ConstraintViolation violation : violations) {
            throw new BaseException(violation.getPropertyPath() + " " + violation.getMessage());
        }
    }

    public static <T> void validateAll(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> violations = validator.validate(object, groups);
        if (violations.size() > 0) {
            List<String> messages = new ArrayList<>();
            for (ConstraintViolation violation : violations) {
                messages.add(violation.getPropertyPath() + " " + violation.getMessage());
            }
            throw new BaseException(messages.toString());
        }
    }

}
