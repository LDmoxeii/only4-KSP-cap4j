package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.AdminUserMapper;
import com.only4.application.queries.admin_user.GetAdminUsersByConditionQry;
import com.only4.domain.aggregates.admin_user.AdminUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GetAdminUsersByConditionQry查询请求适配实现
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/14
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetAdminUsersByConditionQryHandler implements Query<GetAdminUsersByConditionQry.Request, GetAdminUsersByConditionQry.Response> {
    private final AdminUserMapper adminUserMapper;
    @Override
    public GetAdminUsersByConditionQry.Response exec(GetAdminUsersByConditionQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        return GetAdminUsersByConditionQry.Response.builder()
            .adminUsers(byMybatis(request.getName(), request.getPhone()))
            .build();
    }

    public List<AdminUser> byMybatis(String name, String phone) {
        return adminUserMapper.getByCondition(name, phone);
    }
}
