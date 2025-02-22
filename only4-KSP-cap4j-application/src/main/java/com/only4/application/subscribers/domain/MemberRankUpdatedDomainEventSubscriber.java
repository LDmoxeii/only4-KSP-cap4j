package com.only4.application.subscribers.domain;

import com.only4.application.commands.member.UpMemberLevelCmd;
import com.only4.domain.aggregates.member.events.MemberRankUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

/**
 * Member.MemberRankUpdatedDomainEvent领域事件订阅
 * 用户等级分已更新
 */
@Service
@RequiredArgsConstructor
public class MemberRankUpdatedDomainEventSubscriber {

    @EventListener(MemberRankUpdatedDomainEvent.class)
    public void upMemberLevel(MemberRankUpdatedDomainEvent event) {
        val member = event.getEntity();
        val newRank = event.getNewRank();

        val levelToRank = new HashMap<Integer, Integer>();
        levelToRank.put(1, 233);
        levelToRank.put(2, 3306);
        levelToRank.put(3, 8848);
        levelToRank.put(4, 50000);
        levelToRank.put(5, 66666);

        if (levelToRank.get(member.getLevel()) < newRank) {
            Optional.of(UpMemberLevelCmd.Request.builder()
                    .memberId(member.getId())
                    .build()).ifPresent(Mediator.commands()::send);
        }
    }

}
