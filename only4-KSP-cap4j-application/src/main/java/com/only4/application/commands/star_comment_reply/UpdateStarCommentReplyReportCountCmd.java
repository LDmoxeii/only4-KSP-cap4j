package com.only4.application.commands.star_comment_reply;


import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.star_comment_reply.StarCommentReply;
import com.only4.domain.aggregates.star_comment_reply.meta.StarCommentReplySchema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

/**
 * 更新星球评论回复举报数
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/23
 */
public class UpdateStarCommentReplyReportCountCmd {

    /**
     * UpdateStarCommentReplyReportCountCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            StarCommentReply reply = Mediator.repositories()
                .findOne(StarCommentReplySchema.predicateById(cmd.getStarCommentReplyId()))
                .orElseThrow(() -> new KnownException("星球评论回复不存在!"));

            reply.updateReportCount(cmd.getReportCount());
            Mediator.uow().persist(reply);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * UpdateStarCommentReplyReportCountCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        @Positive
        Long starCommentReplyId;

        @NotNull
        Integer reportCount;
    }

    /**
     * UpdateStarCommentReplyReportCountCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
