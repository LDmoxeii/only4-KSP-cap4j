package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.category.events.CategoryInfoUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Category.CategoryInfoUpdatedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class CategoryInfoUpdatedDomainEventSubscriber {

    @EventListener(CategoryInfoUpdatedDomainEvent.class)
    public void on(CategoryInfoUpdatedDomainEvent event) {
        
    }

}
