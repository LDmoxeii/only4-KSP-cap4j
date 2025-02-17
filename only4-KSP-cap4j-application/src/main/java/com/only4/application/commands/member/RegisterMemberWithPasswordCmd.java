package com.only4.application.commands.member;


import com.only4.application.validater.member.MemberUniqueName;
import com.only4.domain.aggregates.member.factory.MemberFactory;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.util.Optional;

/**
 * RegisterMemberWithPasswordCmd命令
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/16
 */
public class RegisterMemberWithPasswordCmd {

    /**
     * RegisterMemberWithPasswordCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            return Optional.ofNullable(Mediator.factories().create(
                    MemberFactory.Payload.builder()
                            .name(cmd.getMemberName())
                            .password(cmd.getPassword())
                            .build()
            )).map(member -> {
                member.registerWithPassword();
                Mediator.uow().persist(member);

                Mediator.uow().save();

                return Response.builder()
                        .success(true)
                        .build();
            }).orElseThrow(RuntimeException::new);

        }
    }

    /**
     * RegisterMemberWithPasswordCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        @NotEmpty
        @MemberUniqueName
        String memberName;

        @NotEmpty
        String password;
    }

    /**
     * RegisterMemberWithPasswordCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
