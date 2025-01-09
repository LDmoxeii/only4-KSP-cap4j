package com.only4.domain.aggregates.star.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.star.Star;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 星球
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2025/01/09
 */
@RequiredArgsConstructor
public class StarSchema {
    /**
     * 属性字段集合
     */
    public static class PROPERTY_NAMES {
        
        /**
         * ID
         */
        public static final String id = "id";

        /**
         * 星主ID
         */
        public static final String memberId = "memberId";

        /**
         * 星球名
         */
        public static final String name = "name";

        /**
         * 星球描述
         */
        public static final String description = "description";

        /**
         * 星球价格
         */
        public static final String amount = "amount";

        /**
         * 逻辑删除
         */
        public static final String delFlag = "delFlag";

    }

    private final Path<Star> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder _criteriaBuilder() {
        return criteriaBuilder;
    }

    public Path<Star> _root() {
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
     * 星主ID
     * bigint
     */
    public Schema.Field<Long> memberId() {
        return new Schema.Field<>(root.get("memberId"), this.criteriaBuilder);
    }

    /**
     * 星球名
     * varchar(50)
     */
    public Schema.Field<String> name() {
        return new Schema.Field<>(root.get("name"), this.criteriaBuilder);
    }

    /**
     * 星球描述
     * varchar(255)
     */
    public Schema.Field<String> description() {
        return new Schema.Field<>(root.get("description"), this.criteriaBuilder);
    }

    /**
     * 星球价格
     * int
     */
    public Schema.Field<Integer> amount() {
        return new Schema.Field<>(root.get("amount"), this.criteriaBuilder);
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
    public Predicate spec(Schema.PredicateBuilder<StarSchema> builder){
        return builder.build(this);
    }

    /**
     * Stardust 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.star.meta.StardustSchema joinStardust(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Star, com.only4.domain.aggregates.star.Stardust> join = ((Root<Star>) this.root).join("stardusts", type);
        com.only4.domain.aggregates.star.meta.StardustSchema schema = new com.only4.domain.aggregates.star.meta.StardustSchema(join, this.criteriaBuilder);
        return schema;
    }
    /**
     * StarComment 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.star.meta.StarCommentSchema joinStarComment(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Star, com.only4.domain.aggregates.star.StarComment> join = ((Root<Star>) this.root).join("starComments", type);
        com.only4.domain.aggregates.star.meta.StarCommentSchema schema = new com.only4.domain.aggregates.star.meta.StarCommentSchema(join, this.criteriaBuilder);
        return schema;
    }
    /**
     * StarLike 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.star.meta.StarLikeSchema joinStarLike(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Star, com.only4.domain.aggregates.star.StarLike> join = ((Root<Star>) this.root).join("starLikes", type);
        com.only4.domain.aggregates.star.meta.StarLikeSchema schema = new com.only4.domain.aggregates.star.meta.StarLikeSchema(join, this.criteriaBuilder);
        return schema;
    }
    /**
     * StarStatistice 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.star.meta.StarStatisticeSchema joinStarStatistice(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Star, com.only4.domain.aggregates.star.StarStatistice> join = ((Root<Star>) this.root).join("starStatistices", type);
        com.only4.domain.aggregates.star.meta.StarStatisticeSchema schema = new com.only4.domain.aggregates.star.meta.StarStatisticeSchema(join, this.criteriaBuilder);
        return schema;
    }

    /**
     * 构建查询条件
     *
     * @param builder where条件构造器
     * @return
     */
    public static Specification<Star> specify(Schema.PredicateBuilder<StarSchema> builder) {
        return specify(builder, false, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder  where条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static Specification<Star> specify(Schema.PredicateBuilder<StarSchema> builder, boolean distinct) {
        return specify(builder, distinct, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<Star> specify(Schema.PredicateBuilder<StarSchema> builder, Schema.OrderBuilder<StarSchema>... orderBuilders) {
        return specify(builder, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<Star> specify(Schema.PredicateBuilder<StarSchema> builder, List<Schema.OrderBuilder<StarSchema>> orderBuilders) {
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
    public static Specification<Star> specify(Schema.PredicateBuilder<StarSchema> builder, boolean distinct, Schema.OrderBuilder<StarSchema>... orderBuilders) {
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
    public static Specification<Star> specify(Schema.PredicateBuilder<StarSchema> builder, boolean distinct, List<Schema.OrderBuilder<StarSchema>> orderBuilders) {
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
    public static Specification<Star> specify(Schema.Specification<Star, StarSchema> specifier) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            StarSchema star = new StarSchema(root, criteriaBuilder);
            return specifier.toPredicate(star, criteriaQuery);
        };
    }

    /**
     * 构建查询条件
     *
     * @param id 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Star> predicateById(Object id) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byId(Star.class, id);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Star> predicateByIds(Collection<Object> ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(Star.class, ids);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Star> predicateByIds(Object... ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(Star.class, Arrays.asList(ids));
    }

    /**
     * 构建查询条件
     *
     * @param builder 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Star> predicate(Schema.PredicateBuilder<StarSchema> builder) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Star.class, specify(builder));
    }

    /**
     * 构建查询条件
     *
     * @param builder  查询条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Star> predicate(Schema.PredicateBuilder<StarSchema> builder, boolean distinct) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Star.class, specify(builder, distinct));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Star> predicate(Schema.PredicateBuilder<StarSchema> builder, List<Schema.OrderBuilder<StarSchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Star.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Star> predicate(Schema.PredicateBuilder<StarSchema> builder, Schema.OrderBuilder<StarSchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Star.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Star> predicate(Schema.PredicateBuilder<StarSchema> builder, boolean distinct, List<Schema.OrderBuilder<StarSchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Star.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Star> predicate(Schema.PredicateBuilder<StarSchema> builder, boolean distinct, Schema.OrderBuilder<StarSchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Star.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param specifier 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Star> predicate(Schema.Specification<Star, StarSchema> specifier) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Star.class, specify(specifier));
    }
}
