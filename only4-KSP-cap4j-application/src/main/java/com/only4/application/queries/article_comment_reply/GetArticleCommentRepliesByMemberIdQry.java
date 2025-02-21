package com.only4.application.queries.article_comment_reply;

import com.only4.domain.aggregates.article_comment_reply.ArticleCommentReply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

import java.util.List;

/**
 * 根据会员ID获取文章评论回复
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/21
 */
public class GetArticleCommentRepliesByMemberIdQry {
    /**
     * GetArticleCommentRepliesByMemberIdQry查询请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        Long memberId;
    }

    /**
     * GetArticleCommentRepliesByMemberIdQry查询响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        List<ArticleCommentReply> replies;
    }
}
