package com.only4.adapter.application.queries;

import com.only4.application.queries.article.GetArticlesByMemberIdQry;
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
 * GetArticlesByMemberIdQry查询请求适配实现
 * 根据会员ID获取文章
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/21
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetArticlesByMemberIdQryHandler implements Query<GetArticlesByMemberIdQry.Request, GetArticlesByMemberIdQry.Response> {

    @Override
    public GetArticlesByMemberIdQry.Response exec(GetArticlesByMemberIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        return GetArticlesByMemberIdQry.Response.builder()
                .articles(byJpa(request.getMemberId()))
                .build();
    }

    private List<Article> byJpa(Long memberId) {
        return Mediator.repositories()
                .find(JpaPredicate.bySpecification(Article.class,
                        ArticleSchema.specify(schema ->
                                schema.joinArticleAuthor(Schema.JoinType.LEFT)
                                        .id().equal(memberId))
                ));
    }
}
