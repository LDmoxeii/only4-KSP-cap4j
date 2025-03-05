package com.only4.application.commands.article_comment;


import com.only4.application.validater.MemberExists;
import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.article_comment.factory.ArticleCommentFactory;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 创建文章评论
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
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
            val comment = Optional.ofNullable(Mediator.factories().create(ArticleCommentFactory.Payload.builder()
                    .memberId(cmd.getMemberId())
                    .memberName(cmd.getMemberName())
                    .content(cmd.getContent())
                    .build())).orElseThrow(() -> new KnownException("评论创建失败"));

            comment.create();
            Mediator.uow().persist(comment);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
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
        @MemberExists
        Long memberId;

        @NotBlank(message = "评论人名称不能为空")
        String memberName;

        @NotBlank(message = "评论内容不能为空")
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
