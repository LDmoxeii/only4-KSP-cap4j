package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.RoleMapper;
import com.only4.application.queries.role.GetRoleByNameQryRequest;
import com.only4.application.queries.role.GetRoleByNameQryResponse;
import com.only4.domain.aggregates.role.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * GetRoleByNameQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetRoleByNameQryHandler implements Query<GetRoleByNameQryRequest, GetRoleByNameQryResponse> {
    private final RoleMapper roleMapper;

    @Override
    public GetRoleByNameQryResponse exec(GetRoleByNameQryRequest request) {
        Role role = roleMapper.getByName(request.getRoleName());
        // mybatis / jpa 哪个顺手就用哪个吧！
        return GetRoleByNameQryResponse.builder()
                .role(role)
                .build();
    }
}
