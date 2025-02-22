package com.only4.application.queries.tag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * 根据Id判断标签是否存在
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/22
 */
public class TagExistsByIdQry {
    /**
     * TagExistsByIdQry查询请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        Long tagId;
    }

    /**
     * TagExistsByIdQry查询响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean exists;
    }
}
