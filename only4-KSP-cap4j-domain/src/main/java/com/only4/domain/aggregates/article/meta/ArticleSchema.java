package com.only4.domain.aggregates.article.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.article.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文章
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2025/02/21
 */
@RequiredArgsConstructor
public class ArticleSchema {
    /**
     * 属性字段集合
     */
    public static class PROPERTY_NAMES {
        
        /**
         * ID
         */
        public static final String id = "id";

        /**
         * 标题
         */
        public static final String title = "title";

        /**
         * 描述
         */
        public static final String description = "description";

        /**
         * 内容
         */
        public static final String content = "content";

        /**
         * 文章封面
         */
        public static final String cover = "cover";

        /**
         * 文章附件
         */
        public static final String appendix = "appendix";

        /**
         * 文章价格
         */
        public static final String price = "price";

        /**
         * 文章状态
         */
        public static final String visibility = "visibility";

        /**
         * 置顶标识
         */
        public static final String stickyFlag = "stickyFlag";

        /**
         * 评论功能标识
         */
        public static final String commentFlag = "commentFlag";

        /**
         * 封禁时间
         */
        public static final String bannedAt = "bannedAt";

        /**
         * 封禁时间
         */
        public static final String banDuration = "banDuration";

        /**
         * 逻辑删除
         */
        public static final String delFlag = "delFlag";

    }

    private final Path<Article> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder _criteriaBuilder() {
        return criteriaBuilder;
    }

    public Path<Article> _root() {
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
     * 标题
     * varchar(255)
     */
    public Schema.Field<String> title() {
        return new Schema.Field<>(root.get("title"), this.criteriaBuilder);
    }

    /**
     * 描述
     * varchar(255)
     */
    public Schema.Field<String> description() {
        return new Schema.Field<>(root.get("description"), this.criteriaBuilder);
    }

    /**
     * 内容
     * varchar(255)
     */
    public Schema.Field<String> content() {
        return new Schema.Field<>(root.get("content"), this.criteriaBuilder);
    }

    /**
     * 文章封面
     * varchar(255)
     */
    public Schema.Field<String> cover() {
        return new Schema.Field<>(root.get("cover"), this.criteriaBuilder);
    }

    /**
     * 文章附件
     * varchar(255)
     */
    public Schema.Field<String> appendix() {
        return new Schema.Field<>(root.get("appendix"), this.criteriaBuilder);
    }

    /**
     * 文章价格
     * bigint
     */
    public Schema.Field<Long> price() {
        return new Schema.Field<>(root.get("price"), this.criteriaBuilder);
    }

    /**
     * 文章状态
     * 0:PRIVATE:PRIVATE
     * 1:PUBLISH:PUBLISH
     * 2:BANNED:BANNED
     * tinyint
     */
    public Schema.Field<com.only4.domain.aggregates.article.enums.ArticleVisibility> visibility() {
        return new Schema.Field<>(root.get("visibility"), this.criteriaBuilder);
    }

    /**
     * 置顶标识
     * tinyint(1)
     */
    public Schema.Field<Boolean> stickyFlag() {
        return new Schema.Field<>(root.get("stickyFlag"), this.criteriaBuilder);
    }

    /**
     * 评论功能标识
     * tinyint(1)
     */
    public Schema.Field<Boolean> commentFlag() {
        return new Schema.Field<>(root.get("commentFlag"), this.criteriaBuilder);
    }

    /**
     * 封禁时间
     * timestamp
     */
    public Schema.Field<java.time.LocalDateTime> bannedAt() {
        return new Schema.Field<>(root.get("bannedAt"), this.criteriaBuilder);
    }

    /**
     * 封禁时间
     * int
     */
    public Schema.Field<Integer> banDuration() {
        return new Schema.Field<>(root.get("banDuration"), this.criteriaBuilder);
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
        Join<Article, com.only4.domain.aggregates.article.ArticleCategory> join = ((Root<Article>) this.root).join("articleCategories", type);
        com.only4.domain.aggregates.article.meta.ArticleCategorySchema schema = new com.only4.domain.aggregates.article.meta.ArticleCategorySchema(join, this.criteriaBuilder);
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
        Join<Article, com.only4.domain.aggregates.article.ArticleAuthor> join = ((Root<Article>) this.root).join("articleAuthors", type);
        com.only4.domain.aggregates.article.meta.ArticleAuthorSchema schema = new com.only4.domain.aggregates.article.meta.ArticleAuthorSchema(join, this.criteriaBuilder);
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
        Join<Article, com.only4.domain.aggregates.article.ArticleStatistics> join = ((Root<Article>) this.root).join("articleStatistics", type);
        com.only4.domain.aggregates.article.meta.ArticleStatisticsSchema schema = new com.only4.domain.aggregates.article.meta.ArticleStatisticsSchema(join, this.criteriaBuilder);
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
        Join<Article, com.only4.domain.aggregates.article.ArticleTag> join = ((Root<Article>) this.root).join("articleTags", type);
        com.only4.domain.aggregates.article.meta.ArticleTagSchema schema = new com.only4.domain.aggregates.article.meta.ArticleTagSchema(join, this.criteriaBuilder);
        return schema;
    }

    /**
     * 构建查询条件
     *
     * @param builder where条件构造器
     * @return
     */
    public static Specification<Article> specify(Schema.PredicateBuilder<ArticleSchema> builder) {
        return specify(builder, false, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder  where条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static Specification<Article> specify(Schema.PredicateBuilder<ArticleSchema> builder, boolean distinct) {
        return specify(builder, distinct, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<Article> specify(Schema.PredicateBuilder<ArticleSchema> builder, Schema.OrderBuilder<ArticleSchema>... orderBuilders) {
        return specify(builder, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<Article> specify(Schema.PredicateBuilder<ArticleSchema> builder, List<Schema.OrderBuilder<ArticleSchema>> orderBuilders) {
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
    public static Specification<Article> specify(Schema.PredicateBuilder<ArticleSchema> builder, boolean distinct, Schema.OrderBuilder<ArticleSchema>... orderBuilders) {
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
    public static Specification<Article> specify(Schema.PredicateBuilder<ArticleSchema> builder, boolean distinct, List<Schema.OrderBuilder<ArticleSchema>> orderBuilders) {
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
    public static Specification<Article> specify(Schema.Specification<Article, ArticleSchema> specifier) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            ArticleSchema article = new ArticleSchema(root, criteriaBuilder);
            return specifier.toPredicate(article, criteriaQuery);
        };
    }

    /**
     * 构建查询条件
     *
     * @param id 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Article> predicateById(Object id) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byId(Article.class, id);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Article> predicateByIds(Collection<Object> ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(Article.class, ids);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Article> predicateByIds(Object... ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(Article.class, Arrays.asList(ids));
    }

    /**
     * 构建查询条件
     *
     * @param builder 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Article> predicate(Schema.PredicateBuilder<ArticleSchema> builder) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Article.class, specify(builder));
    }

    /**
     * 构建查询条件
     *
     * @param builder  查询条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Article> predicate(Schema.PredicateBuilder<ArticleSchema> builder, boolean distinct) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Article.class, specify(builder, distinct));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Article> predicate(Schema.PredicateBuilder<ArticleSchema> builder, List<Schema.OrderBuilder<ArticleSchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Article.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Article> predicate(Schema.PredicateBuilder<ArticleSchema> builder, Schema.OrderBuilder<ArticleSchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Article.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Article> predicate(Schema.PredicateBuilder<ArticleSchema> builder, boolean distinct, List<Schema.OrderBuilder<ArticleSchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Article.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Article> predicate(Schema.PredicateBuilder<ArticleSchema> builder, boolean distinct, Schema.OrderBuilder<ArticleSchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Article.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param specifier 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Article> predicate(Schema.Specification<Article, ArticleSchema> specifier) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Article.class, specify(specifier));
    }
}
