package com.only4.domain.aggregates.article_comment_statistics.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.article_comment_statistics.ArticleCommentStatistics;
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
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@RequiredArgsConstructor
public class ArticleCommentStatisticsSchema {
    private final Path<ArticleCommentStatistics> root;
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
     * 文章评论ID
     * bigint
     */
    public Schema.Field<Long> articleCommentId() {
        return root == null ? new Schema.Field<>("articleCommentId") : new Schema.Field<>(root.get("articleCommentId"));
    }

    /**
     * 点赞数
     * bigint
     */
    public Schema.Field<Long> likes() {
        return root == null ? new Schema.Field<>("likes") : new Schema.Field<>(root.get("likes"));
    }

    /**
     * 举报数
     * bigint
     */
    public Schema.Field<Long> reports() {
        return root == null ? new Schema.Field<>("reports") : new Schema.Field<>(root.get("reports"));
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
    public Predicate spec(Schema.PredicateBuilder<ArticleCommentStatisticsSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<ArticleCommentStatistics> specify(Schema.PredicateBuilder<ArticleCommentStatisticsSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            ArticleCommentStatisticsSchema articleCommentStatistics = new ArticleCommentStatisticsSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(articleCommentStatistics));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }

    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<ArticleCommentStatistics> specify(Schema.PredicateBuilder<ArticleCommentStatisticsSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            ArticleCommentStatisticsSchema articleCommentStatistics = new ArticleCommentStatisticsSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(articleCommentStatistics));
            return null;
        };
    }

    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<ArticleCommentStatisticsSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<ArticleCommentStatisticsSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new ArticleCommentStatisticsSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
