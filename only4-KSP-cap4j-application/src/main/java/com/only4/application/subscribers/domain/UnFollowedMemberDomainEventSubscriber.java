package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.member.events.UnFollowedMemberDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Member.UnFollowedMemberDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class UnFollowedMemberDomainEventSubscriber {

    @EventListener(UnFollowedMemberDomainEvent.class)
    public void on(UnFollowedMemberDomainEvent event) {
        
    }

}
