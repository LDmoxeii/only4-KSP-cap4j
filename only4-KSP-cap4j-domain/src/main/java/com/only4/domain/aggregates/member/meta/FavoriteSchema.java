package com.only4.domain.aggregates.member.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.member.Favorite;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 会员收藏夹
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
@RequiredArgsConstructor
public class FavoriteSchema {
    private final Path<Favorite> root;
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
     * 收藏夹ID
     * bigint
     */
    public Schema.Field<Long> favoriteId() {
        return root == null ? new Schema.Field<>("favoriteId") : new Schema.Field<>(root.get("favoriteId"));
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
        Join<Favorite, com.only4.domain.aggregates.member.ArticleFavoriteStatistics> join = ((Root<Favorite>) root).join("articleFavoriteStatistics", type);
        com.only4.domain.aggregates.member.meta.ArticleFavoriteStatisticsSchema schema = new com.only4.domain.aggregates.member.meta.ArticleFavoriteStatisticsSchema(join, criteriaBuilder);
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
        Join<Favorite, com.only4.domain.aggregates.member.ArticleFavoriteRecord> join = ((Root<Favorite>) root).join("articleFavoriteRecords", type);
        com.only4.domain.aggregates.member.meta.ArticleFavoriteRecordSchema schema = new com.only4.domain.aggregates.member.meta.ArticleFavoriteRecordSchema(join, criteriaBuilder);
        return schema;
    }

    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<Favorite> specify(Schema.PredicateBuilder<FavoriteSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            FavoriteSchema favorite = new FavoriteSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(favorite));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }
    
    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<Favorite> specify(Schema.PredicateBuilder<FavoriteSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            FavoriteSchema favorite = new FavoriteSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(favorite));
            return null;
        };
    }
    
    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<FavoriteSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<FavoriteSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new FavoriteSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
