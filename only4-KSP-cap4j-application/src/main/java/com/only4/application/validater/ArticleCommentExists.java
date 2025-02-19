package com.only4.application.validater;

import com.only4.domain.aggregates.article_comment.ArticleComment;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
@Constraint(validatedBy = ArticleCommentExists.Validator.class)
public @interface ArticleCommentExists {
    String message() default "文章评论不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<ArticleExists, Long> {
        @Override
        public boolean isValid(Long commentId, ConstraintValidatorContext context) {
            return Mediator.repositories().exists(JpaPredicate.byId(ArticleComment.class, commentId));
        }
    }
}
