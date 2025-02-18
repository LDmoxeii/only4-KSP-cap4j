package com.only4.application.subscribers.domain;

import com.only4.application.commands.member.UpdateFavoritesArticleCountCmd;
import com.only4.domain.aggregates.member.events.ArticleRemovedFromFavoritesDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Member.ArticleRemovedFromFavoritesDomainEvent领域事件订阅
 * 文章已从收藏夹中移除
 */
@Service
@RequiredArgsConstructor
public class ArticleRemovedFromFavoritesDomainEventSubscriber {

    @EventListener(ArticleRemovedFromFavoritesDomainEvent.class)
    public void updateFavoritesArticleCount(ArticleRemovedFromFavoritesDomainEvent event) {
        val member = event.getEntity();
        val favoritesId = event.getFavoritesId();

        Optional.of(UpdateFavoritesArticleCountCmd.Request.builder()
                .memberId(member.getId())
                .FavoritesId(favoritesId)
                .ArticleCount(-1)
                .build())
                .ifPresent(Mediator.commands()::send);
    }

}
