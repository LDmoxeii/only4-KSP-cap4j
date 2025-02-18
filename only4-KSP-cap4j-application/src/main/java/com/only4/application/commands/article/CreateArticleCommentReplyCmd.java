package com.only4.application.commands.article;


import com.only4._share.exception.KnownException;
import com.only4.application.validater.MemberExists;
import com.only4.domain.aggregates.article.Article;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

/**
 * 创建文章评论回复
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/18
 */
public class CreateArticleCommentReplyCmd {

    /**
     * CreateArticleCommentReplyCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            Article article = Mediator.repositories()
                    .findOne(JpaPredicate.byId(Article.class, cmd.getArticleId()))
                    .orElseThrow(() -> new KnownException("文章不存在"));

            article.createCommentReply(
                    cmd.getCommentId(),
                    cmd.getMemberId(),
                    cmd.getMemberName(),
                    cmd.getContent()
            );
            Mediator.uow().persist(article);
            Mediator.uow().save();

            return CreateArticleCommentReplyCmd.Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * CreateArticleCommentReplyCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        Long articleId;

        @Positive(message = "父评论ID参数异常")
        Long commentId;

        @MemberExists
        Long memberId;

        @NotEmpty(message = "评论人名称不能为空")
        String memberName;

        @NotEmpty(message = "评论内容不能为空")
        String content;
    }

    /**
     * CreateArticleCommentReplyCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
