package com.only4.domain.aggregates.favorites.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.favorites.Favorites;
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
 * 收藏夹
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@RequiredArgsConstructor
public class FavoritesSchema {
    private final Path<Favorites> root;
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
     * 消费者ID
     * bigint
     */
    public Schema.Field<Long> customerId() {
        return root == null ? new Schema.Field<>("customerId") : new Schema.Field<>(root.get("customerId"));
    }

    /**
     * 标题
     * varchar(20)
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
     * 收藏夹状态
     * 0:INIT:INIT
     * int
     */
    public Schema.Field<com.only4.domain.aggregates.favorites.enums.FavoritesState> state() {
        return root == null ? new Schema.Field<>("state") : new Schema.Field<>(root.get("state"));
    }

    /**
     * 默认标识
     * tinyint(1)
     */
    public Schema.Field<Boolean> def() {
        return root == null ? new Schema.Field<>("def") : new Schema.Field<>(root.get("def"));
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
    public Predicate spec(Schema.PredicateBuilder<FavoritesSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<Favorites> specify(Schema.PredicateBuilder<FavoritesSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            FavoritesSchema favorites = new FavoritesSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(favorites));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }

    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<Favorites> specify(Schema.PredicateBuilder<FavoritesSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            FavoritesSchema favorites = new FavoritesSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(favorites));
            return null;
        };
    }

    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<FavoritesSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<FavoritesSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new FavoritesSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
