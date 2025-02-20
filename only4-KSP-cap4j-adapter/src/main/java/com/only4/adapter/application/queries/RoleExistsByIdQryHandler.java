package com.only4.adapter.application.queries;

import com.only4.application.queries.role.RoleExistsByIdQry;
import com.only4.domain.aggregates.role.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * ExistsByIdQry查询请求适配实现
 * 根据角色ID判断角色是否存在
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/20
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RoleExistsByIdQryHandler implements Query<RoleExistsByIdQry.Request, RoleExistsByIdQry.Response> {

    @Override
    public RoleExistsByIdQry.Response exec(RoleExistsByIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！

        return RoleExistsByIdQry.Response.builder()
                .exists(byJpa(request.getRoleId()))
                .build();
    }

    public boolean byJpa(Long roleId) {
        return Mediator.repositories()
                .exists(JpaPredicate.byId(Role.class, roleId));
    }
}
