package com.only4.domain.aggregates.order.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
@RequiredArgsConstructor
public class OrderSchema {
    /**
     * 属性字段集合
     */
    public static class PROPERTY_NAMES {

        /**
         * ID
         */
        public static final String id = "id";

        /**
         * 订单金额
         */
        public static final String amount = "amount";

        /**
         * 实付金额
         */
        public static final String price = "price";

        /**
         * 状态
         */
        public static final String state = "state";

        /**
         * 逻辑删除
         */
        public static final String delFlag = "delFlag";

    }

    private final Path<Order> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder _criteriaBuilder() {
        return criteriaBuilder;
    }

    public Path<Order> _root() {
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
     * 订单金额
     * int
     */
    public Schema.Field<Integer> amount() {
        return new Schema.Field<>(root.get("amount"), this.criteriaBuilder);
    }

    /**
     * 实付金额
     * int
     */
    public Schema.Field<Integer> price() {
        return new Schema.Field<>(root.get("price"), this.criteriaBuilder);
    }

    /**
     * 状态
     * tinyint
     */
    public Schema.Field<Byte> state() {
        return new Schema.Field<>(root.get("state"), this.criteriaBuilder);
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
    public Predicate spec(Schema.PredicateBuilder<OrderSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     *
     * @param builder where条件构造器
     * @return
     */
    public static Specification<Order> specify(Schema.PredicateBuilder<OrderSchema> builder) {
        return specify(builder, false, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder  where条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static Specification<Order> specify(Schema.PredicateBuilder<OrderSchema> builder, boolean distinct) {
        return specify(builder, distinct, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<Order> specify(Schema.PredicateBuilder<OrderSchema> builder, Schema.OrderBuilder<OrderSchema>... orderBuilders) {
        return specify(builder, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<Order> specify(Schema.PredicateBuilder<OrderSchema> builder, List<Schema.OrderBuilder<OrderSchema>> orderBuilders) {
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
    public static Specification<Order> specify(Schema.PredicateBuilder<OrderSchema> builder, boolean distinct, Schema.OrderBuilder<OrderSchema>... orderBuilders) {
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
    public static Specification<Order> specify(Schema.PredicateBuilder<OrderSchema> builder, boolean distinct, List<Schema.OrderBuilder<OrderSchema>> orderBuilders) {
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
    public static Specification<Order> specify(Schema.Specification<Order, OrderSchema> specifier) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            OrderSchema order = new OrderSchema(root, criteriaBuilder);
            return specifier.toPredicate(order, criteriaQuery);
        };
    }

    /**
     * 构建查询条件
     *
     * @param id 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Order> predicateById(Object id) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byId(Order.class, id);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Order> predicateByIds(Collection<Object> ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(Order.class, ids);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Order> predicateByIds(Object... ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(Order.class, Arrays.asList(ids));
    }

    /**
     * 构建查询条件
     *
     * @param builder 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Order> predicate(Schema.PredicateBuilder<OrderSchema> builder) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Order.class, specify(builder));
    }

    /**
     * 构建查询条件
     *
     * @param builder  查询条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Order> predicate(Schema.PredicateBuilder<OrderSchema> builder, boolean distinct) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Order.class, specify(builder, distinct));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Order> predicate(Schema.PredicateBuilder<OrderSchema> builder, List<Schema.OrderBuilder<OrderSchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Order.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Order> predicate(Schema.PredicateBuilder<OrderSchema> builder, Schema.OrderBuilder<OrderSchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Order.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Order> predicate(Schema.PredicateBuilder<OrderSchema> builder, boolean distinct, List<Schema.OrderBuilder<OrderSchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Order.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Order> predicate(Schema.PredicateBuilder<OrderSchema> builder, boolean distinct, Schema.OrderBuilder<OrderSchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Order.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param specifier 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<Order> predicate(Schema.Specification<Order, OrderSchema> specifier) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(Order.class, specify(specifier));
    }
}
