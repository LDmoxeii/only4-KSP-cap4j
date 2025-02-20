package com.only4.application.subscribers.domain;

import com.only4.application.commands.member.UpdateMemberFanCountCmd;
import com.only4.domain.aggregates.member.events.MemberUnfollowedDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Member.MemberUnfollowedDomainEvent领域事件订阅
 * 用户取消关注另一个
 */
@Service
@RequiredArgsConstructor
public class MemberUnfollowedDomainEventSubscriber {

    @EventListener(MemberUnfollowedDomainEvent.class)
    public void updateMemberFanCount(MemberUnfollowedDomainEvent event) {
        val otherId = event.getOtherId();

        Optional.of(UpdateMemberFanCountCmd.Request.builder()
                .memberId(otherId)
                .fanCount(-1)
                .build())
                .ifPresent(Mediator.commands()::send);
    }

}
