package com.only4.application.commands.member;


import com.only4.application.validater.member.MemberExists;
import com.only4.application.validater.member.MemberUniqueNickName;
import com.only4.domain.aggregates.member.Member;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;

/**
 * UpdateMemberInfoCmd命令
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/16
 */
public class UpdateMemberInfoCmd {

    /**
     * UpdateMemberInfoCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            return Mediator.repositories()
                    .findOne(JpaPredicate.byId(Member.class, cmd.getMemberId()))
                    .map(member -> {
                        member.updateInfo(cmd.getNickName(), cmd.getSignature());

                        Mediator.uow().persist(member);

                        Mediator.uow().save();

                        return Response.builder()
                                .success(true)
                                .build();
                    }).orElseThrow(RuntimeException::new);

        }
    }

    /**
     * UpdateMemberInfoCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        @MemberExists
        Long memberId;

        @NotEmpty
        @MemberUniqueNickName
        String nickName;

        @NotEmpty
        String signature;
    }

    /**
     * UpdateMemberInfoCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
