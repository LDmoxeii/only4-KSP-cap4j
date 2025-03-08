package com.only4.application.commands.star;


import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.star.Star;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * 更新星球评论数
 *
 * @author cap4j-ddd-codegen
 * @date 2025/03/04
 */
public class UpdateStarCommentCountCmd {

    /**
     * UpdateStarCommentCountCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            Star star = Mediator.repositories()
                    .findOne(JpaPredicate.byId(Star.class, cmd.getStarId()))
                    .orElseThrow(() -> new KnownException("星球不存在, starId=" + cmd.getStarId()));

            star.updateStarCommentCount(cmd.getCommentCount());
            Mediator.uow().persist(star);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * UpdateStarCommentCountCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        @Positive
        long starId;
        @NotNull
        Integer commentCount;
    }

    /**
     * UpdateStarCommentCountCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}