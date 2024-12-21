package com.only4.domain.aggregates.member.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.member.BlockMember;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 拉黑会员
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
@RequiredArgsConstructor
public class BlockMemberSchema {
    private final Path<BlockMember> root;
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
     * 拉黑会员ID
     * bigint
     */
    public Schema.Field<Long> blockMemberId() {
        return root == null ? new Schema.Field<>("blockMemberId") : new Schema.Field<>(root.get("blockMemberId"));
    }

    /**
     * 拉黑会员名
     * varchar(50)
     */
    public Schema.Field<String> blockMemberName() {
        return root == null ? new Schema.Field<>("blockMemberName") : new Schema.Field<>(root.get("blockMemberName"));
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
    public Predicate spec(Schema.PredicateBuilder<BlockMemberSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<BlockMember> specify(Schema.PredicateBuilder<BlockMemberSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            BlockMemberSchema blockMember = new BlockMemberSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(blockMember));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }
    
    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<BlockMember> specify(Schema.PredicateBuilder<BlockMemberSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            BlockMemberSchema blockMember = new BlockMemberSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(blockMember));
            return null;
        };
    }
    
    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<BlockMemberSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<BlockMemberSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new BlockMemberSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
