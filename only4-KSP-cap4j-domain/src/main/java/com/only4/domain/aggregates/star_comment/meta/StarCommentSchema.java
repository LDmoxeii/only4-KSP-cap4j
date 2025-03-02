package com.only4.domain.aggregates.star_comment.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.star_comment.StarComment;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 星球评论
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2025/02/23
 */
@RequiredArgsConstructor
public class StarCommentSchema {
    /**
     * 属性字段集合
     */
    public static class PROPERTY_NAMES {

        /**
         * ID
         */
        public static final String id = "id";

        /**
         * 星球ID
         */
        public static final String starId = "starId";

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
        public static final String pinFlag = "pinFlag";

        /**
         * 创建时间
         */
        public static final String createAt = "createAt";

        /**
         * 逻辑删除
         */
        public static final String delFlag = "delFlag";

    }

    private final Path<StarComment> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder _criteriaBuilder() {
        return criteriaBuilder;
    }

    public Path<StarComment> _root() {
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
     * 星球ID
     * bigint
     */
    public Schema.Field<Long> starId() {
        return new Schema.Field<>(root.get("starId"), this.criteriaBuilder);
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
    public Schema.Field<Boolean> pinFlag() {
        return new Schema.Field<>(root.get("pinFlag"), this.criteriaBuilder);
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
    public Predicate spec(Schema.PredicateBuilder<StarCommentSchema> builder){
        return builder.build(this);
    }

    /**
     * StarCommentStatistics 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.star_comment.meta.StarCommentStatisticsSchema joinStarCommentStatistics(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<StarComment, com.only4.domain.aggregates.star_comment.StarCommentStatistics> join = ((Root<StarComment>) this.root).join("starCommentStatistics", type);
        com.only4.domain.aggregates.star_comment.meta.StarCommentStatisticsSchema schema = new com.only4.domain.aggregates.star_comment.meta.StarCommentStatisticsSchema(join, this.criteriaBuilder);
        return schema;
    }

    /**
     * 构建查询条件
     *
     * @param builder where条件构造器
     * @return
     */
    public static Specification<StarComment> specify(Schema.PredicateBuilder<StarCommentSchema> builder) {
        return specify(builder, false, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder  where条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static Specification<StarComment> specify(Schema.PredicateBuilder<StarCommentSchema> builder, boolean distinct) {
        return specify(builder, distinct, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<StarComment> specify(Schema.PredicateBuilder<StarCommentSchema> builder, Schema.OrderBuilder<StarCommentSchema>... orderBuilders) {
        return specify(builder, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<StarComment> specify(Schema.PredicateBuilder<StarCommentSchema> builder, List<Schema.OrderBuilder<StarCommentSchema>> orderBuilders) {
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
    public static Specification<StarComment> specify(Schema.PredicateBuilder<StarCommentSchema> builder, boolean distinct, Schema.OrderBuilder<StarCommentSchema>... orderBuilders) {
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
    public static Specification<StarComment> specify(Schema.PredicateBuilder<StarCommentSchema> builder, boolean distinct, List<Schema.OrderBuilder<StarCommentSchema>> orderBuilders) {
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
    public static Specification<StarComment> specify(Schema.Specification<StarComment, StarCommentSchema> specifier) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            StarCommentSchema starComment = new StarCommentSchema(root, criteriaBuilder);
            return specifier.toPredicate(starComment, criteriaQuery);
        };
    }

    /**
     * 构建查询条件
     *
     * @param id 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarComment> predicateById(Object id) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byId(StarComment.class, id);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarComment> predicateByIds(Collection<Object> ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(StarComment.class, ids);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarComment> predicateByIds(Object... ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(StarComment.class, Arrays.asList(ids));
    }

    /**
     * 构建查询条件
     *
     * @param builder 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarComment> predicate(Schema.PredicateBuilder<StarCommentSchema> builder) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarComment.class, specify(builder));
    }

    /**
     * 构建查询条件
     *
     * @param builder  查询条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarComment> predicate(Schema.PredicateBuilder<StarCommentSchema> builder, boolean distinct) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarComment.class, specify(builder, distinct));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarComment> predicate(Schema.PredicateBuilder<StarCommentSchema> builder, List<Schema.OrderBuilder<StarCommentSchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarComment.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarComment> predicate(Schema.PredicateBuilder<StarCommentSchema> builder, Schema.OrderBuilder<StarCommentSchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarComment.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarComment> predicate(Schema.PredicateBuilder<StarCommentSchema> builder, boolean distinct, List<Schema.OrderBuilder<StarCommentSchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarComment.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarComment> predicate(Schema.PredicateBuilder<StarCommentSchema> builder, boolean distinct, Schema.OrderBuilder<StarCommentSchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarComment.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param specifier 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarComment> predicate(Schema.Specification<StarComment, StarCommentSchema> specifier) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarComment.class, specify(specifier));
    }
}
