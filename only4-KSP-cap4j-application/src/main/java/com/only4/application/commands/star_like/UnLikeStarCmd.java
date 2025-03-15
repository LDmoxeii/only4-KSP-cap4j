package com.only4.application.commands.star_like;


import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.star_like.StarLike;
import com.only4.domain.aggregates.star_like.meta.StarLikeSchema;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

/**
 * 取消点赞星球
 *
 * @author cap4j-ddd-codegen
 * @date 2025/03/11
 */
public class UnLikeStarCmd {

    /**
     * UnLikeStarCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            StarLike unlike = Mediator.repositories()
                    .findOne(StarLikeSchema.predicateById(cmd.getStarId()))
                    .orElseThrow(() -> new KnownException("找不到该点赞"));


            unlike.unlike();
            Mediator.uow().persist(unlike);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * UnLikeStarCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        @Positive
        Integer userId;
        @Positive
        Integer starId;
    }

    /**
     * UnLikeStarCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}