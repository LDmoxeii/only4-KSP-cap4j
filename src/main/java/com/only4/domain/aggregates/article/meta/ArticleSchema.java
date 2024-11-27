package com.only4.domain.aggregates.article.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.article.Article;
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
 * 文章
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@RequiredArgsConstructor
public class ArticleSchema {
    private final Path<Article> root;
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
     * 作者ID
     * bigint
     */
    public Schema.Field<Long> authorId() {
        return root == null ? new Schema.Field<>("authorId") : new Schema.Field<>(root.get("authorId"));
    }

    /**
     * 文章状态
     * 0:PRIVATE:PRIVATE
     * 1:PUBLISH:PUBLISH
     * 2:BANNED:BANNED
     * int
     */
    public Schema.Field<com.only4.domain.aggregates.article.enums.ArticleState> state() {
        return root == null ? new Schema.Field<>("state") : new Schema.Field<>(root.get("state"));
    }

    /**
     * 内容
     * varchar(255)
     */
    public Schema.Field<String> content() {
        return root == null ? new Schema.Field<>("content") : new Schema.Field<>(root.get("content"));
    }

    /**
     * 标题
     * varchar(255)
     */
    public Schema.Field<String> title() {
        return root == null ? new Schema.Field<>("title") : new Schema.Field<>(root.get("title"));
    }

    /**
     * 描述
     * varchar(255)
     */
    public Schema.Field<String> description() {
        return root == null ? new Schema.Field<>("description") : new Schema.Field<>(root.get("description"));
    }

    /**
     * 价格
     * bigint
     */
    public Schema.Field<Long> price() {
        return root == null ? new Schema.Field<>("price") : new Schema.Field<>(root.get("price"));
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
    public Predicate spec(Schema.PredicateBuilder<ArticleSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<Article> specify(Schema.PredicateBuilder<ArticleSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            ArticleSchema article = new ArticleSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(article));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }

    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<Article> specify(Schema.PredicateBuilder<ArticleSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            ArticleSchema article = new ArticleSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(article));
            return null;
        };
    }

    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<ArticleSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<ArticleSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new ArticleSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
