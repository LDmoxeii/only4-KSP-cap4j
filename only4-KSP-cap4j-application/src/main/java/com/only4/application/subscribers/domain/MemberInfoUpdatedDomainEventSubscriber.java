package com.only4.application.subscribers.domain;

import com.only4.application.commands.member.UpdateBlackMemberInfoCmd;
import com.only4.application.commands.member.UpdateFollowMemberInfoCmd;
import com.only4.domain._share.meta.Schema;
import com.only4.domain.aggregates.member.Member;
import com.only4.domain.aggregates.member.events.MemberInfoUpdatedDomainEvent;
import com.only4.domain.aggregates.member.meta.MemberSchema;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Member.MemberInfoUpdatedDomainEvent领域事件订阅
 * 用户信息已更新
 */
@Service
@RequiredArgsConstructor
public class MemberInfoUpdatedDomainEventSubscriber {

    @EventListener(MemberInfoUpdatedDomainEvent.class)
    public void updateBlackMemberInfo(MemberInfoUpdatedDomainEvent event) {
        val other = event.getEntity();

        Mediator.repositories()
                .find(JpaPredicate.bySpecification(Member.class,
                        MemberSchema.specify(member ->
                        member.joinBlockMember(Schema.JoinType.INNER)
                                .otherId().equal(other.getId())
                        )))
                .forEach(member -> Optional.of(UpdateBlackMemberInfoCmd.Request.builder()
                        .memberId(member.getId())
                        .otherId(other.getId())
                        .otherName(other.getName())
                        .build())
                        .ifPresent(Mediator.commands()::send));
    }

    @EventListener(MemberInfoUpdatedDomainEvent.class)
    public void updateFollowMemberInfo(MemberInfoUpdatedDomainEvent event) {
        val other = event.getEntity();

        Mediator.repositories()
                .find(JpaPredicate.bySpecification(Member.class,
                        MemberSchema.specify(member ->
                        member.joinFollowMember(Schema.JoinType.INNER)
                                .otherId().equal(other.getId())
                        )))
                .forEach(member -> Optional.of(UpdateFollowMemberInfoCmd.Request.builder()
                        .memberId(member.getId())
                        .otherId(other.getId())
                        .otherName(other.getName())
                        .build())
                        .ifPresent(Mediator.commands()::send)
                );
    }
}
