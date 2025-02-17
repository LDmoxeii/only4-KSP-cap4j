package com.only4.application.commands.member;


import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.member.Member;
import com.only4.domain.aggregates.member.enums.RankGetWay;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 计算等级分
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/16
 */
public class CalculateRankCmd {

    /**
     * CalculateRankCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            return Optional.ofNullable(Mediator.repositories()
                            .findOne(JpaPredicate.byId(Member.class, cmd.getMemberId()))
                            .orElseThrow(() -> new KnownException("用户不存在")))
                    .map(member -> {
                        member.calculateRank(cmd.rankGetWay);

                        Mediator.uow().persist(member);

                        Mediator.uow().save();

                        return Response.builder()
                                .success(true)
                                .build();
                    }).orElseThrow(RuntimeException::new);
        }
    }

    /**
     * CalculateRankCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        Long memberId;

        RankGetWay rankGetWay;
    }

    /**
     * CalculateRankCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
