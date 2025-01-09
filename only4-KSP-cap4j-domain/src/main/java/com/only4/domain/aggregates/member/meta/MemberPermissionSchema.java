package com.only4.domain.aggregates.member.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.member.MemberPermission;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 会员权限
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2025/01/09
 */
@RequiredArgsConstructor
public class MemberPermissionSchema {
    /**
     * 属性字段集合
     */
    public static class PROPERTY_NAMES {
        
        /**
         * ID
         */
        public static final String id = "id";

        /**
         * 权限码
         */
        public static final String permissionCode = "permissionCode";

        /**
         * 权限备注
         */
        public static final String permissionMark = "permissionMark";

        /**
         * 逻辑删除
         */
        public static final String delFlag = "delFlag";

    }

    private final Path<MemberPermission> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder _criteriaBuilder() {
        return criteriaBuilder;
    }

    public Path<MemberPermission> _root() {
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
     * 权限码
     * varchar(50)
     */
    public Schema.Field<String> permissionCode() {
        return new Schema.Field<>(root.get("permissionCode"), this.criteriaBuilder);
    }

    /**
     * 权限备注
     * int
     */
    public Schema.Field<Integer> permissionMark() {
        return new Schema.Field<>(root.get("permissionMark"), this.criteriaBuilder);
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
    public Predicate spec(Schema.PredicateBuilder<MemberPermissionSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     *
     * @param builder where条件构造器
     * @return
     */
    public static Specification<MemberPermission> specify(Schema.PredicateBuilder<MemberPermissionSchema> builder) {
        return specify(builder, false, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder  where条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static Specification<MemberPermission> specify(Schema.PredicateBuilder<MemberPermissionSchema> builder, boolean distinct) {
        return specify(builder, distinct, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<MemberPermission> specify(Schema.PredicateBuilder<MemberPermissionSchema> builder, Schema.OrderBuilder<MemberPermissionSchema>... orderBuilders) {
        return specify(builder, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<MemberPermission> specify(Schema.PredicateBuilder<MemberPermissionSchema> builder, List<Schema.OrderBuilder<MemberPermissionSchema>> orderBuilders) {
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
    public static Specification<MemberPermission> specify(Schema.PredicateBuilder<MemberPermissionSchema> builder, boolean distinct, Schema.OrderBuilder<MemberPermissionSchema>... orderBuilders) {
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
    public static Specification<MemberPermission> specify(Schema.PredicateBuilder<MemberPermissionSchema> builder, boolean distinct, List<Schema.OrderBuilder<MemberPermissionSchema>> orderBuilders) {
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
    public static Specification<MemberPermission> specify(Schema.Specification<MemberPermission, MemberPermissionSchema> specifier) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            MemberPermissionSchema memberPermission = new MemberPermissionSchema(root, criteriaBuilder);
            return specifier.toPredicate(memberPermission, criteriaQuery);
        };
    }

}
