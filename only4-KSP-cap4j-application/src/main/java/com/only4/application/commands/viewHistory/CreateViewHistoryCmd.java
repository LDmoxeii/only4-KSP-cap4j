package com.only4.application.commands.viewHistory;


import com.only4.application.validater.ArticleExists;
import com.only4.application.validater.MemberExists;
import com.only4.domain.aggregates.view_history.ViewHistory;
import com.only4.domain.aggregates.view_history.factory.ViewHistoryFactory;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 创建浏览记录
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
public class CreateViewHistoryCmd {

    /**
     * CreateViewHistoryCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            ViewHistory viewHistory = Optional.ofNullable(Mediator.factories()
                            .create(ViewHistoryFactory.Payload.builder()
                                    .memberId(cmd.getMemberId())
                                    .articleId(cmd.getArticleId())
                                    .build()))
                    .orElseThrow(() -> new RuntimeException("创建浏览记录失败"));

            viewHistory.create();
            Mediator.uow().persist(viewHistory);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * CreateViewHistoryCmd命令请求参数
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
     * CreateViewHistoryCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
