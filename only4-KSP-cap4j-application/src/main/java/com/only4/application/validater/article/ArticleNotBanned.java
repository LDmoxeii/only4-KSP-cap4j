package com.only4.application.validater.article;

import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.article.meta.ArticleSchema;
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
import java.time.LocalDateTime;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
@Constraint(validatedBy = ArticleNotBanned.Validator.class)
public @interface ArticleNotBanned {

    String message() default "文章已处于封禁状态";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<ArticleNotBanned, Integer>

    {

        @Override
        public boolean isValid(Integer banDuration, ConstraintValidatorContext context) {

            return !Mediator.repositories().exists(JpaPredicate.bySpecification(Article.class,
                    ArticleSchema.specify(article ->
                            article.all(
                                    article.bannedAt().isNotNull(),
                                    article.banDuration().greaterThan(0),
                                    article.bannedAt().greaterThan(LocalDateTime.now().minusMinutes(banDuration))
                            )

                    ))
            );
        }
    }
}
