package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.admin_user.GetAdminUserByIdQryRequest;
import com.only4.application.queries.admin_user.GetAdminUserByIdQryResponse;
import com.only4.domain.aggregates.admin_user.AdminUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * GetAdminUserByIdQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/14
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetAdminUserByIdQryHandler implements Query<GetAdminUserByIdQryRequest, GetAdminUserByIdQryResponse> {
    private final AdminUserMapper adminUserMapper;
    @Override
    @Cacheable(cacheNames = "adminUserCache", key = "#request.id", condition = "#request.id != null")
    public GetAdminUserByIdQryResponse exec(GetAdminUserByIdQryRequest request) {
        AdminUser adminUser = adminUserMapper.getById(request.getId());
        // mybatis / jpa 哪个顺手就用哪个吧！
        return GetAdminUserByIdQryResponse.builder()
            .adminUser(adminUser)
            .build();
    }
}
