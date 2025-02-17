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
@Constraint(validatedBy = MemberFollowed.Validator.class)
public @interface MemberFollowed {

    String message() default "用户间未建立关注关系";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // 可定义字段名（需在验证器中动态获取）
    String memberIdStr() default "memberId";

    String otherIdStr() default "otherId";

    class Validator implements ConstraintValidator<MemberFollowed, RequestParam<?>> {
        private String memberIdStr;
        private String otherIdStr;

        @Override
        public void initialize(MemberFollowed constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
            memberIdStr = constraintAnnotation.memberIdStr();
            otherIdStr = constraintAnnotation.otherIdStr();
        }

        @Override
        public boolean isValid(RequestParam request, ConstraintValidatorContext context) {
            try {
                // 反射获取字段值
                Field memberIdField = request.getClass().getDeclaredField(memberIdStr);
                Field otherIdField = request.getClass().getDeclaredField(this.otherIdStr);

                memberIdField.setAccessible(true);
                otherIdField.setAccessible(true);

                Object memberId = memberIdField.get(request);
                Object otherId = otherIdField.get(request);

                return Mediator.repositories()
                        .findOne(JpaPredicate.byId(Member.class, memberId))
                        .orElseThrow(() -> new IllegalArgumentException("用户不存在"))
                        .getFollowMembers().stream()
                        .anyMatch(followMember -> Objects.equals(followMember.getId(), otherId));
            } catch (Exception e) {
                throw new RuntimeException("反射获取字段失败", e);
            }
        }
    }
}
