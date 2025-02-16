package com.only4.application.validater.article;

import com.only4.domain.aggregates.article.Article;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Objects;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
@Constraint(validatedBy = ArticleCategoryExists.Validator.class)
public @interface ArticleCategoryExists {
    String message() default "文章评论不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // 可定义字段名（需在验证器中动态获取）
    String articleIdStr() default "articleId";

    String categoryIdStr() default "categoryId";

    class Validator implements ConstraintValidator<ArticleCategoryExists, RequestParam<?>> {
        private String articleIdStr;
        private String categoryIdStr;

        @Override
        public void initialize(ArticleCategoryExists constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
            articleIdStr = constraintAnnotation.articleIdStr();
            categoryIdStr = constraintAnnotation.categoryIdStr();
        }

        @Override
        public boolean isValid(RequestParam request, ConstraintValidatorContext context) {
            try {
                // 反射获取字段值
                Field articleField = request.getClass().getDeclaredField(articleIdStr);
                Field categoryIdField = request.getClass().getDeclaredField(categoryIdStr);
                articleField.setAccessible(true);
                categoryIdField.setAccessible(true);

                Object articleId = articleField.get(request);
                Object categoryId = categoryIdField.get(request);

                return Mediator.repositories()
                        .findOne(JpaPredicate.byId(Article.class, articleId))
                        .orElseThrow(() -> new IllegalArgumentException("文章不存在"))
                        .getArticleCategories().stream()
                        .anyMatch(articleCategory -> Objects.equals(articleCategory.getId(), categoryId));
            } catch (Exception e) {
                throw new RuntimeException("反射获取字段失败", e);
            }
        }
    }
}
