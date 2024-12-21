package com.only4.domain.aggregates.article.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.article.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 文章
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
@RequiredArgsConstructor
public class ArticleSchema {
    private final Path<Article> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder criteriaBuilder() {
        return criteriaBuilder;
    }

    /**
     * ID
     * bigint
     */
    public Schema.Field<Long> id() {
        return root == null ? new Schema.Field<>("id") : new Schema.Field<>(root.get("id"));
    }

    /**
     * 标题
     * varchar(255)
     */
    public Schema.Field<String> title() {
        return root == null ? new Schema.Field<>("title") : new Schema.Field<>(root.get("title"));
    }

    /**
     * 描述
     * varchar(255)
     */
    public Schema.Field<String> description() {
        return root == null ? new Schema.Field<>("description") : new Schema.Field<>(root.get("description"));
    }

    /**
     * 内容
     * varchar(255)
     */
    public Schema.Field<String> content() {
        return root == null ? new Schema.Field<>("content") : new Schema.Field<>(root.get("content"));
    }

    /**
     * 文章封面
     * varchar(255)
     */
    public Schema.Field<String> cover() {
        return root == null ? new Schema.Field<>("cover") : new Schema.Field<>(root.get("cover"));
    }

    /**
     * 文章附件
     * int
     */
    public Schema.Field<Integer> appendix() {
        return root == null ? new Schema.Field<>("appendix") : new Schema.Field<>(root.get("appendix"));
    }

    /**
     * 文章状态
     * 0:PRIVATE:PRIVATE
     * 1:PUBLISH:PUBLISH
     * 2:BANNED:BANNED
     * int
     */
    public Schema.Field<com.only4.domain.aggregates.article.enums.ArticleState> state() {
        return root == null ? new Schema.Field<>("state") : new Schema.Field<>(root.get("state"));
    }

    /**
     * 置顶标识
     * tinyint(1)
     */
    public Schema.Field<Boolean> stickyFlag() {
        return root == null ? new Schema.Field<>("stickyFlag") : new Schema.Field<>(root.get("stickyFlag"));
    }

    /**
     * 评论功能标识
     * tinyint(1)
     */
    public Schema.Field<Boolean> commentFlag() {
        return root == null ? new Schema.Field<>("commentFlag") : new Schema.Field<>(root.get("commentFlag"));
    }

    /**
     * 逻辑删除
     * tinyint(1)
     */
    public Schema.Field<Boolean> delFlag() {
        return root == null ? new Schema.Field<>("delFlag") : new Schema.Field<>(root.get("delFlag"));
    }


    /**
     * 满足所有条件
     * @param restrictions
     * @return
     */
    public Predicate all(Predicate... restrictions) {
        return criteriaBuilder().and(restrictions);
    }

    /**
     * 满足任一条件
     * @param restrictions
     * @return
     */
    public Predicate any(Predicate... restrictions) {
        return criteriaBuilder().or(restrictions);
    }

    /**
     * 指定条件
     * @param builder
     * @return
     */
    public Predicate spec(Schema.PredicateBuilder<ArticleSchema> builder){
        return builder.build(this);
    }

    /**
     * ArticleCategory 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.article.meta.ArticleCategorySchema joinArticleCategory(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Article, com.only4.domain.aggregates.article.ArticleCategory> join = ((Root<Article>) root).join("articleCategories", type);
        com.only4.domain.aggregates.article.meta.ArticleCategorySchema schema = new com.only4.domain.aggregates.article.meta.ArticleCategorySchema(join, criteriaBuilder);
        return schema;
    }
    /**
     * ArticleAuthor 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.article.meta.ArticleAuthorSchema joinArticleAuthor(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Article, com.only4.domain.aggregates.article.ArticleAuthor> join = ((Root<Article>) root).join("articleAuthors", type);
        com.only4.domain.aggregates.article.meta.ArticleAuthorSchema schema = new com.only4.domain.aggregates.article.meta.ArticleAuthorSchema(join, criteriaBuilder);
        return schema;
    }
    /**
     * ArticleComment 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.article.meta.ArticleCommentSchema joinArticleComment(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Article, com.only4.domain.aggregates.article.ArticleComment> join = ((Root<Article>) root).join("articleComments", type);
        com.only4.domain.aggregates.article.meta.ArticleCommentSchema schema = new com.only4.domain.aggregates.article.meta.ArticleCommentSchema(join, criteriaBuilder);
        return schema;
    }
    /**
     * ArticleStatistics 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.article.meta.ArticleStatisticsSchema joinArticleStatistics(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Article, com.only4.domain.aggregates.article.ArticleStatistics> join = ((Root<Article>) root).join("articleStatistics", type);
        com.only4.domain.aggregates.article.meta.ArticleStatisticsSchema schema = new com.only4.domain.aggregates.article.meta.ArticleStatisticsSchema(join, criteriaBuilder);
        return schema;
    }
    /**
     * ArticleTag 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.article.meta.ArticleTagSchema joinArticleTag(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Article, com.only4.domain.aggregates.article.ArticleTag> join = ((Root<Article>) root).join("articleTags", type);
        com.only4.domain.aggregates.article.meta.ArticleTagSchema schema = new com.only4.domain.aggregates.article.meta.ArticleTagSchema(join, criteriaBuilder);
        return schema;
    }
    /**
     * ArticleLike 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.article.meta.ArticleLikeSchema joinArticleLike(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Article, com.only4.domain.aggregates.article.ArticleLike> join = ((Root<Article>) root).join("articleLikes", type);
        com.only4.domain.aggregates.article.meta.ArticleLikeSchema schema = new com.only4.domain.aggregates.article.meta.ArticleLikeSchema(join, criteriaBuilder);
        return schema;
    }

    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<Article> specify(Schema.PredicateBuilder<ArticleSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            ArticleSchema article = new ArticleSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(article));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }
    
    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<Article> specify(Schema.PredicateBuilder<ArticleSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            ArticleSchema article = new ArticleSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(article));
            return null;
        };
    }
    
    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<ArticleSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<ArticleSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new ArticleSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
