package com.only4.domain.aggregates.star.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.star.StarLike;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 星球点赞
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
@RequiredArgsConstructor
public class StarLikeSchema {
    private final Path<StarLike> root;
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
     * 星尘ID
     * bigint
     */
    public Schema.Field<Long> stardustId() {
        return root == null ? new Schema.Field<>("stardustId") : new Schema.Field<>(root.get("stardustId"));
    }

    /**
     * 点赞时间
     * timestamp
     */
    public Schema.Field<java.time.LocalDateTime> createAt() {
        return root == null ? new Schema.Field<>("createAt") : new Schema.Field<>(root.get("createAt"));
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
    public Predicate spec(Schema.PredicateBuilder<StarLikeSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<StarLike> specify(Schema.PredicateBuilder<StarLikeSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            StarLikeSchema starLike = new StarLikeSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(starLike));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }
    
    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<StarLike> specify(Schema.PredicateBuilder<StarLikeSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            StarLikeSchema starLike = new StarLikeSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(starLike));
            return null;
        };
    }
    
    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<StarLikeSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<StarLikeSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new StarLikeSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
