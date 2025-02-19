package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.view_history.events.ViewHistoryCreatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * ViewHistory.ViewHistoryCreatedDomainEvent领域事件订阅
 * 浏览记录已创建
 */
@Service
@RequiredArgsConstructor
public class ViewHistoryCreatedDomainEventSubscriber {

    @EventListener(ViewHistoryCreatedDomainEvent.class)
    public void on(ViewHistoryCreatedDomainEvent event) {
        
    }

}
