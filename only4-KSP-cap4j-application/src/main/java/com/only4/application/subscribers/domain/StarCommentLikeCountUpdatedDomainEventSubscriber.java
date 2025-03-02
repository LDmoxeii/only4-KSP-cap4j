package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.star_comment.events.StarCommentLikeCountUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * StarComment.StarCommentLikeCountUpdatedDomainEvent领域事件订阅
 * 星球评论点赞数已更新
 */
@Service
@RequiredArgsConstructor
public class StarCommentLikeCountUpdatedDomainEventSubscriber {

    @EventListener(StarCommentLikeCountUpdatedDomainEvent.class)
    public void updateStarLikeCount(StarCommentLikeCountUpdatedDomainEvent event) {
        //TODO: 更新星球点赞数
    }

}
