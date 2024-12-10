package com.only4.application.queries.admin_user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
public class ExistedAdminUserByNameQry {
    /**
     * ExistedAdminUserByNameQry查询请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        String name;
    }

    /**
     * ExistedAdminUserByNameQry查询响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        Boolean existed;
    }
}
