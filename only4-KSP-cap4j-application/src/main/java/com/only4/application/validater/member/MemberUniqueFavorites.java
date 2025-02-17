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
import java.util.Objects;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
@Constraint(validatedBy = MemberUniqueFavorites.Validator.class)
public @interface MemberUniqueFavorites {

    String message() default "该用户已有同名收藏夹";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // 可定义字段名（需在验证器中动态获取）
    String memberIdStr() default "memberId";

    String favoritesNameStr() default "favoritesName";

    class Validator implements ConstraintValidator<MemberUniqueFavorites, RequestParam<?>> {
        private String memberIdStr;
        private String favoritesNameStr;

        @Override
        public void initialize(MemberUniqueFavorites constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
            memberIdStr = constraintAnnotation.memberIdStr();
            favoritesNameStr = constraintAnnotation.favoritesNameStr();
        }

        @Override
        public boolean isValid(RequestParam request, ConstraintValidatorContext context) {
            try {
                // 反射获取字段值
                Field memberIdField = request.getClass().getDeclaredField(memberIdStr);
                Field favoritesNameField = request.getClass().getDeclaredField(this.favoritesNameStr);

                memberIdField.setAccessible(true);
                favoritesNameField.setAccessible(true);

                Object memberId = memberIdField.get(request);
                Object favoritesName = favoritesNameField.get(request);

                return Mediator.repositories()
                        .findOne(JpaPredicate.byId(Member.class, memberId))
                        .orElseThrow(() -> new IllegalArgumentException("用户不存在"))
                        .getFavorites().stream()
                        .noneMatch(favorites -> Objects.equals(favorites.getName(), favoritesName));
            } catch (Exception e) {
                throw new RuntimeException("反射获取字段失败", e);
            }
        }
    }
}
