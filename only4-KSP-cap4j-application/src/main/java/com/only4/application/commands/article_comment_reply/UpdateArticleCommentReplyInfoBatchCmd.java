package com.only4.application.commands.article_comment_reply;


import com.only4.application.validater.MemberExists;
import com.only4.domain.aggregates.article_comment_reply.meta.ArticleCommentReplySchema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

/**
 * 批量更新文章评论回复信息
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/22
 */
public class UpdateArticleCommentReplyInfoBatchCmd {

    /**
     * UpdateArticleCommentReplyInfoBatchCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            Mediator.repositories()
                    .find(ArticleCommentReplySchema.predicateByIds(cmd.getArticleCommentReplyIds()))
                    .forEach(articleCommentReply -> {
                        articleCommentReply.updateInfo(cmd.getAuthorId(), cmd.getAuthorName());
                        Mediator.uow().persist(articleCommentReply);
                    });

            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * UpdateArticleCommentReplyInfoBatchCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        @NotEmpty(message = "文章评论回复ID列表不能为空")
        Iterable<Long> articleCommentReplyIds;

        @Positive
        @MemberExists
        Long authorId;

        @NotBlank(message = "作者名称不能为空")
        String authorName;
    }

    /**
     * UpdateArticleCommentReplyInfoBatchCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
