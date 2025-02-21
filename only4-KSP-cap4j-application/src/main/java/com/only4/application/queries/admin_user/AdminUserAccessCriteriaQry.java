package com.only4.application.queries.admin_user;

import com.only4.domain.aggregates.admin_user.AdminUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * 根据登录要求判断是否存在管理员用户
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/20
 */
public class AdminUserAccessCriteriaQry {
    /**
     * AdminUserAccessCriteriaQry查询请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        String account;

        String password;
    }

    /**
     * AdminUserAccessCriteriaQry查询响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        AdminUser adminUser;
    }
}
