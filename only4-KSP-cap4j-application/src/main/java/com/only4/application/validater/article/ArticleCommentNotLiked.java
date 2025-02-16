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
@Constraint(validatedBy = ArticleCommentNotLiked.Validator.class)
public @interface ArticleCommentNotLiked {

    String message() default "已点过赞";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // 可定义字段名（需在验证器中动态获取）
    String articleIdStr() default "articleId";

    String commentIdStr() default "commentId";

    String memberIdStr() default "memberId";


    class Validator implements ConstraintValidator<ArticleCommentNotLiked, RequestParam<?>> {
        private String articleIdStr;
        private String memberIdStr;
        private String commentId;
        public void initialize(ArticleCommentNotLiked constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
            articleIdStr = constraintAnnotation.articleIdStr();
            memberIdStr = constraintAnnotation.memberIdStr();
            commentId = constraintAnnotation.commentIdStr();
        }
        @Override
        public boolean isValid(RequestParam<?> request, ConstraintValidatorContext context) {
            try {
                // 反射获取字段值
                Field articleField = request.getClass().getDeclaredField(articleIdStr);
                Field memberIdField = request.getClass().getDeclaredField(memberIdStr);
                Field commentIdField = request.getClass().getDeclaredField(commentId);
                articleField.setAccessible(true);
                memberIdField.setAccessible(true);
                commentIdField.setAccessible(true);

                Object articleId = articleField.get(request);
                Object memberId = memberIdField.get(request);
                Object commentId = commentIdField.get(request);

                return Mediator.repositories()
                        .findOne(JpaPredicate.byId(Article.class, articleId))
                        .orElseThrow(() -> new IllegalArgumentException("文章不存在"))
                        .getArticleComments().stream()
                        .filter(articleComment -> Objects.equals(articleComment.getId(), commentId))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("评论不存在"))
                        .getArticleCommentLikes().stream()
                        .noneMatch(articleCommentLike -> Objects.equals(articleCommentLike.getMemberId(), memberId));
            } catch (Exception e) {
                throw new RuntimeException("反射获取字段失败", e);
            }
        }
    }
}
