package com.only4.adapter.application.queries;

import com.only4.application.queries.article.GetArticlesByCategoryIdQry;
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
 * GetArticlesByCategoryIdQry查询请求适配实现
 * 根据分类ID获取文章
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/21
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetArticlesByCategoryIdQryHandler implements Query<GetArticlesByCategoryIdQry.Request, GetArticlesByCategoryIdQry.Response> {

    @Override
    public GetArticlesByCategoryIdQry.Response exec(GetArticlesByCategoryIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        return GetArticlesByCategoryIdQry.Response.builder()
                .articles(byJpa(request.getCategoryId()))
                .build();
    }

    public List<Article> byJpa(Long categoryId) {
        return Mediator.repositories()
                .find(JpaPredicate.bySpecification(Article.class, ArticleSchema.specify(schema ->
                        schema.joinArticleCategory(Schema.JoinType.LEFT)
                                .id().equal(categoryId))
                ));
    }
}
