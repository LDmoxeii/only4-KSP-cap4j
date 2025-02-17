package com.only4.application.commands.article;


import com.only4.domain.aggregates.article.Article;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

/**
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/14
 */
public class CreateArticleCommentCmd {

    /**
     * CreateArticleCommentCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            return Mediator.repositories()
                    .findOne(JpaPredicate.byId(Article.class, cmd.getArticleId()))
                    .map(article -> {
                        article.createComment(
                                cmd.getParentId(),
                                cmd.getMemberId(),
                                cmd.getMemberName(),
                                cmd.getContent()
                        );
                        Mediator.uow().persist(article);

                        Mediator.uow().save();

                        return Response.builder()
                                .success(true)
                                .build();
                    }).orElseThrow(RuntimeException::new);
        }
    }

    /**
     * CreateArticleCommentCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        Long articleId;

        @PositiveOrZero(message = "父评论ID参数异常")
        //TODO: 编写@CommentExists
        Long parentId;

        //TODO: 编写@MemberExists
        Long memberId;

        @NotEmpty(message = "评论人名称不能为空")
        String memberName;

        @NotEmpty(message = "评论内容不能为空")
        String content;

    }

    /**
     * CreateArticleCommentCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
