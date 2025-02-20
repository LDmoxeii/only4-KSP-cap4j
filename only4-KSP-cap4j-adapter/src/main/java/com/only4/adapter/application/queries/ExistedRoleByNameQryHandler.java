package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.RoleMapper;
import com.only4.application.queries.role.RoleExistsByNameQry;
import com.only4.domain.aggregates.role.Role;
import com.only4.domain.aggregates.role.meta.RoleSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * ExistedRoleByNameQry查询请求适配实现
 * 根据名称查询角色是否存在
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExistedRoleByNameQryHandler implements Query<RoleExistsByNameQry.Request, RoleExistsByNameQry.Response> {
    private final RoleMapper roleMapper;

    @Override
    public RoleExistsByNameQry.Response exec(RoleExistsByNameQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        return RoleExistsByNameQry.Response.builder()
                .exists(byJpa(request.getName()))
                .build();
    }

    public boolean byMapper(String name) {
        return roleMapper.existByName(name) != 0L;
    }

    public boolean byJpa(String name) {
        return Mediator.repositories()
                .exists(JpaPredicate.bySpecification(Role.class,
                        RoleSchema.specify(schema ->
                                schema.name().equal(name))
                ));
    }
}
