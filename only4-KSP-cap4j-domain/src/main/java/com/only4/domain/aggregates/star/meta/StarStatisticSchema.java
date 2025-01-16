package com.only4.domain.aggregates.star.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.star.StarStatistic;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 星球统计
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2025/01/16
 */
@RequiredArgsConstructor
public class StarStatisticSchema {
    /**
     * 属性字段集合
     */
    public static class PROPERTY_NAMES {
        
        /**
         * ID
         */
        public static final String id = "id";

        /**
         * 星球点赞数
         */
        public static final String likes = "likes";

        /**
         * 星球评论数
         */
        public static final String comments = "comments";

        /**
         * 星尘数
         */
        public static final String stardust = "stardust";

        /**
         * 逻辑删除
         */
        public static final String delFlag = "delFlag";

    }

    private final Path<StarStatistic> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder _criteriaBuilder() {
        return criteriaBuilder;
    }

    public Path<StarStatistic> _root() {
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
     * 星球点赞数
     * int
     */
    public Schema.Field<Integer> likes() {
        return new Schema.Field<>(root.get("likes"), this.criteriaBuilder);
    }

    /**
     * 星球评论数
     * int
     */
    public Schema.Field<Integer> comments() {
        return new Schema.Field<>(root.get("comments"), this.criteriaBuilder);
    }

    /**
     * 星尘数
     * int
     */
    public Schema.Field<Integer> stardust() {
        return new Schema.Field<>(root.get("stardust"), this.criteriaBuilder);
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
    public Predicate spec(Schema.PredicateBuilder<StarStatisticSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     *
     * @param builder where条件构造器
     * @return
     */
    public static Specification<StarStatistic> specify(Schema.PredicateBuilder<StarStatisticSchema> builder) {
        return specify(builder, false, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder  where条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static Specification<StarStatistic> specify(Schema.PredicateBuilder<StarStatisticSchema> builder, boolean distinct) {
        return specify(builder, distinct, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<StarStatistic> specify(Schema.PredicateBuilder<StarStatisticSchema> builder, Schema.OrderBuilder<StarStatisticSchema>... orderBuilders) {
        return specify(builder, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<StarStatistic> specify(Schema.PredicateBuilder<StarStatisticSchema> builder, List<Schema.OrderBuilder<StarStatisticSchema>> orderBuilders) {
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
    public static Specification<StarStatistic> specify(Schema.PredicateBuilder<StarStatisticSchema> builder, boolean distinct, Schema.OrderBuilder<StarStatisticSchema>... orderBuilders) {
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
    public static Specification<StarStatistic> specify(Schema.PredicateBuilder<StarStatisticSchema> builder, boolean distinct, List<Schema.OrderBuilder<StarStatisticSchema>> orderBuilders) {
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
    public static Specification<StarStatistic> specify(Schema.Specification<StarStatistic, StarStatisticSchema> specifier) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            StarStatisticSchema starStatistic = new StarStatisticSchema(root, criteriaBuilder);
            return specifier.toPredicate(starStatistic, criteriaQuery);
        };
    }

}
