package com.only4.application.commands.member;


import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.member.Member;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * 提升用户等级
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/18
 */
public class UpMemberLevelCmd {

    /**
     * UpMemberLevelCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public UpMemberLevelCmd.Response exec(UpMemberLevelCmd.Request cmd) {
            Member member = Mediator.repositories()
                    .findOne(JpaPredicate.byId(Member.class, cmd.getMemberId()))
                    .orElseThrow(() -> new KnownException("用户不存在"));

            member.upLevel();
            Mediator.uow().persist(member);
            Mediator.uow().save();

            return UpMemberLevelCmd.Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * UpMemberLevelCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        Long memberId;
    }

    /**
     * UpMemberLevelCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
