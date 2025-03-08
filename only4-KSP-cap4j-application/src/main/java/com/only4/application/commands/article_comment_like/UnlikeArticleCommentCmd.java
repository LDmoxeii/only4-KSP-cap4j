package com.only4.application.commands.article_comment_like;


import com.only4.application.validater.ArticleCommentExists;
import com.only4.application.validater.MemberExists;
import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.article_comment_like.ArticleCommentLike;
import com.only4.domain.aggregates.article_comment_like.meta.ArticleCommentLikeSchema;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * 取消点赞文章评论
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
public class UnlikeArticleCommentCmd {

    /**
     * UnlikeArticleCommentCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            ArticleCommentLike like = Mediator.repositories()
                    .findOne(JpaPredicate.bySpecification(ArticleCommentLike.class,
                            ArticleCommentLikeSchema.specify(schema ->
                                    schema.all(
                                            schema.memberId().eq(cmd.getMemberId()),
                                            schema.articleCommentId().eq(cmd.getCommentId())
                                    ))
                    )).orElseThrow(() -> new KnownException("点赞记录不存在"));

            like.delete();
            Mediator.uow().remove(like);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * UnlikeArticleCommentCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        @MemberExists
        Long memberId;

        @ArticleCommentExists
        Long commentId;
    }

    /**
     * UnlikeArticleCommentCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
