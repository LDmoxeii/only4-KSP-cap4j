package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.member.events.MemberRankUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Member.MemberRankUpdatedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class MemberRankUpdatedDomainEventSubscriber {

    @EventListener(MemberRankUpdatedDomainEvent.class)
    public void on(MemberRankUpdatedDomainEvent event) {
        
    }

}
