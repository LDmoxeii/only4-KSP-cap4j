package com.only4.application.commands.category;


import com.only4.application.validater.category.CategoryUniqueName;
import com.only4.domain.aggregates.category.Category;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 更新分类信息
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/16
 */
public class UpdateCategoryInfoCmd {

    /**
     * UpdateCategoryInfoCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            return Optional.ofNullable(Mediator.repositories()
                            .findOne(JpaPredicate.byId(Category.class, cmd.getCategoryId()))
                            .orElseThrow(() -> new RuntimeException("分类不存在")))
                    .map(category -> {
                        category.updateCategoryInfo(cmd.getCategoryName());
                        Mediator.uow().persist(category);

                        Mediator.uow().save();

                        return Response.builder()
                                .success(true)
                                .build();
                    }).orElseThrow(RuntimeException::new);
        }
    }

    /**
     * UpdateCategoryInfoCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        Long categoryId;

        @CategoryUniqueName
        String categoryName;
    }

    /**
     * UpdateCategoryInfoCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
