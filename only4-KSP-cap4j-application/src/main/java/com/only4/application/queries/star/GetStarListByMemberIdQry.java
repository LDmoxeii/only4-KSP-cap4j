package com.only4.application.queries.star;

import com.only4.domain.aggregates.star.Star;
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
 * @date 2025/01/19
 */
public class GetStarListByMemberIdQry {
    /**
     * GetByMemberIdQry查询请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        String memberId;
    }

    /**
     * GetByMemberIdQry查询响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        List<Star> stars;
    }
}