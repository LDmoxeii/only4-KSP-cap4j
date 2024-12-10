package com.only4.application.queries.admin_user;

import com.only4.domain.aggregates.admin_user.AdminUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

import java.util.List;

/**
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
public class GetAdminUserByRoleIdQry {
    /**
     * GetAdminUserByRoleIdQry查询请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        Long id;
    }

    /**
     * GetAdminUserByRoleIdQry查询响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        List<AdminUser> adminUsers;
    }
}
