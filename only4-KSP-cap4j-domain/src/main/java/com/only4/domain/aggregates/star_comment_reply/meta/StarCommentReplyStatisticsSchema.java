package com.only4.domain.aggregates.star_comment_reply.meta;

import jakarta.persistence.criteria.*;
import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.star_comment_reply.StarCommentReplyStatistics;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 星球评论回复统计
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2025/02/24
 */
@RequiredArgsConstructor
public class StarCommentReplyStatisticsSchema {
    /**
     * 属性字段集合
     */
    public static class PROPERTY_NAMES {
        
        /**
         * ID
         */
        public static final String id = "id";

        /**
         * 点赞数
         */
        public static final String likeCount = "likeCount";

        /**
         * 举报数
         */
        public static final String reportCount = "reportCount";

        /**
         * 逻辑删除
         */
        public static final String delFlag = "delFlag";

    }

    private final Path<StarCommentReplyStatistics> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder _criteriaBuilder() {
        return criteriaBuilder;
    }

    public Path<StarCommentReplyStatistics> _root() {
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
     * 点赞数
     * int
     */
    public Schema.Field<Integer> likeCount() {
        return new Schema.Field<>(root.get("likeCount"), this.criteriaBuilder);
    }

    /**
     * 举报数
     * int
     */
    public Schema.Field<Integer> reportCount() {
        return new Schema.Field<>(root.get("reportCount"), this.criteriaBuilder);
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
    public Predicate spec(Schema.PredicateBuilder<StarCommentReplyStatisticsSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     *
     * @param builder where条件构造器
     * @return
     */
    public static Specification<StarCommentReplyStatistics> specify(Schema.PredicateBuilder<StarCommentReplyStatisticsSchema> builder) {
        return specify(builder, false, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder  where条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static Specification<StarCommentReplyStatistics> specify(Schema.PredicateBuilder<StarCommentReplyStatisticsSchema> builder, boolean distinct) {
        return specify(builder, distinct, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<StarCommentReplyStatistics> specify(Schema.PredicateBuilder<StarCommentReplyStatisticsSchema> builder, Schema.OrderBuilder<StarCommentReplyStatisticsSchema>... orderBuilders) {
        return specify(builder, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<StarCommentReplyStatistics> specify(Schema.PredicateBuilder<StarCommentReplyStatisticsSchema> builder, List<Schema.OrderBuilder<StarCommentReplyStatisticsSchema>> orderBuilders) {
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
    public static Specification<StarCommentReplyStatistics> specify(Schema.PredicateBuilder<StarCommentReplyStatisticsSchema> builder, boolean distinct, Schema.OrderBuilder<StarCommentReplyStatisticsSchema>... orderBuilders) {
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
    public static Specification<StarCommentReplyStatistics> specify(Schema.PredicateBuilder<StarCommentReplyStatisticsSchema> builder, boolean distinct, List<Schema.OrderBuilder<StarCommentReplyStatisticsSchema>> orderBuilders) {
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
    public static Specification<StarCommentReplyStatistics> specify(Schema.Specification<StarCommentReplyStatistics, StarCommentReplyStatisticsSchema> specifier) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            StarCommentReplyStatisticsSchema starCommentReplyStatistics = new StarCommentReplyStatisticsSchema(root, criteriaBuilder);
            return specifier.toPredicate(starCommentReplyStatistics, criteriaQuery);
        };
    }

}
