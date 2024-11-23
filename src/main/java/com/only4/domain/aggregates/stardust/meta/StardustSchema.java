package com.only4.domain.aggregates.stardust.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.stardust.Stardust;
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
 * 星尘
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/11/23
 */
@RequiredArgsConstructor
public class StardustSchema {
    private final Path<Stardust> root;
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
     * 星球ID
     * bigint
     */
    public Schema.Field<Long> starId() {
        return root == null ? new Schema.Field<>("starId") : new Schema.Field<>(root.get("starId"));
    }

    /**
     * 消费者ID
     * bigint
     */
    public Schema.Field<Long> customerId() {
        return root == null ? new Schema.Field<>("customerId") : new Schema.Field<>(root.get("customerId"));
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
    public Predicate spec(Schema.PredicateBuilder<StardustSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<Stardust> specify(Schema.PredicateBuilder<StardustSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            StardustSchema stardust = new StardustSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(stardust));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }

    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<Stardust> specify(Schema.PredicateBuilder<StardustSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            StardustSchema stardust = new StardustSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(stardust));
            return null;
        };
    }

    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<StardustSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<StardustSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new StardustSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
