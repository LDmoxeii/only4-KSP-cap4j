package com.only4.application.commands.category;


import com.only4.application.validater.category.CategoryUniqueName;
import com.only4.domain.aggregates.category.factory.CategoryFactory;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.util.Optional;

/**
 * CreateCategoryCmd命令
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/21
 */
public class CreateCategoryCmd {

    /**
     * CreateCategoryCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            return Optional.ofNullable(Mediator.factories().create(
                    CategoryFactory.Payload.builder()
                            .name(cmd.getCategoryName())
                            .build()
            )).map(category -> {
                category.create();
                Mediator.uow().persist(category);

                Mediator.uow().save();
                return Response.builder()
                        .id(category.getId())
                        .success(true)
                        .build();
            }).orElseThrow(RuntimeException::new);
        }
    }

    /**
     * CreateCategoryCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        @NotEmpty
        @CategoryUniqueName
        String categoryName;
    }

    /**
     * CreateCategoryCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        Long id;
        boolean success;
    }
}
