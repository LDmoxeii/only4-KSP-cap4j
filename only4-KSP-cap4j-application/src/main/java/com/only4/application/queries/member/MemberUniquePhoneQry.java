package com.only4.application.queries.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * 判断手机号是否已绑定用户
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/20
 */
public class MemberUniquePhoneQry {
    /**
     * MemberUniquePhoneQry查询请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        String memberPhone;
    }

    /**
     * MemberUniquePhoneQry查询响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean exists;
    }
}
