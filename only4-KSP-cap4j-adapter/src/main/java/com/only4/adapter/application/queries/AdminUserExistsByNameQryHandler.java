package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.admin_user.AdminUserExistsByNameQry;
import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.meta.AdminUserSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * ExistsAdminUserByNameQry查询请求适配实现
 * 根据用户名判断管理员用户是否存在
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AdminUserExistsByNameQryHandler implements Query<AdminUserExistsByNameQry.Request, AdminUserExistsByNameQry.Response> {

    private final AdminUserMapper adminUserMapper;

    @Override
    public AdminUserExistsByNameQry.Response exec(AdminUserExistsByNameQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        return AdminUserExistsByNameQry.Response.builder()
                .exists(byJpa(request.getName()))
                .build();
    }

    public boolean byMapper(String name) {
        return adminUserMapper.existedByName(name);
    }

    public boolean byJpa(String name) {
        return Mediator.repositories().exists(JpaPredicate.bySpecification(AdminUser.class,
                AdminUserSchema.specify(adminUser ->
                        adminUser.name().eq(name)
                ))
        );
    }
}
