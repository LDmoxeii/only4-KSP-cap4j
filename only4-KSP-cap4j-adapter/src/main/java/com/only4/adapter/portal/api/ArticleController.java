package com.only4.adapter.portal.api;

import cn.dev33.satoken.annotation.SaIgnore;
import com.only4.adapter.portal.api._share.ResponseData;
import com.only4.adapter.portal.api.request.CreateArticleRequest;
import com.only4.application.commands.article.CreateArticleCmd;
import com.only4.application.commands.article.UpdateArticleTagsCmd;
import com.only4.domain.aggregates.article.ArticleAuthor;
import com.only4.domain.aggregates.tag.Tag;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author LD_moxeii
 */
@Slf4j
@SaIgnore
@RestController
@RequestMapping("article")
public class ArticleController {

    @GetMapping("createArticleTest")
    public ResponseData<?> createArticle(CreateArticleRequest request) {
        List<ArticleAuthor> articleAuthors = request.getAuthors().stream()
                .map(articleAuthorDto -> ArticleAuthor.builder()
                        .authorId(articleAuthorDto.getId())
                        .authorName(articleAuthorDto.getName())
                        .build())
                .collect(Collectors.toList());


        CreateArticleCmd.Response response = Mediator.commands()
                .send(CreateArticleCmd.Request.builder()
                        .title(request.getTitle())
                        .description(request.getDescription())
                        .content(request.getContent())
                        .authors(articleAuthors)
                        .build());

        return ResponseData.success(response);
    }

    @GetMapping("updateArticleTagsTest")
    public ResponseData<?> updateArticleTags() {
        Tag tag = Tag.builder()
                .id(1L)
                .name("Tag")
                .build();

        return Optional.of(UpdateArticleTagsCmd.Request.builder()
                        .articleId(139518204362883072L)
                        .tags(Collections.singletonList(tag))
                        .build())
                .map(request -> {
                    val response = Mediator.commands().send(request);
                    return ResponseData.success(response);
                }).orElse(ResponseData.fail("创建文章失败"));
    }
}
