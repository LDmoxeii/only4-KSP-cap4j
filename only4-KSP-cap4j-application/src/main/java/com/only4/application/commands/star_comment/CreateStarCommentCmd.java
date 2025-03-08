package com.only4.application.commands.star_comment;


import com.only4.application.validater.MemberExists;
import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.star_comment.StarComment;
import com.only4.domain.aggregates.star_comment.factory.StarCommentFactory;
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
 * 创建星球评论
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/23
 */
public class CreateStarCommentCmd {

    /**
     * CreateStarCommentCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            StarComment comment = Optional.of(Mediator.factories()
                    .create(StarCommentFactory.Payload.builder()
                            .starId(cmd.getStarId())
                            .authorId(cmd.getMemberId())
                            .authorName(cmd.getMemberName())
                            .content(cmd.getContent())
                            .build())).orElseThrow(() -> new KnownException("星球评论创建失败"));


            comment.create();
            Mediator.uow().persist(comment);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * CreateStarCommentCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        @Positive
        //TODO: @StarExists
        Long starId;

        @Positive
        @MemberExists
        Long memberId;

        @NotBlank(message = "用户名称不能为空")
        String memberName;

        @NotBlank(message = "评论内容不能为空")
        String content;
    }

    /**
     * CreateStarCommentCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
