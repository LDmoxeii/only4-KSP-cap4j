package com.only4.domain.aggregates.star_comment_like.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.star_comment_like.StarCommentLike;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 星球评论点赞
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
@RequiredArgsConstructor
public class StarCommentLikeSchema {
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
         * 星球ID
         */
        public static final String starId = "starId";

        /**
         * 星尘ID
         */
        public static final String stardustId = "stardustId";

        /**
         * 点赞时间
         */
        public static final String createAt = "createAt";

        /**
         * 逻辑删除
         */
        public static final String delFlag = "delFlag";

    }

    private final Path<StarCommentLike> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder _criteriaBuilder() {
        return criteriaBuilder;
    }

    public Path<StarCommentLike> _root() {
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
     * 星球ID
     * bigint
     */
    public Schema.Field<Long> starId() {
        return new Schema.Field<>(root.get("starId"), this.criteriaBuilder);
    }

    /**
     * 星尘ID
     * bigint
     */
    public Schema.Field<Long> stardustId() {
        return new Schema.Field<>(root.get("stardustId"), this.criteriaBuilder);
    }

    /**
     * 点赞时间
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
    public Predicate spec(Schema.PredicateBuilder<StarCommentLikeSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     *
     * @param builder where条件构造器
     * @return
     */
    public static Specification<StarCommentLike> specify(Schema.PredicateBuilder<StarCommentLikeSchema> builder) {
        return specify(builder, false, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder  where条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static Specification<StarCommentLike> specify(Schema.PredicateBuilder<StarCommentLikeSchema> builder, boolean distinct) {
        return specify(builder, distinct, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<StarCommentLike> specify(Schema.PredicateBuilder<StarCommentLikeSchema> builder, Schema.OrderBuilder<StarCommentLikeSchema>... orderBuilders) {
        return specify(builder, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<StarCommentLike> specify(Schema.PredicateBuilder<StarCommentLikeSchema> builder, List<Schema.OrderBuilder<StarCommentLikeSchema>> orderBuilders) {
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
    public static Specification<StarCommentLike> specify(Schema.PredicateBuilder<StarCommentLikeSchema> builder, boolean distinct, Schema.OrderBuilder<StarCommentLikeSchema>... orderBuilders) {
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
    public static Specification<StarCommentLike> specify(Schema.PredicateBuilder<StarCommentLikeSchema> builder, boolean distinct, List<Schema.OrderBuilder<StarCommentLikeSchema>> orderBuilders) {
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
    public static Specification<StarCommentLike> specify(Schema.Specification<StarCommentLike, StarCommentLikeSchema> specifier) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            StarCommentLikeSchema starCommentLike = new StarCommentLikeSchema(root, criteriaBuilder);
            return specifier.toPredicate(starCommentLike, criteriaQuery);
        };
    }

    /**
     * 构建查询条件
     *
     * @param id 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentLike> predicateById(Object id) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byId(StarCommentLike.class, id);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentLike> predicateByIds(Collection<Object> ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(StarCommentLike.class, ids);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentLike> predicateByIds(Object... ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(StarCommentLike.class, Arrays.asList(ids));
    }

    /**
     * 构建查询条件
     *
     * @param builder 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentLike> predicate(Schema.PredicateBuilder<StarCommentLikeSchema> builder) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarCommentLike.class, specify(builder));
    }

    /**
     * 构建查询条件
     *
     * @param builder  查询条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentLike> predicate(Schema.PredicateBuilder<StarCommentLikeSchema> builder, boolean distinct) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarCommentLike.class, specify(builder, distinct));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentLike> predicate(Schema.PredicateBuilder<StarCommentLikeSchema> builder, List<Schema.OrderBuilder<StarCommentLikeSchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarCommentLike.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentLike> predicate(Schema.PredicateBuilder<StarCommentLikeSchema> builder, Schema.OrderBuilder<StarCommentLikeSchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarCommentLike.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentLike> predicate(Schema.PredicateBuilder<StarCommentLikeSchema> builder, boolean distinct, List<Schema.OrderBuilder<StarCommentLikeSchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarCommentLike.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentLike> predicate(Schema.PredicateBuilder<StarCommentLikeSchema> builder, boolean distinct, Schema.OrderBuilder<StarCommentLikeSchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarCommentLike.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param specifier 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<StarCommentLike> predicate(Schema.Specification<StarCommentLike, StarCommentLikeSchema> specifier) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(StarCommentLike.class, specify(specifier));
    }
}
