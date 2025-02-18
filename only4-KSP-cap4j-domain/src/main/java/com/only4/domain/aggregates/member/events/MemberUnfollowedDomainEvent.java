package com.only4.domain.aggregates.member.events;

import com.only4.domain.aggregates.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * Member.MemberUnfollowedDomainEvent领域事件
 * 用户已取消关注另一个
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/14
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "Member", name = "MemberUnfollowedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberUnfollowedDomainEvent {
    Member entity;

    Long otherId;
}
