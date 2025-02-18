package com.only4.application.subscribers.domain;

import com.only4.application.commands.member.UpdateFavoritesArticleCountCmd;
import com.only4.domain.aggregates.member.events.ArticleAddedToFavoritesDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Member.ArticleAddedToFavoritesDomainEvent领域事件订阅
 * 文章已收藏进收藏夹
 */
@Service
@RequiredArgsConstructor
public class ArticleAddedToFavoritesDomainEventSubscriber {

    @EventListener(ArticleAddedToFavoritesDomainEvent.class)
    public void updateFavoritesArticleCount(ArticleAddedToFavoritesDomainEvent event) {
        val member = event.getEntity();
        val favoritesId = event.getFavoritesId();

        Optional.ofNullable(UpdateFavoritesArticleCountCmd.Request.builder()
                .memberId(member.getId())
                .FavoritesId(favoritesId)
                .ArticleCount(1)
                .build())
                .ifPresent(Mediator.commands()::send);
    }

}
