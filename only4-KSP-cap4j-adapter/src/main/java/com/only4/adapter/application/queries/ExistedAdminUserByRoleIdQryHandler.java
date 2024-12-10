package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.admin_user.ExistedAdminUserByRoleIdQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * ExistedAdminUserByRoleIdQry查询请求适配实现
 * todo: 查询描述
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
        Long existed = adminUserMapper.existedByRoleId(request.getRoleId());
        // mybatis / jpa 哪个顺手就用哪个吧！
        return ExistedAdminUserByRoleIdQry.Response.builder()
                .existed(existed != 0L)
                .build();
    }
}
