package com.only4.domain.aggregates.role.specs;

import com.only4.domain.aggregates.role.Role;
import org.netcorepal.cap4j.ddd.domain.aggregate.Specification;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Role规格约束
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/14
 */
@Aggregate(aggregate = "role", name = "RoleSpecification", type = Aggregate.TYPE_SPECIFICATION, description = "")
@Service
public class RoleSpecification implements Specification<Role> {
    @Override
    public Result specify(Role entity) {
        return Result.pass();
    }
}
