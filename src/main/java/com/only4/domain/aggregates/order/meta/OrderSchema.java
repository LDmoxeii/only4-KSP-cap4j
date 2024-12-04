package com.only4.domain.aggregates.order.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.order.Order;
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
 * 订单
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@RequiredArgsConstructor
public class OrderSchema {
    private final Path<Order> root;
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
     * 流水号
     * varchar(255)
     */
    public Schema.Field<String> serial() {
        return root == null ? new Schema.Field<>("serial") : new Schema.Field<>(root.get("serial"));
    }

    /**
     * 消费者ID
     * bigint
     */
    public Schema.Field<Long> customerId() {
        return root == null ? new Schema.Field<>("customerId") : new Schema.Field<>(root.get("customerId"));
    }

    /**
     * 名称
     * varchar(255)
     */
    public Schema.Field<String> name() {
        return root == null ? new Schema.Field<>("name") : new Schema.Field<>(root.get("name"));
    }

    /**
     * 类型
     * 0:INIT:INIT
     * int
     */
    public Schema.Field<com.only4.domain.aggregates.order.enums.OrderType> type() {
        return root == null ? new Schema.Field<>("type") : new Schema.Field<>(root.get("type"));
    }

    /**
     * 订单状态
     * 0:INIT:INIT
     * 1:REFUND:REFUND
     * 2:CANCELED:CANCELED
     * int
     */
    public Schema.Field<com.only4.domain.aggregates.order.enums.OrderState> state() {
        return root == null ? new Schema.Field<>("state") : new Schema.Field<>(root.get("state"));
    }

    /**
     * 总价格
     * bigint
     */
    public Schema.Field<Long> price() {
        return root == null ? new Schema.Field<>("price") : new Schema.Field<>(root.get("price"));
    }

    /**
     * 实付价格
     * bigint
     */
    public Schema.Field<Long> actualPrice() {
        return root == null ? new Schema.Field<>("actualPrice") : new Schema.Field<>(root.get("actualPrice"));
    }

    /**
     * 支付时间
     * timestamp
     */
    public Schema.Field<java.time.LocalDateTime> payTime() {
        return root == null ? new Schema.Field<>("payTime") : new Schema.Field<>(root.get("payTime"));
    }

    /**
     * 支付标识
     * tinyint(1)
     */
    public Schema.Field<Boolean> isPaid() {
        return root == null ? new Schema.Field<>("isPaid") : new Schema.Field<>(root.get("isPaid"));
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
    public Predicate spec(Schema.PredicateBuilder<OrderSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<Order> specify(Schema.PredicateBuilder<OrderSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            OrderSchema order = new OrderSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(order));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }

    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<Order> specify(Schema.PredicateBuilder<OrderSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            OrderSchema order = new OrderSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(order));
            return null;
        };
    }

    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<OrderSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<OrderSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new OrderSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
