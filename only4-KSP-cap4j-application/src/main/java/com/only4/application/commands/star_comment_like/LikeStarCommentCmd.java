package com.only4.application.commands.star_comment_like;


import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.star_comment_like.StarCommentLike;
import com.only4.domain.aggregates.star_comment_like.factory.StarCommentLikeFactory;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 点赞星球评论
 *
 * @author cap4j-ddd-codegen
 * @date 2025/03/08
 */
public class LikeStarCommentCmd {

    /**
     * LikeStarCommentCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            StarCommentLike like = Optional.of(Mediator.factories()
                    .create(StarCommentLikeFactory.Payload.builder()
                            .starId(cmd.getStarId())
                            .starCommentId(cmd.getStarCommentId())
                            .build())).orElseThrow( () -> new KnownException("点赞失败"));

            like.like();
            Mediator.uow().persist(like);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * LikeStarCommentCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        @Positive
        Long starId;
        @Positive
        Long starCommentId;

    }

    /**
     * LikeStarCommentCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}