package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.admin_user.ExistedAdminUserByRoleIdQry;
import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.meta.AdminUserSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * ExistedAdminUserByRoleIdQry查询请求适配实现
 * 判断是否存在指定角色下的用户
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExistedAdminUserByRoleIdQryHandler implements Query<ExistedAdminUserByRoleIdQry.Request, ExistedAdminUserByRoleIdQry.Response> {
    private final AdminUserMapper adminUserMapper;

    @Override
    public ExistedAdminUserByRoleIdQry.Response exec(ExistedAdminUserByRoleIdQry.Request request) {

        // mybatis / jpa 哪个顺手就用哪个吧！
        return ExistedAdminUserByRoleIdQry.Response.builder()
                .existed(byJpa(request.getRoleId()))
                .build();
    }

    public boolean byMybatis(Long roleId) {
        return adminUserMapper.existedByRoleId(roleId) != 0L;
    }

    public boolean byJpa(Long roleId) {
        return Mediator.repositories().exists(JpaPredicate.bySpecification(AdminUser.class,
                AdminUserSchema.specify(schema ->
                        schema.joinAdminUserRole(Schema.JoinType.INNER).roleId().equal(roleId))
        ));
    }
}
