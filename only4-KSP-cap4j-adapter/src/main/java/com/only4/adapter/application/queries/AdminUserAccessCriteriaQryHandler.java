package com.only4.adapter.application.queries;

import com.only4.application.queries.admin_user.AdminUserAccessCriteriaQry;
import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.meta.AdminUserSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * AdminUserAccessCriteriaQry查询请求适配实现
 * 根据登录要求判断是否存在管理员用户
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/20
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AdminUserAccessCriteriaQryHandler implements Query<AdminUserAccessCriteriaQry.Request, AdminUserAccessCriteriaQry.Response> {

    @Override
    public AdminUserAccessCriteriaQry.Response exec(AdminUserAccessCriteriaQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        return AdminUserAccessCriteriaQry.Response.builder()
                .adminUser(byJpa(request.getAccount(), request.getPassword()))
                .build();
    }

    public AdminUser byJpa(String acount, String password) {
        return Mediator.repositories()
                .findOne(JpaPredicate.bySpecification(AdminUser.class,
                        AdminUserSchema.specify(schema ->
                                schema.all(
                                        schema.name().equal(acount),
                                        schema.password().equal(password)
                                )
                        ))).orElse(null);
    }
}
