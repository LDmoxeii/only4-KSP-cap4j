package com.only4.application.commands.article_comment;


import com.only4._share.exception.KnownException;
import com.only4.application.validater.ArticleCommentExists;
import com.only4.domain.aggregates.article.meta.ArticleStatisticsSchema;
import com.only4.domain.aggregates.article_comment.ArticleComment;
import com.only4.domain.aggregates.article_comment.meta.ArticleCommentSchema;
import com.only4.domain.aggregates.article_comment.meta.ArticleCommentStatisticsSchema;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * 增加文章评论举报数
 *
 * @author cap4j-ddd-codegen
 * @date 2025/03/03
 */
public class AddArticleCommentReportCountCmd {

    /**
     * AddArticleCommentReportCountCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            ArticleComment comment = Mediator.repositories()
                    .findOne(ArticleCommentSchema.predicateById(cmd.getCommentId()))
                    .orElseThrow(() -> new KnownException("评论不存在"));

            comment.addReportCount(cmd.getReportCount());
            Mediator.uow().persist(comment);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * AddArticleCommentReportCountCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        @Positive
        @ArticleCommentExists
        Long  commentId;

        @Positive
        Integer reportCount;

    }

    /**
     * AddArticleCommentReportCountCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}