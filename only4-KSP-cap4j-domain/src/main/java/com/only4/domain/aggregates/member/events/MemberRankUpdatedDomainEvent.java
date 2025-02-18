package com.only4.domain.aggregates.member.events;

import com.only4.domain.aggregates.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * Member.MemberRankUpdatedDomainEvent领域事件
 * 用户等级分已更新
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/14
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "Member", name = "MemberRankUpdatedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberRankUpdatedDomainEvent {
    Member entity;

    Integer newRank;
}
