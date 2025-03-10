package com.only4.domain.aggregates.member.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.member.MemberStatistics;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 会员统计
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2025/02/21
 */
@RequiredArgsConstructor
public class MemberStatisticsSchema {
    /**
     * 属性字段集合
     */
    public static class PROPERTY_NAMES {

        /**
         * ID
         */
        public static final String id = "id";

        /**
         * 等级分
         */
        public static final String rank = "rank";

        /**
         * 点赞数
         */
        public static final String likeCount = "likeCount";

        /**
         * 粉丝数
         */
        public static final String fanCount = "fanCount";

        /**
         * 举报数
         */
        public static final String reportCount = "reportCount";

        /**
         * 关注数
         */
        public static final String followingCount = "followingCount";

        /**
         * 作品数
         */
        public static final String workCount = "workCount";

        /**
         * 播放量
         */
        public static final String viewCount = "viewCount";

        /**
         * 逻辑删除
         */
        public static final String delFlag = "delFlag";

        /**
         * 星尘数
         */
        public static final String stardustCount = "stardustCount";

    }

    private final Path<MemberStatistics> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder _criteriaBuilder() {
        return criteriaBuilder;
    }

    public Path<MemberStatistics> _root() {
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
     * 等级分
     * int
     */
    public Schema.Field<Integer> rank() {
        return new Schema.Field<>(root.get("rank"), this.criteriaBuilder);
    }

    /**
     * 点赞数
     * int
     */
    public Schema.Field<Integer> likeCount() {
        return new Schema.Field<>(root.get("likeCount"), this.criteriaBuilder);
    }

    /**
     * 粉丝数
     * int
     */
    public Schema.Field<Integer> fanCount() {
        return new Schema.Field<>(root.get("fanCount"), this.criteriaBuilder);
    }

    /**
     * 举报数
     * int
     */
    public Schema.Field<Integer> reportCount() {
        return new Schema.Field<>(root.get("reportCount"), this.criteriaBuilder);
    }

    /**
     * 关注数
     * int
     */
    public Schema.Field<Integer> followingCount() {
        return new Schema.Field<>(root.get("followingCount"), this.criteriaBuilder);
    }

    /**
     * 作品数
     * int
     */
    public Schema.Field<Integer> workCount() {
        return new Schema.Field<>(root.get("workCount"), this.criteriaBuilder);
    }

    /**
     * 播放量
     * int
     */
    public Schema.Field<Integer> viewCount() {
        return new Schema.Field<>(root.get("viewCount"), this.criteriaBuilder);
    }

    /**
     * 逻辑删除
     * tinyint(1)
     */
    public Schema.Field<Boolean> delFlag() {
        return new Schema.Field<>(root.get("delFlag"), this.criteriaBuilder);
    }

    /**
     * 星尘数
     * int
     */
    public Schema.Field<Integer> stardustCount() {
        return new Schema.Field<>(root.get("stardustCount"), this.criteriaBuilder);
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
    public Predicate spec(Schema.PredicateBuilder<MemberStatisticsSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     *
     * @param builder where条件构造器
     * @return
     */
    public static Specification<MemberStatistics> specify(Schema.PredicateBuilder<MemberStatisticsSchema> builder) {
        return specify(builder, false, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder  where条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static Specification<MemberStatistics> specify(Schema.PredicateBuilder<MemberStatisticsSchema> builder, boolean distinct) {
        return specify(builder, distinct, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<MemberStatistics> specify(Schema.PredicateBuilder<MemberStatisticsSchema> builder, Schema.OrderBuilder<MemberStatisticsSchema>... orderBuilders) {
        return specify(builder, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<MemberStatistics> specify(Schema.PredicateBuilder<MemberStatisticsSchema> builder, List<Schema.OrderBuilder<MemberStatisticsSchema>> orderBuilders) {
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
    public static Specification<MemberStatistics> specify(Schema.PredicateBuilder<MemberStatisticsSchema> builder, boolean distinct, Schema.OrderBuilder<MemberStatisticsSchema>... orderBuilders) {
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
    public static Specification<MemberStatistics> specify(Schema.PredicateBuilder<MemberStatisticsSchema> builder, boolean distinct, List<Schema.OrderBuilder<MemberStatisticsSchema>> orderBuilders) {
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
    public static Specification<MemberStatistics> specify(Schema.Specification<MemberStatistics, MemberStatisticsSchema> specifier) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            MemberStatisticsSchema memberStatistics = new MemberStatisticsSchema(root, criteriaBuilder);
            return specifier.toPredicate(memberStatistics, criteriaQuery);
        };
    }

}
