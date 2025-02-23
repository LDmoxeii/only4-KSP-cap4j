package com.only4.application.commands.member;


import com.only4.domain.aggregates.member.meta.MemberSchema;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

/**
 * 批量更新用户作品数
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/22
 */
public class UpdateMemberWorkCountBatchCmd {

    /**
     * UpdateMemberWorkCountBatchCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            Mediator.repositories()
                    .find(MemberSchema.predicateByIds(cmd.getMemberIds()))
                    .forEach(member -> {
                        member.updateWorkCount(cmd.getWorkCount());
                        Mediator.uow().persist(member);
                    });

            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * UpdateMemberWorkCountBatchCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        Iterable<Long> memberIds;

        @NotNull
        Integer workCount;
    }

    /**
     * UpdateMemberWorkCountBatchCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
