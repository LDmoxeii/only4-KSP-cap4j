package com.only4.application.commands.star;


import com.only4.application.validater.RoleUniqueName;
import com.only4.domain.aggregates.star.Star;
import com.only4.domain.aggregates.star.factory.StarFactory;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

/**
 * 创建星球
 *
 * @author cap4j-ddd-codegen
 * @date 2025/03/04
 */
public class CreateStarCmd {

    /**
     * CreateStarCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            Star star = Mediator.factories().create(
                    StarFactory.Payload.builder()
                            .name(cmd.name)
                            .description(cmd.description)
                            .amount(cmd.amount)
                            .build()
            );
            star.create();
            Mediator.uow().persist(star);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * CreateStarCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        @NotBlank(message = "星球名不能为空")
        String name;

        @NotBlank(message = "星球描述不能为空")
        String description;

        @NotBlank(message = "星球价格不能为空")
        Integer amount;
    }

    /**
     * CreateStarCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}