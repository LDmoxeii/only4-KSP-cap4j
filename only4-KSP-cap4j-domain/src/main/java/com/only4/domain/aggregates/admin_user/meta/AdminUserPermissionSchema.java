package com.only4.domain.aggregates.admin_user.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.admin_user.AdminUserPermission;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户权限表
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
@RequiredArgsConstructor
public class AdminUserPermissionSchema {
    /**
     * 属性字段集合
     */
    public static class PROPERTY_NAMES {

        /**
         * ID
         */
        public static final String id = "id";

        /**
         * 权限编码
         */
        public static final String permissionCode = "permissionCode";

        /**
         * 权限备注
         */
        public static final String permissionRemark = "permissionRemark";

        /**
         * 逻辑删除
         */
        public static final String delFlag = "delFlag";

    }

    private final Path<AdminUserPermission> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder _criteriaBuilder() {
        return criteriaBuilder;
    }

    public Path<AdminUserPermission> _root() {
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
     * 权限编码
     * varchar(255)
     */
    public Schema.Field<String> permissionCode() {
        return new Schema.Field<>(root.get("permissionCode"), this.criteriaBuilder);
    }

    /**
     * 权限备注
     * varchar(255)
     */
    public Schema.Field<String> permissionRemark() {
        return new Schema.Field<>(root.get("permissionRemark"), this.criteriaBuilder);
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
    public Predicate spec(Schema.PredicateBuilder<AdminUserPermissionSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     *
     * @param builder where条件构造器
     * @return
     */
    public static Specification<AdminUserPermission> specify(Schema.PredicateBuilder<AdminUserPermissionSchema> builder) {
        return specify(builder, false, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder  where条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static Specification<AdminUserPermission> specify(Schema.PredicateBuilder<AdminUserPermissionSchema> builder, boolean distinct) {
        return specify(builder, distinct, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<AdminUserPermission> specify(Schema.PredicateBuilder<AdminUserPermissionSchema> builder, Schema.OrderBuilder<AdminUserPermissionSchema>... orderBuilders) {
        return specify(builder, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<AdminUserPermission> specify(Schema.PredicateBuilder<AdminUserPermissionSchema> builder, List<Schema.OrderBuilder<AdminUserPermissionSchema>> orderBuilders) {
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
    public static Specification<AdminUserPermission> specify(Schema.PredicateBuilder<AdminUserPermissionSchema> builder, boolean distinct, Schema.OrderBuilder<AdminUserPermissionSchema>... orderBuilders) {
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
    public static Specification<AdminUserPermission> specify(Schema.PredicateBuilder<AdminUserPermissionSchema> builder, boolean distinct, List<Schema.OrderBuilder<AdminUserPermissionSchema>> orderBuilders) {
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
    public static Specification<AdminUserPermission> specify(Schema.Specification<AdminUserPermission, AdminUserPermissionSchema> specifier) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            AdminUserPermissionSchema adminUserPermission = new AdminUserPermissionSchema(root, criteriaBuilder);
            return specifier.toPredicate(adminUserPermission, criteriaQuery);
        };
    }

}
