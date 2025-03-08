package com.only4.application.commands.member;


import com.only4.application.validater.MemberUniquePhone;
import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.member.Member;
import com.only4.domain.aggregates.member.factory.MemberFactory;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * RegisterMemberWithPhoneCmd命令
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/16
 */
public class RegisterMemberWithPhoneCmd {

    /**
     * RegisterMemberWithPhoneCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            Member member = Optional.ofNullable(Mediator.factories().create(
                    MemberFactory.Payload.builder()
                            .name(cmd.getPhone())
                            .password("223344")
                            .phone(cmd.getPhone())
                            .build()
            )).orElseThrow(() -> new KnownException("用户创建失败"));

            member.registerWithPhone();
            Mediator.uow().persist(member);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }

    }

    /**
     * RegisterMemberWithPhoneCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        @MemberUniquePhone
        String phone;
    }

    /**
     * RegisterMemberWithPhoneCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
