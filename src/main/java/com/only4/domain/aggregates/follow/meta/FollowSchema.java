package com.only4.domain.aggregates.follow.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.follow.Follow;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 关注
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@RequiredArgsConstructor
public class FollowSchema {
    private final Path<Follow> root;
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
     * 关注人ID
     * bigint
     */
    public Schema.Field<Long> followId() {
        return root == null ? new Schema.Field<>("followId") : new Schema.Field<>(root.get("followId"));
    }

    /**
     * 被关注人ID
     * bigint
     */
    public Schema.Field<Long> followedId() {
        return root == null ? new Schema.Field<>("followedId") : new Schema.Field<>(root.get("followedId"));
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
    public Predicate spec(Schema.PredicateBuilder<FollowSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<Follow> specify(Schema.PredicateBuilder<FollowSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            FollowSchema follow = new FollowSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(follow));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }

    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<Follow> specify(Schema.PredicateBuilder<FollowSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            FollowSchema follow = new FollowSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(follow));
            return null;
        };
    }

    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<FollowSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<FollowSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new FollowSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
