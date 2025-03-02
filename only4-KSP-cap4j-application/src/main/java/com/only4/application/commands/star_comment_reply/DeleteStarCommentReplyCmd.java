package com.only4.application.commands.star_comment_reply;


import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.star_comment_reply.StarCommentReply;
import com.only4.domain.aggregates.star_comment_reply.meta.StarCommentReplySchema;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

/**
 * 删除星球评论回复
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/23
 */
public class DeleteStarCommentReplyCmd {

    /**
     * DeleteStarCommentReplyCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            StarCommentReply reply = Mediator.repositories()
                .findOne(StarCommentReplySchema.predicateById(cmd.getStarCommentReplyId()))
                .orElseThrow(() -> new KnownException("评论回复不存在"));

            reply.delete();
            Mediator.uow().remove(reply);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * DeleteStarCommentReplyCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        @Positive
        Long starCommentReplyId;
    }

    /**
     * DeleteStarCommentReplyCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}