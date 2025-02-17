package com.only4.application.commands.category;


import com.only4.application.validater.category.CategoryExists;
import com.only4.application.validater.category.CategoryNotRef;
import com.only4.domain.aggregates.category.Category;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * 删除分类
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/16
 */
public class DeleteCategoryCmd {

    /**
     * DeleteCategoryCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            Mediator.repositories()
                    .findOne(JpaPredicate.byId(Category.class, cmd.getCategoryId()))
                    .ifPresent(category -> {
                        category.delete();
                        Mediator.uow().persist(category);
                    });

            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * DeleteCategoryCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        @CategoryExists
        @CategoryNotRef
        Long categoryId;
    }

    /**
     * DeleteCategoryCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
