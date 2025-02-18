package com.only4.domain.aggregates.article.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.article.ArticleCommentReply;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文章评论回复
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2025/02/18
 */
@RequiredArgsConstructor
public class ArticleCommentReplySchema {
    /**
     * 属性字段集合
     */
    public static class PROPERTY_NAMES {

        /**
         * ID
         */
        public static final String id = "id";

        /**
         * 回复用户ID
         */
        public static final String authorId = "authorId";

        /**
         * 回复用户名
         */
        public static final String authorName = "authorName";

        /**
         * 回复内容
         */
        public static final String content = "content";

        /**
         * 回复时间
         */
        public static final String createAt = "createAt";

        /**
         * 逻辑删除
         */
        public static final String delFlag = "delFlag";

    }

    private final Path<ArticleCommentReply> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder _criteriaBuilder() {
        return criteriaBuilder;
    }

    public Path<ArticleCommentReply> _root() {
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
     * 回复用户ID
     * bigint
     */
    public Schema.Field<Long> authorId() {
        return new Schema.Field<>(root.get("authorId"), this.criteriaBuilder);
    }

    /**
     * 回复用户名
     * varchar(50)
     */
    public Schema.Field<String> authorName() {
        return new Schema.Field<>(root.get("authorName"), this.criteriaBuilder);
    }

    /**
     * 回复内容
     * varchar(255)
     */
    public Schema.Field<String> content() {
        return new Schema.Field<>(root.get("content"), this.criteriaBuilder);
    }

    /**
     * 回复时间
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
    public Predicate spec(Schema.PredicateBuilder<ArticleCommentReplySchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     *
     * @param builder where条件构造器
     * @return
     */
    public static Specification<ArticleCommentReply> specify(Schema.PredicateBuilder<ArticleCommentReplySchema> builder) {
        return specify(builder, false, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder  where条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static Specification<ArticleCommentReply> specify(Schema.PredicateBuilder<ArticleCommentReplySchema> builder, boolean distinct) {
        return specify(builder, distinct, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<ArticleCommentReply> specify(Schema.PredicateBuilder<ArticleCommentReplySchema> builder, Schema.OrderBuilder<ArticleCommentReplySchema>... orderBuilders) {
        return specify(builder, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<ArticleCommentReply> specify(Schema.PredicateBuilder<ArticleCommentReplySchema> builder, List<Schema.OrderBuilder<ArticleCommentReplySchema>> orderBuilders) {
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
    public static Specification<ArticleCommentReply> specify(Schema.PredicateBuilder<ArticleCommentReplySchema> builder, boolean distinct, Schema.OrderBuilder<ArticleCommentReplySchema>... orderBuilders) {
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
    public static Specification<ArticleCommentReply> specify(Schema.PredicateBuilder<ArticleCommentReplySchema> builder, boolean distinct, List<Schema.OrderBuilder<ArticleCommentReplySchema>> orderBuilders) {
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
    public static Specification<ArticleCommentReply> specify(Schema.Specification<ArticleCommentReply, ArticleCommentReplySchema> specifier) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            ArticleCommentReplySchema articleCommentReply = new ArticleCommentReplySchema(root, criteriaBuilder);
            return specifier.toPredicate(articleCommentReply, criteriaQuery);
        };
    }

}
