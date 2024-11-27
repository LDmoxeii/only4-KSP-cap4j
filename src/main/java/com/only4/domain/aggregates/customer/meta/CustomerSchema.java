package com.only4.domain.aggregates.customer.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.customer.Customer;
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
 * 消费者
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@RequiredArgsConstructor
public class CustomerSchema {
    private final Path<Customer> root;
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
     * 帐号
     * varchar(255)
     */
    public Schema.Field<String> account() {
        return root == null ? new Schema.Field<>("account") : new Schema.Field<>(root.get("account"));
    }

    /**
     * 密码
     * varchar(255)
     */
    public Schema.Field<String> password() {
        return root == null ? new Schema.Field<>("password") : new Schema.Field<>(root.get("password"));
    }

    /**
     * varchar(20)
     */
    public Schema.Field<String> phone() {
        return root == null ? new Schema.Field<>("phone") : new Schema.Field<>(root.get("phone"));
    }

    /**
     * 昵称
     * varchar(255)
     */
    public Schema.Field<String> nickName() {
        return root == null ? new Schema.Field<>("nickName") : new Schema.Field<>(root.get("nickName"));
    }

    /**
     * 个性签名
     * varchar(255)
     */
    public Schema.Field<String> signature() {
        return root == null ? new Schema.Field<>("signature") : new Schema.Field<>(root.get("signature"));
    }

    /**
     * 余额
     * bigint
     */
    public Schema.Field<Long> balance() {
        return root == null ? new Schema.Field<>("balance") : new Schema.Field<>(root.get("balance"));
    }

    /**
     * 状态
     * 0:INIT:INIT
     * 2:BANNED:BANNED
     * int
     */
    public Schema.Field<com.only4.domain.aggregates.customer.enums.CustomerState> state() {
        return root == null ? new Schema.Field<>("state") : new Schema.Field<>(root.get("state"));
    }

    /**
     * 等级
     * varchar(255)
     */
    public Schema.Field<String> grade() {
        return root == null ? new Schema.Field<>("grade") : new Schema.Field<>(root.get("grade"));
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
    public Predicate spec(Schema.PredicateBuilder<CustomerSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<Customer> specify(Schema.PredicateBuilder<CustomerSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            CustomerSchema customer = new CustomerSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(customer));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }

    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<Customer> specify(Schema.PredicateBuilder<CustomerSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            CustomerSchema customer = new CustomerSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(customer));
            return null;
        };
    }

    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<CustomerSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<CustomerSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new CustomerSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
