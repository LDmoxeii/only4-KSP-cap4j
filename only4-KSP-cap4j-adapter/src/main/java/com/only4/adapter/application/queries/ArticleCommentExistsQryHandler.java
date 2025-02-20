package com.only4.adapter.application.queries;

import com.only4.application.queries.article_comment.ArticleCommentExistsQry;
import com.only4.domain.aggregates.article_comment.ArticleComment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * ArticleCommentExistsQry查询请求适配实现
 * 判断文章评论是否存在
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/20
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ArticleCommentExistsQryHandler implements Query<ArticleCommentExistsQry.Request, ArticleCommentExistsQry.Response> {

    @Override
    public ArticleCommentExistsQry.Response exec(ArticleCommentExistsQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        return ArticleCommentExistsQry.Response.builder()
                .exists(Mediator.repositories().exists(JpaPredicate.byId(ArticleComment.class,
                        request.getArticleCommentId())
                )).build();
    }
}
