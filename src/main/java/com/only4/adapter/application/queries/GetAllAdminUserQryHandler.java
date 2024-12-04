package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.admin_user.GetAllAdminUserQry;
import com.only4.domain.aggregates.admin_user.AdminUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GetAllAdminUserQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/14
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetAllAdminUserQryHandler implements Query<GetAllAdminUserQry.Request, GetAllAdminUserQry.Response> {
    private final AdminUserMapper adminUserMapper;

    @Override
    public GetAllAdminUserQry.Response exec(GetAllAdminUserQry.Request request) {
        List<AdminUser> adminUsers = adminUserMapper.getAll();
        // mybatis / jpa 哪个顺手就用哪个吧！
        return GetAllAdminUserQry.Response.builder()
            .adminUsers(adminUsers)
            .build();
    }
}
