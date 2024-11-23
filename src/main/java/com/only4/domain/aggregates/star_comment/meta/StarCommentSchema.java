package com.only4.domain.aggregates.star_comment.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.star_comment.StarComment;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

/**
 * 星球评论
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/11/23
 */
@RequiredArgsConstructor
public class StarCommentSchema {
    private final Path<StarComment> root;
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
     * 文章ID
     * bigint
     */
    public Schema.Field<Long> articleId() {
        return root == null ? new Schema.Field<>("articleId") : new Schema.Field<>(root.get("articleId"));
    }

    /**
     * 作者ID
     * bigint
     */
    public Schema.Field<Long> authorId() {
        return root == null ? new Schema.Field<>("authorId") : new Schema.Field<>(root.get("authorId"));
    }

    /**
     * 内容
     * varchar(255)
     */
    public Schema.Field<String> content() {
        return root == null ? new Schema.Field<>("content") : new Schema.Field<>(root.get("content"));
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
    public Predicate spec(Schema.PredicateBuilder<StarCommentSchema> builder){
        return builder.build(this);
    }

    /**
     * StarCommentStatistics 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.star_comment.meta.StarCommentStatisticsSchema joinStarCommentStatistics(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<StarComment, com.only4.domain.aggregates.star_comment.StarCommentStatistics> join = ((Root<StarComment>) root).join("starCommentStatistics", type);
        com.only4.domain.aggregates.star_comment.meta.StarCommentStatisticsSchema schema = new com.only4.domain.aggregates.star_comment.meta.StarCommentStatisticsSchema(join, criteriaBuilder);
        return schema;
    }

    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<StarComment> specify(Schema.PredicateBuilder<StarCommentSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            StarCommentSchema starComment = new StarCommentSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(starComment));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }

    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<StarComment> specify(Schema.PredicateBuilder<StarCommentSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            StarCommentSchema starComment = new StarCommentSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(starComment));
            return null;
        };
    }

    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<StarCommentSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<StarCommentSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new StarCommentSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
