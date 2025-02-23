package com.only4.application.commands.category;


import com.only4.domain.aggregates.category.meta.CategorySchema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 批量更新分类引用数
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/22
 */
public class UpdateCategoryRefCountBatchCmd {

    /**
     * UpdateCategoryRefCountBatchCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            Mediator.repositories()
                    .find(CategorySchema.predicateByIds(cmd.getCategoryIds()))
                    .forEach(category -> {
                        category.updateRefCount(cmd.getRefCount());
                        Mediator.uow().persist(category);
                    });

            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * UpdateCategoryRefCountBatchCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        @NotEmpty
        List<Long> categoryIds;

        @NotNull
        Integer refCount;
    }

    /**
     * UpdateCategoryRefCountBatchCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
