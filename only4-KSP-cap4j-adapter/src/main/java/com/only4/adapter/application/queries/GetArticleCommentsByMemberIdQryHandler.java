package com.only4.adapter.application.queries;

import com.only4.application.queries.article_comment.GetArticleCommentsByMemberIdQry;
import com.only4.domain.aggregates.article_comment.ArticleComment;
import com.only4.domain.aggregates.article_comment.meta.ArticleCommentSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GetArticleCommentsByMemberIdQry查询请求适配实现
 * 根据会员ID获取文章评论
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/21
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetArticleCommentsByMemberIdQryHandler implements Query<GetArticleCommentsByMemberIdQry.Request, GetArticleCommentsByMemberIdQry.Response> {

    @Override
    public GetArticleCommentsByMemberIdQry.Response exec(GetArticleCommentsByMemberIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        return GetArticleCommentsByMemberIdQry.Response.builder()
                .comments(byJpa(request.getMemberId()))
                .build();
    }

    public List<ArticleComment> byJpa(Long memberId) {
        return Mediator.repositories()
                .find(JpaPredicate.bySpecification(ArticleComment.class,
                        ArticleCommentSchema.specify(schema ->
                                schema.authorId().equal(memberId))
                ));
    }
}
