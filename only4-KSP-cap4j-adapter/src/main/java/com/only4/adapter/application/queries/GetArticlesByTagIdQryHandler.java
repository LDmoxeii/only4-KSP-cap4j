package com.only4.adapter.application.queries;

import com.only4.application.queries.article.GetArticlesByTagIdQry;
import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.article.meta.ArticleSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GetArticlesByTagIdQry查询请求适配实现
 * 根据标签ID获取文章
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/21
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetArticlesByTagIdQryHandler implements Query<GetArticlesByTagIdQry.Request, GetArticlesByTagIdQry.Response> {

    @Override
    public GetArticlesByTagIdQry.Response exec(GetArticlesByTagIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        return GetArticlesByTagIdQry.Response.builder()
                .articles(byJpa(request.getTagId()))
                .build();
    }

    public List<Article> byJpa(Long tagId) {
        return Mediator.repositories()
                .find(JpaPredicate.bySpecification(Article.class,
                        ArticleSchema.specify(schema ->
                                schema.joinArticleTag(Schema.JoinType.LEFT)
                                        .tagId().equal(tagId))
                ));
    }
}
