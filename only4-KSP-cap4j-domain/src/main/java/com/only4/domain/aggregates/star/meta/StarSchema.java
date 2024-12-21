package com.only4.domain.aggregates.star.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.star.Star;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 星球
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
@RequiredArgsConstructor
public class StarSchema {
    private final Path<Star> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder criteriaBuilder() {
        return criteriaBuilder;
    }

    /**
     * ID
     * bigint
     */
    public Schema.Field<Long> id() {
        return root == null ? new Schema.Field<>("id") : new Schema.Field<>(root.get("id"));
    }

    /**
     * 星主ID
     * bigint
     */
    public Schema.Field<Long> memberId() {
        return root == null ? new Schema.Field<>("memberId") : new Schema.Field<>(root.get("memberId"));
    }

    /**
     * 星球名
     * varchar(50)
     */
    public Schema.Field<String> name() {
        return root == null ? new Schema.Field<>("name") : new Schema.Field<>(root.get("name"));
    }

    /**
     * 星球描述
     * varchar(255)
     */
    public Schema.Field<String> description() {
        return root == null ? new Schema.Field<>("description") : new Schema.Field<>(root.get("description"));
    }

    /**
     * 星球价格
     * int
     */
    public Schema.Field<Integer> amount() {
        return root == null ? new Schema.Field<>("amount") : new Schema.Field<>(root.get("amount"));
    }

    /**
     * 逻辑删除
     * tinyint(1)
     */
    public Schema.Field<Boolean> delFlag() {
        return root == null ? new Schema.Field<>("delFlag") : new Schema.Field<>(root.get("delFlag"));
    }


    /**
     * 满足所有条件
     * @param restrictions
     * @return
     */
    public Predicate all(Predicate... restrictions) {
        return criteriaBuilder().and(restrictions);
    }

    /**
     * 满足任一条件
     * @param restrictions
     * @return
     */
    public Predicate any(Predicate... restrictions) {
        return criteriaBuilder().or(restrictions);
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
        Join<Star, com.only4.domain.aggregates.star.Stardust> join = ((Root<Star>) root).join("stardusts", type);
        com.only4.domain.aggregates.star.meta.StardustSchema schema = new com.only4.domain.aggregates.star.meta.StardustSchema(join, criteriaBuilder);
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
        Join<Star, com.only4.domain.aggregates.star.StarComment> join = ((Root<Star>) root).join("starComments", type);
        com.only4.domain.aggregates.star.meta.StarCommentSchema schema = new com.only4.domain.aggregates.star.meta.StarCommentSchema(join, criteriaBuilder);
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
        Join<Star, com.only4.domain.aggregates.star.StarLike> join = ((Root<Star>) root).join("starLikes", type);
        com.only4.domain.aggregates.star.meta.StarLikeSchema schema = new com.only4.domain.aggregates.star.meta.StarLikeSchema(join, criteriaBuilder);
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
        Join<Star, com.only4.domain.aggregates.star.StarStatistice> join = ((Root<Star>) root).join("starStatistices", type);
        com.only4.domain.aggregates.star.meta.StarStatisticeSchema schema = new com.only4.domain.aggregates.star.meta.StarStatisticeSchema(join, criteriaBuilder);
        return schema;
    }

    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<Star> specify(Schema.PredicateBuilder<StarSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            StarSchema star = new StarSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(star));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }
    
    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<Star> specify(Schema.PredicateBuilder<StarSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            StarSchema star = new StarSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(star));
            return null;
        };
    }
    
    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<StarSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<StarSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new StarSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
