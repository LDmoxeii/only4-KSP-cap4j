package com.only4.application.validater;

import com.only4.application.queries.article.ArticleExistsQry;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.netcorepal.cap4j.ddd.Mediator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
@Constraint(validatedBy = ArticleExists.Validator.class)
public @interface ArticleExists {

    String message() default "文章不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<ArticleExists, Long> {
        @Override
        public boolean isValid(Long articleId, ConstraintValidatorContext context) {
            return Mediator.queries().send(ArticleExistsQry.Request.builder()
                    .articleId(articleId)
                    .build()).isExists();
        }
    }
}
