package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.identity.GetAdminUserByRoleIdQryRequest;
import com.only4.application.queries.identity.GetAdminUserByRoleIdQryResponse;
import com.only4.domain.aggregates.admin_user.AdminUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GetAdminUserByRoleIdQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetAdminUserByRoleIdQryHandler implements Query<GetAdminUserByRoleIdQryRequest, GetAdminUserByRoleIdQryResponse> {
    private final AdminUserMapper adminUserMapper;

    @Override
    public GetAdminUserByRoleIdQryResponse exec(GetAdminUserByRoleIdQryRequest request) {
        List<AdminUser> adminUsers = adminUserMapper.getByRoleId(request.getId());
        // mybatis / jpa 哪个顺手就用哪个吧！
        return GetAdminUserByRoleIdQryResponse.builder()
                .adminUsers(adminUsers)
                .build();
    }
}
