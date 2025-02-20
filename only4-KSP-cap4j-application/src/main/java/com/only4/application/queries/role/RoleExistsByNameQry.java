package com.only4.application.queries.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * 根据名称判断角色是否存在
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
public class RoleExistsByNameQry {
    /**
     * ExistedRoleByNameQry查询请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        String name;
    }

    /**
     * ExistedRoleByNameQry查询响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean exists;
    }
}
