package com.only4.application.queries.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * 判断是否存在同名分类
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/20
 */
public class CategoryUniqueNameQry {
    /**
     * CategoryUniqueNameQry查询请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        String categoryName;
    }

    /**
     * CategoryUniqueNameQry查询响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean exists;
    }
}
