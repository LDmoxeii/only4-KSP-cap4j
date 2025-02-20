package com.only4.application.queries.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * 判断分类是否存在
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/20
 */
public class CategoryExistsQry {
    /**
     * CategoryExistsQry查询请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        Long categoryId;
    }

    /**
     * CategoryExistsQry查询响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean exists;
    }
}
