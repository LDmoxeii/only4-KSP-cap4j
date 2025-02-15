package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.member.events.MemberRegisteredWhitPhoneDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Member.MemberRegisteredWhitPhoneDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class MemberRegisteredWhitPhoneDomainEventSubscriber {

    @EventListener(MemberRegisteredWhitPhoneDomainEvent.class)
    public void on(MemberRegisteredWhitPhoneDomainEvent event) {
        
    }

}
