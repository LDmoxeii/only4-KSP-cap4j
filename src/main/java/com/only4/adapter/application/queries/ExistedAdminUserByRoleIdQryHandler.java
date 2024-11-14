package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.identity.ExistedAdminUserByRoleIdQryRequest;
import com.only4.application.queries.identity.ExistedAdminUserByRoleIdQryResponse;
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
public class ExistedAdminUserByRoleIdQryHandler implements Query<ExistedAdminUserByRoleIdQryRequest, ExistedAdminUserByRoleIdQryResponse> {
    private final AdminUserMapper adminUserMapper;

    @Override
    public ExistedAdminUserByRoleIdQryResponse exec(ExistedAdminUserByRoleIdQryRequest request) {
        Long existed = adminUserMapper.existedByRoleId();
        // mybatis / jpa 哪个顺手就用哪个吧！
        return ExistedAdminUserByRoleIdQryResponse.builder()
                .existed(existed != 0L)
                .build();
    }
}
