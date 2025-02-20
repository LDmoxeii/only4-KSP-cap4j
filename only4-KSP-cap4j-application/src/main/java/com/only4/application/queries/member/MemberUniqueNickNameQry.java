package com.only4.application.queries.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * 判断是否有同名用户
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/20
 */
public class MemberUniqueNickNameQry {
    /**
     * MemberUniqueNickNameQry查询请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        String memberNickName;
    }

    /**
     * MemberUniqueNickNameQry查询响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean exists;
    }
}
