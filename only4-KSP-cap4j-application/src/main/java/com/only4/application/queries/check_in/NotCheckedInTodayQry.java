package com.only4.application.queries.check_in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * 判断今天是否已签到
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/20
 */
public class NotCheckedInTodayQry {
    /**
     * NotCheckedInTodayQry查询请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        Long memberId;
    }

    /**
     * NotCheckedInTodayQry查询响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean exists;
    }
}
