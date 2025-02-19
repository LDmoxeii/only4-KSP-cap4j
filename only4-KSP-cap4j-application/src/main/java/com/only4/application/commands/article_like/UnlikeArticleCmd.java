package com.only4.application.commands.article_like;


import com.only4._share.exception.KnownException;
import com.only4.application.validater.ArticleExists;
import com.only4.application.validater.MemberExists;
import com.only4.domain.aggregates.article_like.ArticleLike;
import com.only4.domain.aggregates.article_like.meta.ArticleLikeSchema;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * 取消点赞文章
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
public class UnlikeArticleCmd {

    /**
     * UnlikeArticleCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            ArticleLike like = Mediator.repositories()
                    .findOne(JpaPredicate.bySpecification(ArticleLike.class,
                            ArticleLikeSchema.specify(schema ->
                                    schema.all(
                                            schema.articleId().equal(cmd.getArticleId()),
                                            schema.memberId().equal(cmd.getMemberId())
                                    ))
                    ))
                    .orElseThrow(() -> new KnownException("点赞记录不存在"));

            like.delete();
            Mediator.uow().remove(like);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * UnlikeArticleCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        @MemberExists
        Long memberId;

        @ArticleExists
        Long articleId;
    }

    /**
     * UnlikeArticleCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
