package com.only4.application.queries.role;

import com.only4.domain.aggregates.role.Role;
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
public class GetAllRolesQry {
    /**
     * GetAllRolesQry查询请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        String param;
    }

    /**
     * GetAllRolesQry查询响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        List<Role> roles;
    }
}
