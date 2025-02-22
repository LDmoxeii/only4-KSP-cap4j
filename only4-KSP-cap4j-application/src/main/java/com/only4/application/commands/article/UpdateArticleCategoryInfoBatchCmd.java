package com.only4.application.commands.article;


import com.only4.application.validater.CategoryExists;
import com.only4.domain.aggregates.article.meta.ArticleSchema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

/**
 * 批量更新文章分类信息
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/22
 */
public class UpdateArticleCategoryInfoBatchCmd {

    /**
     * UpdateArticleCategoryInfoBatchCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            Mediator.repositories()
                    .find(ArticleSchema.predicateByIds(cmd.getArticleIds()))
                    .forEach(article -> {
                        article.updateCategoryInfo(cmd.getCategoryId(), cmd.getCategoryName());
                        Mediator.uow().persist(article);
                    });

            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * UpdateArticleCategoryInfoBatchCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        Iterable<Long> articleIds;

        @Positive
        @CategoryExists
        Long categoryId;

        @NotBlank(message = "分类名称不能为空")
        String categoryName;
    }

    /**
     * UpdateArticleCategoryInfoBatchCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
