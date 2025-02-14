package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.member.events.MemberRegisteredWithPasswordDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Member.MemberRegisteredWithPasswordDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class MemberRegisteredWithPasswordDomainEventSubscriber {

    @EventListener(MemberRegisteredWithPasswordDomainEvent.class)
    public void on(MemberRegisteredWithPasswordDomainEvent event) {
        
    }

}
