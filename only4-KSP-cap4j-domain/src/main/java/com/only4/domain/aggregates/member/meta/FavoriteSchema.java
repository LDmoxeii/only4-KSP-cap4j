package com.only4.domain.aggregates.member.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.member.Favorite;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 会员收藏夹
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2025/02/17
 */
@RequiredArgsConstructor
public class FavoriteSchema {
    /**
     * 属性字段集合
     */
    public static class PROPERTY_NAMES {

        /**
         * ID
         */
        public static final String id = "id";

        /**
         * 收藏夹名
         */
        public static final String name = "name";

        /**
         * 描述
         */
        public static final String description = "description";

        /**
         * 逻辑删除
         */
        public static final String delFlag = "delFlag";

        /**
         * 默认标识
         */
        public static final String defaultFlag = "defaultFlag";

    }

    private final Path<Favorite> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder _criteriaBuilder() {
        return criteriaBuilder;
    }

    public Path<Favorite> _root() {
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
     * 收藏夹名
     * varchar(50)
     */
    public Schema.Field<String> name() {
        return new Schema.Field<>(root.get("name"), this.criteriaBuilder);
    }

    /**
     * 描述
     * varchar(255)
     */
    public Schema.Field<String> description() {
        return new Schema.Field<>(root.get("description"), this.criteriaBuilder);
    }

    /**
     * 逻辑删除
     * tinyint(1)
     */
    public Schema.Field<Boolean> delFlag() {
        return new Schema.Field<>(root.get("delFlag"), this.criteriaBuilder);
    }

    /**
     * 默认标识
     * tinyint(1)
     */
    public Schema.Field<Boolean> defaultFlag() {
        return new Schema.Field<>(root.get("defaultFlag"), this.criteriaBuilder);
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
    public Predicate spec(Schema.PredicateBuilder<FavoriteSchema> builder){
        return builder.build(this);
    }

    /**
     * ArticleFavoriteStatistics 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.member.meta.ArticleFavoriteStatisticsSchema joinArticleFavoriteStatistics(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Favorite, com.only4.domain.aggregates.member.ArticleFavoriteStatistics> join = ((Root<Favorite>) this.root).join("articleFavoriteStatistics", type);
        com.only4.domain.aggregates.member.meta.ArticleFavoriteStatisticsSchema schema = new com.only4.domain.aggregates.member.meta.ArticleFavoriteStatisticsSchema(join, this.criteriaBuilder);
        return schema;
    }
    /**
     * ArticleFavoriteRecord 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.member.meta.ArticleFavoriteRecordSchema joinArticleFavoriteRecord(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Favorite, com.only4.domain.aggregates.member.ArticleFavoriteRecord> join = ((Root<Favorite>) this.root).join("articleFavoriteRecords", type);
        com.only4.domain.aggregates.member.meta.ArticleFavoriteRecordSchema schema = new com.only4.domain.aggregates.member.meta.ArticleFavoriteRecordSchema(join, this.criteriaBuilder);
        return schema;
    }

    /**
     * 构建查询条件
     *
     * @param builder where条件构造器
     * @return
     */
    public static Specification<Favorite> specify(Schema.PredicateBuilder<FavoriteSchema> builder) {
        return specify(builder, false, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder  where条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static Specification<Favorite> specify(Schema.PredicateBuilder<FavoriteSchema> builder, boolean distinct) {
        return specify(builder, distinct, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<Favorite> specify(Schema.PredicateBuilder<FavoriteSchema> builder, Schema.OrderBuilder<FavoriteSchema>... orderBuilders) {
        return specify(builder, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<Favorite> specify(Schema.PredicateBuilder<FavoriteSchema> builder, List<Schema.OrderBuilder<FavoriteSchema>> orderBuilders) {
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
    public static Specification<Favorite> specify(Schema.PredicateBuilder<FavoriteSchema> builder, boolean distinct, Schema.OrderBuilder<FavoriteSchema>... orderBuilders) {
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
    public static Specification<Favorite> specify(Schema.PredicateBuilder<FavoriteSchema> builder, boolean distinct, List<Schema.OrderBuilder<FavoriteSchema>> orderBuilders) {
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
    public static Specification<Favorite> specify(Schema.Specification<Favorite, FavoriteSchema> specifier) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            FavoriteSchema favorite = new FavoriteSchema(root, criteriaBuilder);
            return specifier.toPredicate(favorite, criteriaQuery);
        };
    }

}
