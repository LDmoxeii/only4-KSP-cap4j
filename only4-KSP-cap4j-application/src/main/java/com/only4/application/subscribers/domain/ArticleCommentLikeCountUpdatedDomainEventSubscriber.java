package com.only4.application.subscribers.domain;

import com.only4.application.commands.member.UpdateMemberLikeCountCmd;
import com.only4.domain.aggregates.article_comment.ArticleComment;
import com.only4.domain.aggregates.article_comment.events.ArticleCommentLikeCountUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ArticleComment.ArticleCommentLikeCountUpdatedDomainEvent领域事件订阅
 * 文章评论点赞数已更新
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentLikeCountUpdatedDomainEventSubscriber {

    @EventListener(ArticleCommentLikeCountUpdatedDomainEvent.class)
    public void updateMemberLikeCount(ArticleCommentLikeCountUpdatedDomainEvent event) {
        ArticleComment comment = event.getEntity();
        Integer likeCount = event.getLikeCount();

        Optional.of(UpdateMemberLikeCountCmd.Request.builder()
                .memberId(comment.getAuthorId())
                .likeCount(likeCount)
                .build())
                .ifPresent(Mediator.commands()::send);
    }

}
