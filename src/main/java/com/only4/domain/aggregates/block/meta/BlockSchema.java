package com.only4.domain.aggregates.block.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.block.Block;
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
 * 拉黑
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@RequiredArgsConstructor
public class BlockSchema {
    private final Path<Block> root;
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
     * 拉黑人ID
     * bigint
     */
    public Schema.Field<Long> blockId() {
        return root == null ? new Schema.Field<>("blockId") : new Schema.Field<>(root.get("blockId"));
    }

    /**
     * 被拉黑人ID
     * bigint
     */
    public Schema.Field<Long> blockedId() {
        return root == null ? new Schema.Field<>("blockedId") : new Schema.Field<>(root.get("blockedId"));
    }

    /**
     * 逻辑删除
     * tinyint
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
    public Predicate spec(Schema.PredicateBuilder<BlockSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<Block> specify(Schema.PredicateBuilder<BlockSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            BlockSchema block = new BlockSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(block));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }

    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<Block> specify(Schema.PredicateBuilder<BlockSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            BlockSchema block = new BlockSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(block));
            return null;
        };
    }

    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<BlockSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<BlockSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new BlockSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
