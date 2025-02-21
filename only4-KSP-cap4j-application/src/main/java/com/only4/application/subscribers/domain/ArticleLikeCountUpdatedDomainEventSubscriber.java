package com.only4.application.subscribers.domain;

import com.only4.application.commands.member.UpdateMemberLikeCountCmd;
import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.article.events.ArticleLikeCountUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Article.ArticleLikeCountUpdatedDomainEvent领域事件订阅
 * 文章评论已更新
 */
@Service
@RequiredArgsConstructor
public class ArticleLikeCountUpdatedDomainEventSubscriber {

    @EventListener(ArticleLikeCountUpdatedDomainEvent.class)
    public void updateMemberLikeCount(ArticleLikeCountUpdatedDomainEvent event) {
        Article article = event.getEntity();
        Integer likeCount = event.getLikeCount();

        article.getArticleAuthors().forEach(author ->
                Optional.of(UpdateMemberLikeCountCmd.Request.builder()
                                .memberId(author.getAuthorId())
                                .likeCount(likeCount)
                                .build())
                        .ifPresent(Mediator.commands()::send)
        );
    }

}
