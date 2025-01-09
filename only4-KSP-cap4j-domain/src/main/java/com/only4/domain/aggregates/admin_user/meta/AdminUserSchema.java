package com.only4.domain.aggregates.admin_user.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.admin_user.AdminUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户表
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2025/01/09
 */
@RequiredArgsConstructor
public class AdminUserSchema {
    /**
     * 属性字段集合
     */
    public static class PROPERTY_NAMES {
        
        /**
         * ID
         */
        public static final String id = "id";

        /**
         * 用户名
         */
        public static final String name = "name";

        /**
         * 手机号
         */
        public static final String phone = "phone";

        /**
         * 密码
         */
        public static final String password = "password";

        /**
         * 刷新令牌
         */
        public static final String refreshToken = "refreshToken";

        /**
         * 过期时间
         */
        public static final String loginExpiryDate = "loginExpiryDate";

        /**
         * 创建时间
         */
        public static final String createdAt = "createdAt";

        /**
         * 逻辑删除
         */
        public static final String delFlag = "delFlag";

    }

    private final Path<AdminUser> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder _criteriaBuilder() {
        return criteriaBuilder;
    }

    public Path<AdminUser> _root() {
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
     * 用户名
     * varchar(255)
     */
    public Schema.Field<String> name() {
        return new Schema.Field<>(root.get("name"), this.criteriaBuilder);
    }

    /**
     * 手机号
     * varchar(255)
     */
    public Schema.Field<String> phone() {
        return new Schema.Field<>(root.get("phone"), this.criteriaBuilder);
    }

    /**
     * 密码
     * varchar(255)
     */
    public Schema.Field<String> password() {
        return new Schema.Field<>(root.get("password"), this.criteriaBuilder);
    }

    /**
     * 刷新令牌
     * varchar(255)
     */
    public Schema.Field<String> refreshToken() {
        return new Schema.Field<>(root.get("refreshToken"), this.criteriaBuilder);
    }

    /**
     * 过期时间
     * timestamp
     */
    public Schema.Field<java.time.LocalDateTime> loginExpiryDate() {
        return new Schema.Field<>(root.get("loginExpiryDate"), this.criteriaBuilder);
    }

    /**
     * 创建时间
     * timestamp
     */
    public Schema.Field<java.time.LocalDateTime> createdAt() {
        return new Schema.Field<>(root.get("createdAt"), this.criteriaBuilder);
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
        Join<AdminUser, com.only4.domain.aggregates.admin_user.AdminUserRole> join = ((Root<AdminUser>) this.root).join("adminUserRoles", type);
        com.only4.domain.aggregates.admin_user.meta.AdminUserRoleSchema schema = new com.only4.domain.aggregates.admin_user.meta.AdminUserRoleSchema(join, this.criteriaBuilder);
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
        Join<AdminUser, com.only4.domain.aggregates.admin_user.AdminUserPermission> join = ((Root<AdminUser>) this.root).join("adminUserPermissions", type);
        com.only4.domain.aggregates.admin_user.meta.AdminUserPermissionSchema schema = new com.only4.domain.aggregates.admin_user.meta.AdminUserPermissionSchema(join, this.criteriaBuilder);
        return schema;
    }

    /**
     * 构建查询条件
     *
     * @param builder where条件构造器
     * @return
     */
    public static Specification<AdminUser> specify(Schema.PredicateBuilder<AdminUserSchema> builder) {
        return specify(builder, false, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder  where条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static Specification<AdminUser> specify(Schema.PredicateBuilder<AdminUserSchema> builder, boolean distinct) {
        return specify(builder, distinct, Collections.emptyList());
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<AdminUser> specify(Schema.PredicateBuilder<AdminUserSchema> builder, Schema.OrderBuilder<AdminUserSchema>... orderBuilders) {
        return specify(builder, Arrays.asList(orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       where条件构造器
     * @param orderBuilders 排序条件构造器
     * @return
     */
    public static Specification<AdminUser> specify(Schema.PredicateBuilder<AdminUserSchema> builder, List<Schema.OrderBuilder<AdminUserSchema>> orderBuilders) {
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
    public static Specification<AdminUser> specify(Schema.PredicateBuilder<AdminUserSchema> builder, boolean distinct, Schema.OrderBuilder<AdminUserSchema>... orderBuilders) {
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
    public static Specification<AdminUser> specify(Schema.PredicateBuilder<AdminUserSchema> builder, boolean distinct, List<Schema.OrderBuilder<AdminUserSchema>> orderBuilders) {
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
    public static Specification<AdminUser> specify(Schema.Specification<AdminUser, AdminUserSchema> specifier) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            AdminUserSchema adminUser = new AdminUserSchema(root, criteriaBuilder);
            return specifier.toPredicate(adminUser, criteriaQuery);
        };
    }

    /**
     * 构建查询条件
     *
     * @param id 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<AdminUser> predicateById(Object id) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byId(AdminUser.class, id);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<AdminUser> predicateByIds(Collection<Object> ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(AdminUser.class, ids);
    }

    /**
     * 构建查询条件
     *
     * @param ids 主键
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<AdminUser> predicateByIds(Object... ids) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.byIds(AdminUser.class, Arrays.asList(ids));
    }

    /**
     * 构建查询条件
     *
     * @param builder 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<AdminUser> predicate(Schema.PredicateBuilder<AdminUserSchema> builder) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(AdminUser.class, specify(builder));
    }

    /**
     * 构建查询条件
     *
     * @param builder  查询条件构造器
     * @param distinct 是否去重
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<AdminUser> predicate(Schema.PredicateBuilder<AdminUserSchema> builder, boolean distinct) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(AdminUser.class, specify(builder, distinct));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<AdminUser> predicate(Schema.PredicateBuilder<AdminUserSchema> builder, List<Schema.OrderBuilder<AdminUserSchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(AdminUser.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<AdminUser> predicate(Schema.PredicateBuilder<AdminUserSchema> builder, Schema.OrderBuilder<AdminUserSchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(AdminUser.class, specify(builder, false, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<AdminUser> predicate(Schema.PredicateBuilder<AdminUserSchema> builder, boolean distinct, List<Schema.OrderBuilder<AdminUserSchema>> orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(AdminUser.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param builder       查询条件构造器
     * @param distinct      是否去重
     * @param orderBuilders 排序构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<AdminUser> predicate(Schema.PredicateBuilder<AdminUserSchema> builder, boolean distinct, Schema.OrderBuilder<AdminUserSchema>... orderBuilders) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(AdminUser.class, specify(builder, distinct, orderBuilders));
    }

    /**
     * 构建查询条件
     *
     * @param specifier 查询条件构造器
     * @return
     */
    public static org.netcorepal.cap4j.ddd.domain.repo.Predicate<AdminUser> predicate(Schema.Specification<AdminUser, AdminUserSchema> specifier) {
        return org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate.bySpecification(AdminUser.class, specify(specifier));
    }
}
