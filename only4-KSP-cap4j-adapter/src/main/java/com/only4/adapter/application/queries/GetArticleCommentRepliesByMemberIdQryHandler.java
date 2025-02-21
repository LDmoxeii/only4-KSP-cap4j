package com.only4.adapter.application.queries;

import com.only4.application.queries.article_comment_reply.GetArticleCommentRepliesByMemberIdQry;
import com.only4.domain.aggregates.article_comment_reply.ArticleCommentReply;
import com.only4.domain.aggregates.article_comment_reply.meta.ArticleCommentReplySchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GetArticleCommentRepliesByMemberIdQry查询请求适配实现
 * 根据会员ID获取文章评论回复
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/21
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetArticleCommentRepliesByMemberIdQryHandler implements Query<GetArticleCommentRepliesByMemberIdQry.Request, GetArticleCommentRepliesByMemberIdQry.Response> {

    @Override
    public GetArticleCommentRepliesByMemberIdQry.Response exec(GetArticleCommentRepliesByMemberIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        return GetArticleCommentRepliesByMemberIdQry.Response.builder()
                .replies(byJpa(request.getMemberId()))
                .build();
    }

    List<ArticleCommentReply> byJpa(Long memberId) {
        return Mediator.repositories()
                .find(JpaPredicate.bySpecification(ArticleCommentReply.class,
                        ArticleCommentReplySchema.specify(schema ->
                                schema.authorId().equal(memberId))
                ));
    }
}
