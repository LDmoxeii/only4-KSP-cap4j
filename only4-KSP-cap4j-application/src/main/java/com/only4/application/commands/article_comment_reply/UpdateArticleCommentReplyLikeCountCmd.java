package com.only4.application.commands.article_comment_reply;


import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.article_comment_reply.ArticleCommentReply;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * 更新文章评论回复点赞数
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
public class UpdateArticleCommentReplyLikeCountCmd {

    /**
     * UpdateArticleCommentReplyLikeCountCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            ArticleCommentReply reply = Mediator.repositories()
                    .findOne(JpaPredicate.byId(ArticleCommentReply.class, cmd.getReplyId()))
                    .orElseThrow(() -> new KnownException("回复不存在"));

            reply.updateLikeCount(cmd.getLikeCount());
            Mediator.uow().persist(reply);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * UpdateArticleCommentReplyLikeCountCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        Long replyId;

        @NotNull
        Integer likeCount;
    }

    /**
     * UpdateArticleCommentReplyLikeCountCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
