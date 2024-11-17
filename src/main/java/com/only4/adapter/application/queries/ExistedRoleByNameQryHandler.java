package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.RoleMapper;
import com.only4.application.queries.role.ExistedRoleByNameQryRequest;
import com.only4.application.queries.role.ExistedRoleByNameQryResponse;
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
public class ExistedRoleByNameQryHandler implements Query<ExistedRoleByNameQryRequest, ExistedRoleByNameQryResponse> {
    private final RoleMapper roleMapper;

    @Override
    public ExistedRoleByNameQryResponse exec(ExistedRoleByNameQryRequest request) {
        Long existed = roleMapper.existByName(request.getName());
        // mybatis / jpa 哪个顺手就用哪个吧！
        return ExistedRoleByNameQryResponse.builder()
                .existed(existed != 0L)
                .build();
    }
}
