package com.only4.application.subscribers.domain;

import com.only4.application.commands.star.UpdateStarLikeCountCmd;
import com.only4.domain.aggregates.star_comment_like.StarCommentLike;
import com.only4.domain.aggregates.star_comment_like.events.StarCommentLikedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * StarCommentLike.StarCommentLikedDomainEvent领域事件订阅
 * 已点赞星球评论
 */
@Service
@RequiredArgsConstructor
public class StarCommentLikedDomainEventSubscriber {

    @EventListener(StarCommentLikedDomainEvent.class)
    public void updateStarLikeCount(StarCommentLikedDomainEvent event) {
        StarCommentLike record = event.getEntity();

        Optional.of(UpdateStarLikeCountCmd.Request.builder()
                .starId(record.getStarId())
                .likeCount(1)
                .build()).ifPresent(Mediator.commands()::send);
    }

}
