package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.RoleMapper;
import com.only4.application.queries.role.GetRolesByConditionQry;
import com.only4.domain.aggregates.role.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GetRolesByConditionQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetRolesByConditionQryHandler implements Query<GetRolesByConditionQry.Request, GetRolesByConditionQry.Response> {
    private final RoleMapper roleMapper;

    @Override
    public GetRolesByConditionQry.Response exec(GetRolesByConditionQry.Request request) {
        List<Role> role = roleMapper.getByCondition(request.getName(), request.getDescription());
        return GetRolesByConditionQry.Response.builder()
                .roles(role)
                .build();
        // mybatis / jpa 哪个顺手就用哪个吧！
    }
}
