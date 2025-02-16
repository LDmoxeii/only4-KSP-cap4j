package com.only4.adapter.portal.api;

import cn.dev33.satoken.annotation.SaIgnore;
import com.only4.adapter.portal.api._share.ResponseData;
import com.only4.application.commands.article.CreateArticleCmd;
import com.only4.application.commands.article.CreateArticleCommentCmd;
import com.only4.application.commands.article.DeleteArticleCommentCmd;
import com.only4.domain.aggregates.article.ArticleAuthor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

/**
 * @author LD_moxeii
 */
@Slf4j
@SaIgnore
@RestController
@RequestMapping("article")
public class ArticleController {

    @GetMapping("createArticleTest")
    public ResponseData<?> createArticle() {
        return Optional.of(CreateArticleCmd.Request.builder()
                        .title("Test Title")
                        .description("Test Description")
                        .content("Test Content")
                        .authors(Collections.singletonList(ArticleAuthor.builder()
                                .authorId(1L)
                                .authorName("Author")
                                .build())
                        )
                        .build())
                .map(request -> {
                    val response = Mediator.commands().send(request);
                    return ResponseData.success(response);
                }).orElse(ResponseData.fail("创建文章失败"));
    }

    @GetMapping("createArticleCommentTest")
    public ResponseData<?> createArticleComment() {
        Optional.ofNullable(CreateArticleCommentCmd.Request.builder()
                        .parentId(0L)
                        .memberId(1L)
                        .memberName("Author")
                        .articleId(138370173508780032L)
                        .content("Test Comment")
                        .build())
                .ifPresent(Mediator.commands()::send);
        return null;
    }

    @DeleteMapping("deleteArticleCommentTest")
    public ResponseData<?> deleteArticleComment() {
        Optional.ofNullable(DeleteArticleCommentCmd.Request.builder()
                        .memberId(1L)
                        .articleId(138048748285591552L)
                        .commentId(138051928897617920L)
                        .build())
                .ifPresent(Mediator.commands()::send);
        return null;
    }
}
