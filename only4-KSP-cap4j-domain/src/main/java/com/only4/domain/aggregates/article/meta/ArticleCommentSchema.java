package com.only4.domain.aggregates.article.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.article.ArticleComment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 文章评论
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
@RequiredArgsConstructor
public class ArticleCommentSchema {
    private final Path<ArticleComment> root;
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
     * 父评论ID
     * bigint
     */
    public Schema.Field<Long> parentId() {
        return root == null ? new Schema.Field<>("parentId") : new Schema.Field<>(root.get("parentId"));
    }

    /**
     * 评论用户ID
     * bigint
     */
    public Schema.Field<Long> authorId() {
        return root == null ? new Schema.Field<>("authorId") : new Schema.Field<>(root.get("authorId"));
    }

    /**
     * 评论用户名
     * varchar(50)
     */
    public Schema.Field<String> authorName() {
        return root == null ? new Schema.Field<>("authorName") : new Schema.Field<>(root.get("authorName"));
    }

    /**
     * 内容
     * varchar(255)
     */
    public Schema.Field<String> content() {
        return root == null ? new Schema.Field<>("content") : new Schema.Field<>(root.get("content"));
    }

    /**
     * 置顶标识
     * tinyint(1)
     */
    public Schema.Field<Boolean> stickyFlag() {
        return root == null ? new Schema.Field<>("stickyFlag") : new Schema.Field<>(root.get("stickyFlag"));
    }

    /**
     * 评论时间
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
    public Predicate spec(Schema.PredicateBuilder<ArticleCommentSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<ArticleComment> specify(Schema.PredicateBuilder<ArticleCommentSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            ArticleCommentSchema articleComment = new ArticleCommentSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(articleComment));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }
    
    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<ArticleComment> specify(Schema.PredicateBuilder<ArticleCommentSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            ArticleCommentSchema articleComment = new ArticleCommentSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(articleComment));
            return null;
        };
    }
    
    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<ArticleCommentSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<ArticleCommentSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new ArticleCommentSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
