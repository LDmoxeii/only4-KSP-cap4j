package com.only4.application.commands.star_like;


import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.star_like.StarLike;
import com.only4.domain.aggregates.star_like.factory.StarLikeFactory;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 点赞星球
 *
 * @author cap4j-ddd-codegen
 * @date 2025/03/11
 */
public class LikeStarCmd {

    /**
     * LikeStarCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            StarLike like = Optional.of(Mediator.factories()
                    .create(StarLikeFactory.Payload.builder()
                            .starId(cmd.getStarId())
                            .userId(cmd.getUserId())
                            .build())).orElseThrow(() -> new KnownException("点赞星球失败"));


            like.like();
            Mediator.uow().persist(like);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * LikeStarCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {


        @Positive
        Long userId;
        @Positive
        //TODO:@StarExists
        Long starId;
    }

    /**
     * LikeStarCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}