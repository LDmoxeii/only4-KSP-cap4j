package com.only4.application.queries.article;

import com.only4.domain.aggregates.article.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

import java.util.List;

/**
 * 根据标签ID获取文章
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/21
 */
public class GetArticlesByTagIdQry {
    /**
     * GetArticlesByTagIdQry查询请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        Long tagId;
    }

    /**
     * GetArticlesByTagIdQry查询响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        List<Article> articles;
    }
}
