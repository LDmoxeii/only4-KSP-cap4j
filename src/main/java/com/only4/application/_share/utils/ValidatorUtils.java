package com.only4.application._share.utils;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Validator 校验框架工具
 *
 * @author Lion Li
 */
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidatorUtils {

    private static Validator validator;

    @Autowired
    public ValidatorUtils(Validator validator) {
        ValidatorUtils.validator = validator;
    }

    /**
     * 对给定对象进行参数校验，并根据指定的校验组进行校验
     *
     * @param object 要进行校验的对象
     * @param groups 校验组
     * @throws ConstraintViolationException 如果校验不通过，则抛出参数校验异常
     */
    public static <T> void validate(T object, Class<?>... groups) {
        if (validator == null) throw new IllegalStateException("Validator 未初始化");
        Set<ConstraintViolation<T>> validate = validator.validate(object, groups);
        if (!validate.isEmpty()) {
            throw new ConstraintViolationException("参数校验异常", validate);
        }
    }

}
