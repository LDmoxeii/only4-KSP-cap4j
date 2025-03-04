package com.only4.domain.aggregates.article_comment.meta;

import jakarta.persistence.criteria.*;
import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.article_comment.ArticleComment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文章评论
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2025/03/03
 */
@RequiredArgsConstructor
public class ArticleCommentSchema {
    /**
     * 属性字段集合
     */
    public static class PROPERTY_NAMES {
        
        /**
         * ID
         */
        public static final String id = "id";

        /**
         * 文章ID
         */
        public static final String articleId = "articleId";

        /**
         * 作者ID
         */
        public static final String authorId = "authorId";

        /**
         * 作者名
         */
        public static final String authorName = "authorName";

        /**
         * 内容
         */
        public static final String content = "content";

        /**
         * 置顶标识
         */
        public static final String stickyFlag = "stickyFlag";

        /**
         * 评论时间
         */
        public static final String createAt = "createAt";

        /**
         * 逻辑删除
         */
        public static final String delFlag = "delFlag";

    }

    private final Path<ArticleComment> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder _criteriaBuilder() {
        return criteriaBuilder;
    }

    public Path<ArticleComment> _root() {
        return root;
    }

    /**
     * ID
     * bigint
     */
    public Schema.Field<Long> id() {
        return new Schema.Field<>(root.get("id"), this.criteriaBuilder);
    }

    /**
     * 文章ID
     * bigint
     */
    public Schema.Field<Long> articleId() {
        return new Schema.Field<>(root.get("articleId"), this.criteriaBuilder);
    }

    /**
     * 作者ID
     * bigint
     */
    public Schema.Field<Long> authorId() {
        return new Schema.Field<>(root.get("authorId"), this.criteriaBuilder);
    }

    /**
     * 作者名
     * varchar(50)
     */
    public Schema.Field<String> authorName() {
        return new Schema.Field<>(root.get("authorName"), this.criteriaBuilder);
    }

    /**
     * 内容
     * varchar(255)
     */
    public Schema.Field<String> content() {
        return new Schema.Field<>(root.get("content"), this.criteriaBuilder);
    }

    /**
     * 置顶标识
     * tinyint(1)
     */
    public Schema.Field<Boolean> stickyFlag() {
        return new Schema.Field<>(root.get("stickyFlag"), this.criteriaBuilder);
    }

    /**
     * 评论时间
     * timestamp
     */
    public Schema.Field<java.time.LocalDateTime> createAt() {
        return new Schema.Field<>(root.get("createAt"), this.criteriaBuilder);
    }

    /**
     * 逻辑删除
     * tinyint(1)
     */
    public Schema.Field<Boolean> delFlag() {
        return new Schema.Field<>(root.get("delFlag"), this.criteriaBuilder);
    }


    /**
     * 满足所有条件
     * @param restrictions
     * @return
     */
    public Predicate all(Predicate... restrictions) {
        return this.criteriaBuilder.and(restrictions);
    }

    /**
     * 满足任一条件
     * @param restrictions
     * @return
     */
    public Predicate any(Predicate... restrictions) {
        return this.criteriaBuilder.or(restrictions);
    }

    /**
     * 指定条件
     * @param builder
     * @return
     */
    public Predicate spec(Schema.PredicateBuilder<ArticleCommentSchema> builder){
        return builder.build(this);
    }

    /**
     * ArticleCommentStatistics 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.article_comment.meta.ArticleCommentStatisticsSchema joinArticleCommentStatistics(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<ArticleComment, com.only4.domain.aggregates.article_comment.ArticleCommentStatistics> join = ((Root<ArticleComment>) this.root).join("articleCommentStatistics", type);
        com.only4.domain.aggregates.article_comment.meta.ArticleCommentStatisticsSchema schema = new com.only4.domain.aggregates.article_comment.meta.ArticleCommentStatisticsSchema(join, this.criteriaBuilder);
        return schema;
    }

    /**
     * 构建查询条件
     *
     * @param builder where条件构造器
     * @return
     */
    public static Specification<ArticleComment> specify(Schema.PredicateBuilder<ArticleCommentSchema> builder) {
        return specify(builder, false, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder  where条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static Specification<ArticleComment> specify(Schema.PredicateBuilder<ArticleCommentSchema> builder, boolean distinct) {
        return specify(builder, distinct, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<ArticleComment> specify(Schema.PredicateBuilder<ArticleCommentSchema> builder, Schema.OrderBuilder<ArticleCommentSchema>... orderBuilders) {
        return specify(builder, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<ArticleComment> specify(Schema.PredicateBuilder<ArticleCommentSchema> builder, List<Schema.OrderBuilder<ArticleCommentSchema>> orderBuilders) {
        return specify(builder, orderBuilders);
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<ArticleComment> specify(Schema.PredicateBuilder<ArticleCommentSchema> builder, boolean distinct, Schema.OrderBuilder<ArticleCommentSchema>... orderBuilders) {
        return specify(builder, distinct, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<ArticleComment> specify(Schema.PredicateBuilder<ArticleCommentSchema> builder, boolean distinct, List<Schema.OrderBuilder<ArticleCommentSchema>> orderBuilders) {
        return specify((schema, criteriaQuery) -> {
            criteriaQuery.where(builder.build(schema));
            criteriaQuery.distinct(distinct);
            if (orderBuilders != null && !orderBuilders.isEmpty()) {
                criteriaQuery.orderBy(orderBuilders.stream()
                        .map(b -> b.build(schema))
                        .collect(Collectors.toList())
                );
            }
            return null;
        });
    }

    /**
     * 构建查询条件
     *
     * @param specifier 查询条件构造器
     * @return
     */
    public static Specification<ArticleComment> specify(Schema.Specification<ArticleComment, ArticleCommentSchema> specifier) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            ArticleCommentSchema articleComment = new ArticleCommentSchema(root, criteriaBuilder);
            return specifier.toPredicate(articleComment, criteriaQuery);
        };
    }

    /**
     * 构建查询条件
     *
     * @param id 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ArticleComment> predicateById(Object id) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byId(ArticleComment.class, id);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ArticleComment> predicateByIds(Collection<Object> ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(ArticleComment.class, ids);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ArticleComment> predicateByIds(Object... ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(ArticleComment.class, Arrays.asList(ids));
    }

    /**
     * 构建查询条件
     *
     * @param builder 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ArticleComment> predicate(Schema.PredicateBuilder<ArticleCommentSchema> builder) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(ArticleComment.class, specify(builder));
    }

    /**
     * 构建查询条件
     *
     * @param builder  查询条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ArticleComment> predicate(Schema.PredicateBuilder<ArticleCommentSchema> builder, boolean distinct) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(ArticleComment.class, specify(builder, distinct));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ArticleComment> predicate(Schema.PredicateBuilder<ArticleCommentSchema> builder, List<Schema.OrderBuilder<ArticleCommentSchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(ArticleComment.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ArticleComment> predicate(Schema.PredicateBuilder<ArticleCommentSchema> builder, Schema.OrderBuilder<ArticleCommentSchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(ArticleComment.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ArticleComment> predicate(Schema.PredicateBuilder<ArticleCommentSchema> builder, boolean distinct, List<Schema.OrderBuilder<ArticleCommentSchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(ArticleComment.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ArticleComment> predicate(Schema.PredicateBuilder<ArticleCommentSchema> builder, boolean distinct, Schema.OrderBuilder<ArticleCommentSchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(ArticleComment.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param specifier 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ArticleComment> predicate(Schema.Specification<ArticleComment, ArticleCommentSchema> specifier) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(ArticleComment.class, specify(specifier));
    }
}
