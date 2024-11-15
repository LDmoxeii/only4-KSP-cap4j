package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.identity.GetAdminUsersByConditionQryRequest;
import com.only4.application.queries.identity.GetAdminUsersByConditionQryResponse;
import com.only4.domain.aggregates.admin_user.AdminUser;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * GetAdminUsersByConditionQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/14
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetAdminUsersByConditionQryHandler implements Query<GetAdminUsersByConditionQryRequest, GetAdminUsersByConditionQryResponse> {
    private final AdminUserMapper adminUserMapper;
    @Override
    public GetAdminUsersByConditionQryResponse exec(GetAdminUsersByConditionQryRequest request) {
        List<AdminUser> adminUsers = adminUserMapper.getByCondition(request.getName(), request.getPhone());
        // mybatis / jpa 哪个顺手就用哪个吧！
        return GetAdminUsersByConditionQryResponse.builder()
            .adminUsers(adminUsers)
            .build();
    }
}
