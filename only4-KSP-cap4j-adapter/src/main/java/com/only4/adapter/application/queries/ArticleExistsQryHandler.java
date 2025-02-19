package com.only4.adapter.application.queries;

import com.only4.application.queries.article.ArticleExistsQry;
import com.only4.domain.aggregates.article.Article;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * ArticleExistsQry查询请求适配实现
 * 判断文章是否存在
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ArticleExistsQryHandler implements Query<ArticleExistsQry.Request, ArticleExistsQry.Response> {

    @Override
    public ArticleExistsQry.Response exec(ArticleExistsQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        val result = Mediator.repositories().exists(JpaPredicate.byId(Article.class, request.getArticleId()));
        return ArticleExistsQry.Response.builder()
                .exists(result)
                .build();
    }
}
