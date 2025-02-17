package com.only4.application.validater.member;

import com.only4.domain.aggregates.member.Member;
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

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
@Constraint(validatedBy = FavoritesContainsArticle.Validator.class)
public @interface FavoritesContainsArticle {

    String message() default "收藏夹已有该文章";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // 可定义字段名（需在验证器中动态获取）
    String memberIdStr() default "memberId";

    String favoritesIdStr() default "favoritesId";

    String articleIdStr() default "articleId";

    class Validator implements ConstraintValidator<FavoritesContainsArticle, RequestParam<?>> {
        private String memberIdStr;
        private String favoritesIdStr;
        private String articleIdStr;

        @Override
        public void initialize(FavoritesContainsArticle constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
            memberIdStr = constraintAnnotation.memberIdStr();
            favoritesIdStr = constraintAnnotation.favoritesIdStr();
            articleIdStr = constraintAnnotation.articleIdStr();
        }

        @Override
        public boolean isValid(RequestParam request, ConstraintValidatorContext context) {
            try {
                // 反射获取字段值
                Field memberIdField = request.getClass().getDeclaredField(memberIdStr);
                Field favoritesNameField = request.getClass().getDeclaredField(favoritesIdStr);
                Field articleIdField = request.getClass().getDeclaredField(articleIdStr);

                memberIdField.setAccessible(true);
                favoritesNameField.setAccessible(true);
                articleIdField.setAccessible(true);

                Long memberId = (Long)memberIdField.get(request);
                Long favoritesId = (Long)favoritesNameField.get(request);
                Long articleId = (Long)articleIdField.get(request);

                return Mediator.repositories()
                        .findOne(JpaPredicate.byId(Member.class, memberId))
                        .orElseThrow(() -> new IllegalArgumentException("用户不存在"))
                        .favoriteHasArticle(favoritesId, articleId);
            } catch (Exception e) {
                throw new RuntimeException("反射获取字段失败", e);
            }
        }
    }
}
