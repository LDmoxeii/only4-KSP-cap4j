package com.only4.application.commands.category;


import com.only4.application.validater.CategoryUniqueName;
import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.category.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

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
            Category category = Mediator.repositories()
                    .findOne(JpaPredicate.byId(Category.class, cmd.getCategoryId()))
                    .orElseThrow(() -> new KnownException("分类不存在"));

            category.updateInfo(cmd.getCategoryName());
            Mediator.uow().persist(category);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
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

        @NotBlank(message = "分类名不能为空")
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
