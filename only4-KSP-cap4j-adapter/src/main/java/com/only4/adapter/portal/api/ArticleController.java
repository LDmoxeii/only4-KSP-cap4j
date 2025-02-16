package com.only4.adapter.portal.api;

import cn.dev33.satoken.annotation.SaIgnore;
import com.only4.adapter.portal.api._share.ResponseData;
import com.only4.application.commands.article.CreateArticleCmd;
import com.only4.application.commands.article.CreateArticleCommentCmd;
import com.only4.application.commands.article.DeleteArticleCommentCmd;
import com.only4.domain.aggregates.article.ArticleAuthor;
import com.only4.domain.aggregates.article.enums.ArticleVisibility;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
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
        Optional.ofNullable(CreateArticleCmd.Request.builder()
                        .title("Test Title")
                        .description("Test Description")
                        .content("Test Content")
                        .visibility(ArticleVisibility.PUBLISH)
                        .stickyFlag(true)
                        .commentFlag(false)
                        .cover("cover.jpg")
                        .appendix("appendix.pdf")
                        .authors(Collections.singletonList(ArticleAuthor.builder()
                                .authorId(1L)
                                .authorName("Author")
                                .build())
                        )
                        .categories(Collections.emptyList())
                        .price(99L)
                        .tags(Collections.emptyList())
                        .build())
                .ifPresent(Mediator.commands()::send);
        return null;
    }

    @GetMapping("createArticleCommentTest")
    public ResponseData<?> createArticleComment() {
        Optional.ofNullable(CreateArticleCommentCmd.Request.builder()
                        .parentId(0L)
                        .memberId(1L)
                        .memberName("Author")
                        .articleId(138048748285591552L)
                        .content("Test Comment")
                        .createAt(LocalDateTime.now())
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
