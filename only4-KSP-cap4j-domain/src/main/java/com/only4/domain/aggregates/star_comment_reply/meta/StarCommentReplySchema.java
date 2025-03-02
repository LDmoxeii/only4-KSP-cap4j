package com.only4.domain.aggregates.star_comment_reply.meta;

import jakarta.persistence.criteria.*;
import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.star_comment_reply.StarCommentReply;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 星球评论回复
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2025/02/24
 */
@RequiredArgsConstructor
public class StarCommentReplySchema {
    /**
     * 属性字段集合
     */
    public static class PROPERTY_NAMES {
        
        /**
         * ID
         */
        public static final String id = "id";

        /**
         * 星球评论ID
         */
        public static final String starCommentId = "starCommentId";

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
         * 创建时间
         */
        public static final String createAt = "createAt";

        /**
         * 逻辑删除
         */
        public static final String delFlag = "delFlag";

    }

    private final Path<StarCommentReply> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder _criteriaBuilder() {
        return criteriaBuilder;
    }

    public Path<StarCommentReply> _root() {
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
     * 星球评论ID
     * bigint
     */
    public Schema.Field<Long> starCommentId() {
        return new Schema.Field<>(root.get("starCommentId"), this.criteriaBuilder);
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
     * 创建时间
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
    public Predicate spec(Schema.PredicateBuilder<StarCommentReplySchema> builder){
        return builder.build(this);
    }

    /**
     * StarCommentReplyStatistics 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.star_comment_reply.meta.StarCommentReplyStatisticsSchema joinStarCommentReplyStatistics(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<StarCommentReply, com.only4.domain.aggregates.star_comment_reply.StarCommentReplyStatistics> join = ((Root<StarCommentReply>) this.root).join("starCommentReplyStatistics", type);
        com.only4.domain.aggregates.star_comment_reply.meta.StarCommentReplyStatisticsSchema schema = new com.only4.domain.aggregates.star_comment_reply.meta.StarCommentReplyStatisticsSchema(join, this.criteriaBuilder);
        return schema;
    }

    /**
     * 构建查询条件
     *
     * @param builder where条件构造器
     * @return
     */
    public static Specification<StarCommentReply> specify(Schema.PredicateBuilder<StarCommentReplySchema> builder) {
        return specify(builder, false, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder  where条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static Specification<StarCommentReply> specify(Schema.PredicateBuilder<StarCommentReplySchema> builder, boolean distinct) {
        return specify(builder, distinct, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<StarCommentReply> specify(Schema.PredicateBuilder<StarCommentReplySchema> builder, Schema.OrderBuilder<StarCommentReplySchema>... orderBuilders) {
        return specify(builder, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<StarCommentReply> specify(Schema.PredicateBuilder<StarCommentReplySchema> builder, List<Schema.OrderBuilder<StarCommentReplySchema>> orderBuilders) {
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
    public static Specification<StarCommentReply> specify(Schema.PredicateBuilder<StarCommentReplySchema> builder, boolean distinct, Schema.OrderBuilder<StarCommentReplySchema>... orderBuilders) {
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
    public static Specification<StarCommentReply> specify(Schema.PredicateBuilder<StarCommentReplySchema> builder, boolean distinct, List<Schema.OrderBuilder<StarCommentReplySchema>> orderBuilders) {
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
    public static Specification<StarCommentReply> specify(Schema.Specification<StarCommentReply, StarCommentReplySchema> specifier) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            StarCommentReplySchema starCommentReply = new StarCommentReplySchema(root, criteriaBuilder);
            return specifier.toPredicate(starCommentReply, criteriaQuery);
        };
    }

    /**
     * 构建查询条件
     *
     * @param id 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentReply> predicateById(Object id) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byId(StarCommentReply.class, id);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentReply> predicateByIds(Collection<Object> ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(StarCommentReply.class, ids);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentReply> predicateByIds(Object... ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(StarCommentReply.class, Arrays.asList(ids));
    }

    /**
     * 构建查询条件
     *
     * @param builder 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentReply> predicate(Schema.PredicateBuilder<StarCommentReplySchema> builder) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarCommentReply.class, specify(builder));
    }

    /**
     * 构建查询条件
     *
     * @param builder  查询条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentReply> predicate(Schema.PredicateBuilder<StarCommentReplySchema> builder, boolean distinct) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarCommentReply.class, specify(builder, distinct));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentReply> predicate(Schema.PredicateBuilder<StarCommentReplySchema> builder, List<Schema.OrderBuilder<StarCommentReplySchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarCommentReply.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentReply> predicate(Schema.PredicateBuilder<StarCommentReplySchema> builder, Schema.OrderBuilder<StarCommentReplySchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarCommentReply.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentReply> predicate(Schema.PredicateBuilder<StarCommentReplySchema> builder, boolean distinct, List<Schema.OrderBuilder<StarCommentReplySchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarCommentReply.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentReply> predicate(Schema.PredicateBuilder<StarCommentReplySchema> builder, boolean distinct, Schema.OrderBuilder<StarCommentReplySchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarCommentReply.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param specifier 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentReply> predicate(Schema.Specification<StarCommentReply, StarCommentReplySchema> specifier) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarCommentReply.class, specify(specifier));
    }
}
