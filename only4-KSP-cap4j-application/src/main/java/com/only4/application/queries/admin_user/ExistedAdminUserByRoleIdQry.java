package com.only4.application.queries.admin_user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * 判断该角色是否关联用户
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
public class ExistedAdminUserByRoleIdQry {
    /**
     * ExistedAdminUserByRoleIdQry查询请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        Long roleId;
    }

    /**
     * ExistedAdminUserByRoleIdQry查询响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        Boolean existed;
    }
}
