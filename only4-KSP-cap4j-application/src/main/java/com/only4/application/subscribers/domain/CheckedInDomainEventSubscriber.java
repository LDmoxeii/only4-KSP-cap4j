package com.only4.application.subscribers.domain;

import com.only4.application.commands.member.UpdateMemberRankCmd;
import com.only4.domain.aggregates.check_in.CheckIn;
import com.only4.domain.aggregates.check_in.events.CheckedInDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * CheckIn.CheckedInDomainEvent领域事件订阅
 * 已签到
 */
@Service
@RequiredArgsConstructor
public class CheckedInDomainEventSubscriber {

    @EventListener(CheckedInDomainEvent.class)
    public void updateMemberRank(CheckedInDomainEvent event) {
        CheckIn record = event.getEntity();
        Integer rank = event.getRank();

        Optional.of(UpdateMemberRankCmd.Request.builder()
                        .memberId(record.getMemberId())
                        .rank(rank)
                        .build())
                .ifPresent(Mediator.commands()::send);
    }

}
