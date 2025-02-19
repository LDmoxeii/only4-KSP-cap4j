package com.only4.application.commands.article_like;


import com.only4.application.validater.ArticleExists;
import com.only4.application.validater.MemberExists;
import com.only4.domain.aggregates.article_like.ArticleLike;
import com.only4.domain.aggregates.article_like.factory.ArticleLikeFactory;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 点赞文章
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
public class LikeArticleCmd {

    /**
     * LikeArticleCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            ArticleLike like = Optional.ofNullable(Mediator.factories()
                            .create(ArticleLikeFactory.Payload.builder()
                                    .memberId(cmd.getMemberId())
                                    .articleId(cmd.getArticleId())
                                    .build()))
                    .orElseThrow(() -> new RuntimeException("点赞失败"));

            like.create();
            Mediator.uow().persist(like);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * LikeArticleCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        @MemberExists
        Long memberId;

        @ArticleExists
        Long articleId;
    }

    /**
     * LikeArticleCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
