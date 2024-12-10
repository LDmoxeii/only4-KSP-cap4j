package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.RoleMapper;
import com.only4.application.queries.role.ExistedRoleByNameQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * ExistedRoleByNameQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExistedRoleByNameQryHandler implements Query<ExistedRoleByNameQry.Request, ExistedRoleByNameQry.Response> {
    private final RoleMapper roleMapper;

    @Override
    public ExistedRoleByNameQry.Response exec(ExistedRoleByNameQry.Request request) {
        Long existed = roleMapper.existByName(request.getName());
        // mybatis / jpa 哪个顺手就用哪个吧！
        return ExistedRoleByNameQry.Response.builder()
                .existed(existed != 0L)
                .build();
    }
}
