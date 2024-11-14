package com.only4.domain.aggregates.role.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.role.RolePermission;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 角色权限表
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/11/14
 */
@RequiredArgsConstructor
public class RolePermissionSchema {
    private final Path<RolePermission> root;
    private final CriteriaBuilder criteriaBuilder;

    public CriteriaBuilder criteriaBuilder() {
        return criteriaBuilder;
    }

    public Schema.Field<Long> id() {
        return root == null ? new Schema.Field<>("id") : new Schema.Field<>(root.get("id"));
    }

    /**
     * 权限编码
     * varchar(255)
     */
    public Schema.Field<String> permissionCode() {
        return root == null ? new Schema.Field<>("permissionCode") : new Schema.Field<>(root.get("permissionCode"));
    }

    /**
     * 权限备注
     * varchar(255)
     */
    public Schema.Field<String> permissionRemark() {
        return root == null ? new Schema.Field<>("permissionRemark") : new Schema.Field<>(root.get("permissionRemark"));
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
    public Predicate spec(Schema.PredicateBuilder<RolePermissionSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<RolePermission> specify(Schema.PredicateBuilder<RolePermissionSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            RolePermissionSchema rolePermission = new RolePermissionSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(rolePermission));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }
    
    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<RolePermission> specify(Schema.PredicateBuilder<RolePermissionSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            RolePermissionSchema rolePermission = new RolePermissionSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(rolePermission));
            return null;
        };
    }
    
    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<RolePermissionSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<RolePermissionSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new RolePermissionSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
