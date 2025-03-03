package com.only4.application.commands.star_comment;


import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.star_comment.StarComment;
import com.only4.domain.aggregates.star_comment.meta.StarCommentSchema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

/**
 * 更新星球回复数
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/23
 */
public class UpdateStarCommentReplyCountCmd {

    /**
     * UpdateStarCommentReplyCountCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            StarComment comment = Mediator.repositories()
                    .findOne(StarCommentSchema.predicateById(cmd.getStarCommentId()))
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
     * UpdateStarCommentReplyCountCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        @Positive
        Long starCommentId;

        @NotNull
        Integer replyCount;

    }

    /**
     * UpdateStarCommentReplyCountCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
