package com.only4.application.commands.category;


import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.category.Category;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * 更新分类引用数
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/18
 */
public class UpdateCategoryRefCountCmd {

    /**
     * UpdateCategoryRefCountCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            Category category = Mediator.repositories()
                    .findOne(JpaPredicate.byId(Category.class, cmd.getCategoryId()))
                    .orElseThrow(() -> new KnownException("分类不存在"));

            category.updateRefCount(cmd.getRefCount());
            Mediator.uow().persist(category);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * UpdateCategoryRefCountCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        Long categoryId;

        @NotNull
        Integer refCount;
    }

    /**
     * UpdateCategoryRefCountCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
