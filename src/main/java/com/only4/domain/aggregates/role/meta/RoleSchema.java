package com.only4.domain.aggregates.role.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.role.Role;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

/**
 * 角色表
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/11/22
 */
@RequiredArgsConstructor
public class RoleSchema {
    private final Path<Role> root;
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
     * 角色名
     * varchar(255)
     */
    public Schema.Field<String> name() {
        return root == null ? new Schema.Field<>("name") : new Schema.Field<>(root.get("name"));
    }

    /**
     * 角色描述
     * varchar(255)
     */
    public Schema.Field<String> description() {
        return root == null ? new Schema.Field<>("description") : new Schema.Field<>(root.get("description"));
    }

    /**
     * 创建时间
     * timestamp
     */
    public Schema.Field<java.time.LocalDateTime> createdAt() {
        return root == null ? new Schema.Field<>("createdAt") : new Schema.Field<>(root.get("createdAt"));
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
    public Predicate spec(Schema.PredicateBuilder<RoleSchema> builder){
        return builder.build(this);
    }

    /**
     * RolePermission 关联查询条件定义
     *
     * @param joinType
     * @return
     */
    public com.only4.domain.aggregates.role.meta.RolePermissionSchema joinRolePermission(Schema.JoinType joinType) {
        JoinType type = joinType.toJpaJoinType();
        Join<Role, com.only4.domain.aggregates.role.RolePermission> join = ((Root<Role>) root).join("rolePermissions", type);
        com.only4.domain.aggregates.role.meta.RolePermissionSchema schema = new com.only4.domain.aggregates.role.meta.RolePermissionSchema(join, criteriaBuilder);
        return schema;
    }

    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<Role> specify(Schema.PredicateBuilder<RoleSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            RoleSchema role = new RoleSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(role));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }

    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<Role> specify(Schema.PredicateBuilder<RoleSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            RoleSchema role = new RoleSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(role));
            return null;
        };
    }

    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<RoleSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<RoleSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new RoleSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
