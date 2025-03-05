package com.only4.application.commands.check_in;


import com.only4.application.validater.MemberExists;
import com.only4.application.validater.NotCheckedInToday;
import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.check_in.CheckIn;
import com.only4.domain.aggregates.check_in.factory.CheckInFactory;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 签到
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
public class CheckInCmd {

    /**
     * CheckInCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            CheckIn checkIn = Optional.of(Mediator.factories()
                    .create(CheckInFactory.Payload.builder()
                            .memberId(cmd.getMemberId())
                            .build()))
                    .orElseThrow(() -> new KnownException("签到失败"));

            checkIn.create();
            Mediator.uow().persist(checkIn);
            Mediator.uow().save();

            return Response.builder().success(true).build();
        }
    }

    /**
     * CheckInCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        @MemberExists
        @NotCheckedInToday
        Long memberId;
    }

    /**
     * CheckInCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
