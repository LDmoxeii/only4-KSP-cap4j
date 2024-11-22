package com.only4.domain.aggregates.admin_user.meta;

import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.admin_user.AdminUserPermission;
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
 * 用户权限表
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成
 * 警告：请勿手工修改该文件，重新生成会覆盖该文件
 * @author cap4j-ddd-codegen
 * @date 2024/11/22
 */
@RequiredArgsConstructor
public class AdminUserPermissionSchema {
    private final Path<AdminUserPermission> root;
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
    public Predicate spec(Schema.PredicateBuilder<AdminUserPermissionSchema> builder){
        return builder.build(this);
    }


    /**
     * 构建查询条件
     * @param builder
     * @param distinct
     * @return
     */
    public static Specification<AdminUserPermission> specify(Schema.PredicateBuilder<AdminUserPermissionSchema> builder, boolean distinct) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            AdminUserPermissionSchema adminUserPermission = new AdminUserPermissionSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(adminUserPermission));
            criteriaQuery.distinct(distinct);
            return null;
        };
    }

    /**
     * 构建查询条件
     * @param builder
     * @return
     */
    public static Specification<AdminUserPermission> specify(Schema.PredicateBuilder<AdminUserPermissionSchema> builder) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            AdminUserPermissionSchema adminUserPermission = new AdminUserPermissionSchema(root, criteriaBuilder);
            criteriaQuery.where(builder.build(adminUserPermission));
            return null;
        };
    }

    /**
     * 构建排序
     * @param builders
     * @return
     */
    public static Sort orderBy(Schema.OrderBuilder<AdminUserPermissionSchema>... builders) {
        return orderBy(Arrays.asList(builders));
    }

    /**
     * 构建排序
     *
     * @param builders
     * @return
     */
    public static Sort orderBy(Collection<Schema.OrderBuilder<AdminUserPermissionSchema>> builders) {
        if(null == builders || builders.isEmpty()) {
            return Sort.unsorted();
        }
        return Sort.by(builders.stream()
                .map(builder -> builder.build(new AdminUserPermissionSchema(null, null)))
                .collect(Collectors.toList())
        );
    }

}
