package com.only4.domain.aggregates.customer.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.customer.CustomerStatistics;
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
 * @date 2024/11/23
 */
@RequiredArgsConstructor
public class CustomerStatisticsSchema {
    private final Path<CustomerStatistics> root;
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
     * 经验
     * bigint
     */
    public Schema.Field<Long> rank() {
        return root == null ? new Schema.Field<>("rank") : new Schema.Field<>(root.get("rank"));
    }

    /**
     * 点赞数
     * bigint
     */
    public Schema.Field<Long> likes() {
        return root == null ? new Schema.Field<>("likes") : new Schema.Field<>(root.get("likes"));
    }

    /**
     * 粉丝数
     * bigint
     */
    public Schema.Field<Long> fans() {
        return root == null ? new Schema.Field<>("fans") : new Schema.Field<>(root.get("fans"));
    }

    /**
     * 举报数
     * bigint
     */
    public Schema.Field<Long> reports() {
        return root == null ? new Schema.Field<>("reports") : new Schema.Field<>(root.get("reports"));
    }

    /**
     * 关注数
     * bigint
     */
    public Schema.Field<Long> follows() {
        return root == null ? new Schema.Field<>("follows") : new Schema.Field<>(root.get("follows"));
    }

    /**
     * 作品数
     * bigint
     */
    public Schema.Field<Long> works() {
        return root == null ? new Schema.Field<>("works") : new Schema.Field<>(root.get("works"));
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
    public Predicate spec(Schema.PredicateBuilder<CustomerStatisticsSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<CustomerStatistics> specify(Schema.PredicateBuilder<CustomerStatisticsSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            CustomerStatisticsSchema customerStatistics = new CustomerStatisticsSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(customerStatistics));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }

    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<CustomerStatistics> specify(Schema.PredicateBuilder<CustomerStatisticsSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            CustomerStatisticsSchema customerStatistics = new CustomerStatisticsSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(customerStatistics));
            return null;
        };
    }

    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<CustomerStatisticsSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<CustomerStatisticsSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new CustomerStatisticsSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
