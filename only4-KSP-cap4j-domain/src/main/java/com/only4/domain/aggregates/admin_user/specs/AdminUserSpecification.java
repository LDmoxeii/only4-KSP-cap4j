package com.only4.domain.aggregates.admin_user.specs;

import com.only4.domain.aggregates.admin_user.AdminUser;
import org.netcorepal.cap4j.ddd.domain.aggregate.Specification;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * AdminUser规格约束
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/14
 */
@Aggregate(aggregate = "AdminUser", name = "AdminUserSpecification", type = Aggregate.TYPE_SPECIFICATION, description = "")
@Service
public class AdminUserSpecification implements Specification<AdminUser> {
    @Override
    public Result specify(AdminUser entity) {
        return Result.pass();
    }
}
