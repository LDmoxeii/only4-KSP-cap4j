package com.only4.domain.aggregates.view_history.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.view_history.ViewHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 会员历史记录
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
@RequiredArgsConstructor
public class ViewHistorySchema {
    /**
     * 属性字段集合
     */
    public static class PROPERTY_NAMES {

        /**
         * ID
         */
        public static final String id = "id";

        /**
         * 会员ID
         */
        public static final String memberId = "memberId";

        /**
         * 文章ID
         */
        public static final String articleId = "articleId";

        /**
         * 逻辑删除
         */
        public static final String delFlag = "delFlag";

    }

    private final Path<ViewHistory> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder _criteriaBuilder() {
        return criteriaBuilder;
    }

    public Path<ViewHistory> _root() {
        return root;
    }


    /**
     * ID
     * bigint
     */
    public Schema.Field<Long> id() {
        return new Schema.Field<>(root.get("id"), this.criteriaBuilder);
    }

    /**
     * 会员ID
     * bigint
     */
    public Schema.Field<Long> memberId() {
        return new Schema.Field<>(root.get("memberId"), this.criteriaBuilder);
    }

    /**
     * 文章ID
     * bigint
     */
    public Schema.Field<Long> articleId() {
        return new Schema.Field<>(root.get("articleId"), this.criteriaBuilder);
    }

    /**
     * 逻辑删除
     * tinyint(1)
     */
    public Schema.Field<Boolean> delFlag() {
        return new Schema.Field<>(root.get("delFlag"), this.criteriaBuilder);
    }


    /**
     * 满足所有条件
     * @param restrictions
     * @return
     */
    public Predicate all(Predicate... restrictions) {
        return this.criteriaBuilder.and(restrictions);
    }

    /**
     * 满足任一条件
     * @param restrictions
     * @return
     */
    public Predicate any(Predicate... restrictions) {
        return this.criteriaBuilder.or(restrictions);
    }

    /**
     * 指定条件
     * @param builder
     * @return
     */
    public Predicate spec(Schema.PredicateBuilder<ViewHistorySchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     *
     * @param builder where条件构造器
     * @return
     */
    public static Specification<ViewHistory> specify(Schema.PredicateBuilder<ViewHistorySchema> builder) {
        return specify(builder, false, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder  where条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static Specification<ViewHistory> specify(Schema.PredicateBuilder<ViewHistorySchema> builder, boolean distinct) {
        return specify(builder, distinct, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<ViewHistory> specify(Schema.PredicateBuilder<ViewHistorySchema> builder, Schema.OrderBuilder<ViewHistorySchema>... orderBuilders) {
        return specify(builder, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<ViewHistory> specify(Schema.PredicateBuilder<ViewHistorySchema> builder, List<Schema.OrderBuilder<ViewHistorySchema>> orderBuilders) {
        return specify(builder, orderBuilders);
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<ViewHistory> specify(Schema.PredicateBuilder<ViewHistorySchema> builder, boolean distinct, Schema.OrderBuilder<ViewHistorySchema>... orderBuilders) {
        return specify(builder, distinct, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<ViewHistory> specify(Schema.PredicateBuilder<ViewHistorySchema> builder, boolean distinct, List<Schema.OrderBuilder<ViewHistorySchema>> orderBuilders) {
        return specify((schema, criteriaQuery) -> {
            criteriaQuery.where(builder.build(schema));
            criteriaQuery.distinct(distinct);
            if (orderBuilders != null && !orderBuilders.isEmpty()) {
                criteriaQuery.orderBy(orderBuilders.stream()
                        .map(b -> b.build(schema))
                        .collect(Collectors.toList())
                );
            }
            return null;
        });
    }

    /**
     * 构建查询条件
     *
     * @param specifier 查询条件构造器
     * @return
     */
    public static Specification<ViewHistory> specify(Schema.Specification<ViewHistory, ViewHistorySchema> specifier) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            ViewHistorySchema viewHistory = new ViewHistorySchema(root, criteriaBuilder);
            return specifier.toPredicate(viewHistory, criteriaQuery);
        };
    }

    /**
     * 构建查询条件
     *
     * @param id 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ViewHistory> predicateById(Object id) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byId(ViewHistory.class, id);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ViewHistory> predicateByIds(Collection<Object> ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(ViewHistory.class, ids);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ViewHistory> predicateByIds(Object... ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(ViewHistory.class, Arrays.asList(ids));
    }

    /**
     * 构建查询条件
     *
     * @param builder 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ViewHistory> predicate(Schema.PredicateBuilder<ViewHistorySchema> builder) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(ViewHistory.class, specify(builder));
    }

    /**
     * 构建查询条件
     *
     * @param builder  查询条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ViewHistory> predicate(Schema.PredicateBuilder<ViewHistorySchema> builder, boolean distinct) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(ViewHistory.class, specify(builder, distinct));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ViewHistory> predicate(Schema.PredicateBuilder<ViewHistorySchema> builder, List<Schema.OrderBuilder<ViewHistorySchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(ViewHistory.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ViewHistory> predicate(Schema.PredicateBuilder<ViewHistorySchema> builder, Schema.OrderBuilder<ViewHistorySchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(ViewHistory.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ViewHistory> predicate(Schema.PredicateBuilder<ViewHistorySchema> builder, boolean distinct, List<Schema.OrderBuilder<ViewHistorySchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(ViewHistory.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ViewHistory> predicate(Schema.PredicateBuilder<ViewHistorySchema> builder, boolean distinct, Schema.OrderBuilder<ViewHistorySchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(ViewHistory.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param specifier 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<ViewHistory> predicate(Schema.Specification<ViewHistory, ViewHistorySchema> specifier) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(ViewHistory.class, specify(specifier));
    }
}
