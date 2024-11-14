package com.only4.domain.aggregates.admin_user.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.admin_user.AdminUserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 用户角色表
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/11/14
 */
@RequiredArgsConstructor
public class AdminUserRoleSchema {
    private final Path<AdminUserRole> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder criteriaBuilder() {
        return criteriaBuilder;
    }

    public Schema.Field<Long> id() {
        return root == null ? new Schema.Field<>("id") : new Schema.Field<>(root.get("id"));
    }

    /**
     * 角色ID
     * bigint
     */
    public Schema.Field<Long> roleId() {
        return root == null ? new Schema.Field<>("roleId") : new Schema.Field<>(root.get("roleId"));
    }

    /**
     * 角色名
     * varchar(255)
     */
    public Schema.Field<String> roleName() {
        return root == null ? new Schema.Field<>("roleName") : new Schema.Field<>(root.get("roleName"));
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
    public Predicate spec(Schema.PredicateBuilder<AdminUserRoleSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<AdminUserRole> specify(Schema.PredicateBuilder<AdminUserRoleSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            AdminUserRoleSchema adminUserRole = new AdminUserRoleSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(adminUserRole));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }
    
    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<AdminUserRole> specify(Schema.PredicateBuilder<AdminUserRoleSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            AdminUserRoleSchema adminUserRole = new AdminUserRoleSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(adminUserRole));
            return null;
        };
    }
    
    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<AdminUserRoleSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<AdminUserRoleSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new AdminUserRoleSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
