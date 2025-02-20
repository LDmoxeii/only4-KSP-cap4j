package com.only4.application.subscribers.domain;

import com.only4.application.commands.member.UpdateMemberFanCountCmd;
import com.only4.domain.aggregates.member.events.MemberFollowedDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Member.MemberFollowedDomainEvent领域事件订阅
 * 用户关注了另一个
 */
@Service
@RequiredArgsConstructor
public class MemberFollowedDomainEventSubscriber {

    @EventListener(MemberFollowedDomainEvent.class)
    public void updateMemberFollowerCount(MemberFollowedDomainEvent event) {
        val otherId = event.getOtherId();

        Optional.ofNullable(UpdateMemberFanCountCmd.Request.builder()
                .memberId(otherId)
                .fanCount(1)
                .build())
                .ifPresent(Mediator.commands()::send);
    }

}
