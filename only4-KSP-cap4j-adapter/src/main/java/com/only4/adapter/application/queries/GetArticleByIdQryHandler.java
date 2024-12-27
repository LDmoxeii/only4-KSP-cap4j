package com.only4.adapter.application.queries;

import com.only4.application.queries.article.GetArticleByIdQry;
import com.only4.domain.aggregates.article.Article;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
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
    @Override
    public GetArticleByIdQry.Response exec(GetArticleByIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        val article = Mediator.repositories().findOne(JpaPredicate.byId(
                Article.class,
                request.getId()
        ));
        return GetArticleByIdQry.Response.builder()
                .article(article.get())
                .build();
    }
}