package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.ArticleMapper;
import com.only4.application.queries.Article.GetArticleByIdQry;
import com.only4.domain.aggregates.article.Article;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * GetArticleByIdQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/22
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetArticleByIdQryHandler implements Query<GetArticleByIdQry.Request, GetArticleByIdQry.Response> {
    private final ArticleMapper articleMapper;
    @Override
    public GetArticleByIdQry.Response exec(GetArticleByIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Article article = articleMapper.getById(request.getId());
        return GetArticleByIdQry.Response.builder()
                .article(article)
                .build();
    }
}