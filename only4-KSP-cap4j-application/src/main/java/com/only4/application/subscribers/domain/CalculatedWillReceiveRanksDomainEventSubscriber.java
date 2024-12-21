package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.member.events.CalculatedWillReceiveRanksDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Member.CalculatedWillReceiveRanksDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class CalculatedWillReceiveRanksDomainEventSubscriber {

    @EventListener(CalculatedWillReceiveRanksDomainEvent.class)
    public void on(CalculatedWillReceiveRanksDomainEvent event) {
        
    }

}
