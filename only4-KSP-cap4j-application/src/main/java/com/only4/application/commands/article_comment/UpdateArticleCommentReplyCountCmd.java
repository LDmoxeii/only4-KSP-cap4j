package com.only4.application.commands.article_comment;


import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.article_comment.ArticleComment;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * 更新文章评论回复数
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
public class UpdateArticleCommentReplyCountCmd {

    /**
     * UpdateArticleCommentReplyCountCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            ArticleComment comment = Mediator.repositories()
                    .findOne(JpaPredicate.byId(ArticleComment.class, cmd.getCommentId()))
                    .orElseThrow(() -> new KnownException("评论不存在"));

            comment.updateReplyCount(cmd.getReplyCount());
            Mediator.uow().persist(comment);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * UpdateArticleCommentReplyCountCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        Long commentId;

        @NotNull
        Integer replyCount;
    }

    /**
     * UpdateArticleCommentReplyCountCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
