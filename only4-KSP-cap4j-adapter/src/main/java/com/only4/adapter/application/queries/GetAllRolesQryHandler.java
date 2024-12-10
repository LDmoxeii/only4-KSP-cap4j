package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.RoleMapper;
import com.only4.application.queries.role.GetAllRolesQry;
import com.only4.domain.aggregates.role.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GetAllRolesQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetAllRolesQryHandler implements Query<GetAllRolesQry.Request, GetAllRolesQry.Response> {
    private final RoleMapper roleMapper;

    @Override
    public GetAllRolesQry.Response exec(GetAllRolesQry.Request request) {
        List<Role> roles = roleMapper.getAll();

        return GetAllRolesQry.Response.builder()
                .roles(roles)
                .build();
        // mybatis / jpa 哪个顺手就用哪个吧！
    }
}