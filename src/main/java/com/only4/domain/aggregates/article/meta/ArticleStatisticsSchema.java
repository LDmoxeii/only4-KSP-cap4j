package com.only4.domain.aggregates.article.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.article.ArticleStatistics;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/11/22
 */
@RequiredArgsConstructor
public class ArticleStatisticsSchema {
    private final Path<ArticleStatistics> root;
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
     * 评论数
     * bigint
     */
    public Schema.Field<Long> comments() {
        return root == null ? new Schema.Field<>("comments") : new Schema.Field<>(root.get("comments"));
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
    public Predicate spec(Schema.PredicateBuilder<ArticleStatisticsSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<ArticleStatistics> specify(Schema.PredicateBuilder<ArticleStatisticsSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            ArticleStatisticsSchema articleStatistics = new ArticleStatisticsSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(articleStatistics));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }

    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<ArticleStatistics> specify(Schema.PredicateBuilder<ArticleStatisticsSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            ArticleStatisticsSchema articleStatistics = new ArticleStatisticsSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(articleStatistics));
            return null;
        };
    }

    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<ArticleStatisticsSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<ArticleStatisticsSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new ArticleStatisticsSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
