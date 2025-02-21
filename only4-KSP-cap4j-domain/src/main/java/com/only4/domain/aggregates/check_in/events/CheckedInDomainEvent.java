package com.only4.domain.aggregates.check_in.events;

import com.only4.domain.aggregates.check_in.CheckIn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * CheckIn.CheckedInDomainEvent领域事件
 * 已签到
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "CheckIn", name = "CheckedInDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckedInDomainEvent {
    CheckIn entity;

    Integer rank;
}
