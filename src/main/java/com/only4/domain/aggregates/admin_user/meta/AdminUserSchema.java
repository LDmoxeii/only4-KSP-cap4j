package com.only4.domain.aggregates.admin_user.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.admin_user.AdminUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 用户表
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@RequiredArgsConstructor
public class AdminUserSchema {
    private final Path<AdminUser> root;
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
     * 用户名
     * varchar(255)
     */
    public Schema.Field<String> name() {
        return root == null ? new Schema.Field<>("name") : new Schema.Field<>(root.get("name"));
    }

    /**
     * 手机号
     * varchar(255)
     */
    public Schema.Field<String> phone() {
        return root == null ? new Schema.Field<>("phone") : new Schema.Field<>(root.get("phone"));
    }

    /**
     * 密码
     * varchar(255)
     */
    public Schema.Field<String> password() {
        return root == null ? new Schema.Field<>("password") : new Schema.Field<>(root.get("password"));
    }

    /**
     * 刷新令牌
     * varchar(255)
     */
    public Schema.Field<String> refreshToken() {
        return root == null ? new Schema.Field<>("refreshToken") : new Schema.Field<>(root.get("refreshToken"));
    }

    /**
     * 过期时间
     * timestamp
     */
    public Schema.Field<java.time.LocalDateTime> loginExpiryDate() {
        return root == null ? new Schema.Field<>("loginExpiryDate") : new Schema.Field<>(root.get("loginExpiryDate"));
    }

    /**
     * 创建时间
     * timestamp
     */
    public Schema.Field<java.time.LocalDateTime> createdAt() {
        return root == null ? new Schema.Field<>("createdAt") : new Schema.Field<>(root.get("createdAt"));
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
    public Predicate spec(Schema.PredicateBuilder<AdminUserSchema> builder){
        return builder.build(this);
    }

    /**
     * AdminUserRole 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.admin_user.meta.AdminUserRoleSchema joinAdminUserRole(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<AdminUser, com.only4.domain.aggregates.admin_user.AdminUserRole> join = ((Root<AdminUser>) root).join("adminUserRoles", type);
        com.only4.domain.aggregates.admin_user.meta.AdminUserRoleSchema schema = new com.only4.domain.aggregates.admin_user.meta.AdminUserRoleSchema(join, criteriaBuilder);
        return schema;
    }
    /**
     * AdminUserPermission 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.admin_user.meta.AdminUserPermissionSchema joinAdminUserPermission(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<AdminUser, com.only4.domain.aggregates.admin_user.AdminUserPermission> join = ((Root<AdminUser>) root).join("adminUserPermissions", type);
        com.only4.domain.aggregates.admin_user.meta.AdminUserPermissionSchema schema = new com.only4.domain.aggregates.admin_user.meta.AdminUserPermissionSchema(join, criteriaBuilder);
        return schema;
    }

    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<AdminUser> specify(Schema.PredicateBuilder<AdminUserSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            AdminUserSchema adminUser = new AdminUserSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(adminUser));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }
    
    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<AdminUser> specify(Schema.PredicateBuilder<AdminUserSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            AdminUserSchema adminUser = new AdminUserSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(adminUser));
            return null;
        };
    }
    
    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<AdminUserSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<AdminUserSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new AdminUserSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
