package com.only4.application.commands.star_comment_reply;


import com.only4.application.validater.MemberExists;
import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.star_comment_reply.StarCommentReply;
import com.only4.domain.aggregates.star_comment_reply.factory.StarCommentReplyFactory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 创建星球评论回复
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/23
 */
public class CreateStarCommentReplyCmd {

    /**
     * CreateStarCommentReplyCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            StarCommentReply reply = Optional.ofNullable(Mediator.factories()
                .create(StarCommentReplyFactory.Payload.builder()
                    .starCommentId(cmd.getStarCommentId())
                    .memberId(cmd.getMemberId())
                    .memberName(cmd.getMemberName())
                    .content(cmd.getContent())
                    .build())).orElseThrow(() -> new KnownException("星球评论回复创建失败"));

            reply.create();
            Mediator.uow().persist(reply);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * CreateStarCommentReplyCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        @Positive
        //TODO: @StarCommentExists
        Long starCommentId;

        @Positive
        @MemberExists
        Long memberId;

        @NotBlank(message = "评论人名称不能为空")
        String memberName;

        @NotBlank(message = "评论内容不能为空")
        String content;
    }

    /**
     * CreateStarCommentReplyCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
