package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleViewCountCmd;
import com.only4.domain.aggregates.view_history.ViewHistory;
import com.only4.domain.aggregates.view_history.events.ViewHistoryCreatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ViewHistory.ViewHistoryCreatedDomainEvent领域事件订阅
 * 浏览记录已创建
 */
@Service
@RequiredArgsConstructor
public class ViewHistoryCreatedDomainEventSubscriber {

    @EventListener(ViewHistoryCreatedDomainEvent.class)
    public void updateArticleViewCount(ViewHistoryCreatedDomainEvent event) {
        ViewHistory record = event.getEntity();

        Optional.of(UpdateArticleViewCountCmd.Request.builder()
                .articleId(record.getArticleId())
                .viewCount(1)
                .build())
                .ifPresent(Mediator.commands()::send);
    }

}
