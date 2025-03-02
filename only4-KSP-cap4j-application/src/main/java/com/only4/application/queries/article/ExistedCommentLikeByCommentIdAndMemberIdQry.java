package com.only4.application.queries.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/27
 */
public class ExistedCommentLikeByCommentIdAndMemberIdQry {
    /**
     * ExistedCommentLikeByCommentIdAndMemberIdQry查询请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        Long commentId;
        Long memberId;
    }

    /**
     * ExistedCommentLikeByCommentIdAndMemberIdQry查询响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        Boolean existed;
    }
}